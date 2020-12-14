package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.DemoAdminPage;
import com.parasoft.demoapp.pages.OrdersPage;
import com.parasoft.demoapp.pages.PurchaserHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdersPageTests {
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
    public void testOrdersPage() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        GlobalUtils.switchToOrdersPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        ElementUtils.waitUntilVisible(driver,ordersPage.approverReplyDateLabel,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,ordersPage.currentPage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,ordersPage.leftArrow,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.PURCHASER_APPROVER_REPLY_DATE,ordersPage.approverReplyDateLabel.getText());
        assertEquals(WebUIConstants.ORDER_STATUS,ordersPage.statusLabel.getText());
        assertEquals(WebUIConstants.PURCHASER_ASSETS,ordersPage.assetsLabel.getText());
        assertEquals(WebUIConstants.ORDER_SUBMISSION_DATE,ordersPage.submissionDateLabel.getText());
        assertEquals(WebUIConstants.PURCHASER_REQUISITION_NUMBER,ordersPage.orderNumberLabel.getText());
        assertEquals(0, ordersPage.ordersList.size());
        assertEquals("true", ordersPage.leftArrow.getAttribute("disabled"));
        assertEquals("true", ordersPage.rightArrow.getAttribute("disabled"));
        assertEquals("0", ordersPage.currentPage.getText());
        assertEquals("0", ordersPage.totalPage.getText());
        assertEquals(WebUIConstants.ORDERS_PAGE_IS_EMPTY,ordersPage.emptyErrorMessage.getText());
        demoAdminPage.addNewOrder();
        driver.navigate().refresh();
        ElementUtils.waitUntilVisible(driver,ordersPage.statusLabel,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,ordersPage.currentPage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,ordersPage.leftArrow,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(1, ordersPage.ordersList.size());
        assertEquals("true", ordersPage.leftArrow.getAttribute("disabled"));
        assertEquals("true", ordersPage.rightArrow.getAttribute("disabled"));
        assertEquals("1", ordersPage.currentPage.getText());
        assertEquals("1", ordersPage.totalPage.getText());
        ordersPage.clickHomeLink();
        ElementUtils.waitUntilVisible(driver,purchaserHomePage.assetsTitle,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,purchaserHomePage.viewAllLink1,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertTrue(0<purchaserHomePage.categoriesList.size());
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToLogout(driver);
    }
}
