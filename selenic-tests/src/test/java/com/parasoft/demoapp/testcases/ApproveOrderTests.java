package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class ApproveOrderTests {
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

    /**
     * Purpose of the test is verify order detail after order is approved .
     * like result , comments.
     */
    @Test
    public void testApproveOrder() throws Throwable {

        // Purchaser login and submit order.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        ApproverHomePage approverHomePage = new ApproverHomePage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        HeaderArea headerArea = new HeaderArea(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        String orderNumber = "23-456-001";
        demoAdminPage.addNewOrder();
        GlobalUtils.switchToLogout(driver);

        // Approver login and approve order.
        GlobalUtils.login(driver,Properties.APPROVER_USERNAME,Properties.APPROVER_PASSWORD);
        approverHomePage.viewOrderDetail();
        approverHomePage.clickResponse();
        approverHomePage.approveOrder();
        approverHomePage.setReasonField("Approve.");
        approverHomePage.clickSaveAndSendButton();
        ElementUtils.waitUntilVisible(driver,approverHomePage.responseResult,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.APPROVED,approverHomePage.responseResult.getText());
        assertEquals("Approve.",approverHomePage.reason.getText());
        approverHomePage.closeWindows();
        GlobalUtils.switchToLogout(driver);

        // Purchaser login and view order detail.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        ElementUtils.waitUntilVisible(driver,headerArea.ordersNeedToView,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("1",headerArea.ordersNeedToView.getText());
        GlobalUtils.switchToOrdersPage(driver);
        ElementUtils.waitUntilVisible(driver,ordersPage.orderNumber_1,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,driver.findElement(By.xpath("//table/tbody/tr[*]/th/a" +
                "[text()='"+orderNumber+"']/ancestor ::tr/td/span[@class='new_label new_label1']")),
                Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("New",driver.findElement(By.xpath("//table/tbody/tr[*]/th/a[text()='"+orderNumber+"']" +
                "/ancestor ::tr/td/span[@class='new_label new_label1']")).getText());
        ordersPage.viewOrderDetail();
        assertEquals("Approve.",ordersPage.comments.getText());
        assertTrue(ordersPage.orderTitle.getText().contains(WebUIConstants.ORDER_TITLE_APPROVE));
        ordersPage.closeWindows();

        // Reset database and log out.
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToLogout(driver);
    }
}
