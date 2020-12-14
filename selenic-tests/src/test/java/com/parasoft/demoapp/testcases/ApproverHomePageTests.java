package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.ApproverHomePage;
import com.parasoft.demoapp.pages.DemoAdminPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;


public class ApproverHomePageTests {
    private WebDriver driver;

    @BeforeEach
    public void beforeTest() {
        driver = WebDriverDecider.decide();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testApproverHomePage() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.APPROVER_USERNAME, Properties.APPROVER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        ApproverHomePage approverHomePage = new ApproverHomePage(driver);
        ElementUtils.waitUntilVisible(driver,approverHomePage.requisition,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,approverHomePage.currentPage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,approverHomePage.leftArrow,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.APPROVER_REQUISITION_REQUESTS,approverHomePage.requisition.getText());
        assertEquals(WebUIConstants.ORDER_STATUS,approverHomePage.statusLabel.getText());
        assertEquals(WebUIConstants.APPROVER_ORDER_REQ,approverHomePage.requisitionNumberLabel.getText());
        assertEquals(WebUIConstants.ORDER_SUBMISSION_DATE,approverHomePage.submissionDateLabel.getText());
        assertEquals(WebUIConstants.APPROVER_ORDER_TIME,approverHomePage.timeLabel.getText());
        assertEquals(0, approverHomePage.ordersList.size());
        assertEquals("true", approverHomePage.leftArrow.getAttribute("disabled"));
        assertEquals("true", approverHomePage.rightArrow.getAttribute("disabled"));
        assertEquals("0", approverHomePage.currentPage.getText());
        assertEquals("0", approverHomePage.totalPage.getText());
        assertEquals(WebUIConstants.ORDERS_PAGE_IS_EMPTY,approverHomePage.emptyErrorMessage.getText());
        String imagePath = approverHomePage.imagePath.getAttribute("src");
        String industry = "";
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            industry = "defense";
            assertEquals(Properties.BASE_URL + "/"+ industry +"/images/approver_map.svg",imagePath);
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            industry = "aerospace";
            assertEquals(Properties.BASE_URL + "/"+ industry +"/images/approver_map.svg",imagePath);
        }
        GlobalUtils.switchToLogout(driver);
    }
}
