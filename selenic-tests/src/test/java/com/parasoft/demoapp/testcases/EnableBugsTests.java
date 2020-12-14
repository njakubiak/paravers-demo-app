package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.ApproverHomePage;
import com.parasoft.demoapp.pages.DemoAdminPage;
import com.parasoft.demoapp.pages.OrdersPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnableBugsTests {
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

    public void disableBugs()throws Throwable{
        String industryType = Properties.currentIndustry.toString();
        String advertisingEnabled = "true";
        Set<String> demoBugs = new HashSet<>();
        demoBugs.add("");
        String categoriesRestEndpoint = "";
        String itemsRestEndpoint = "";
        String cartItemsRestEndpoint = "";
        String ordersRestEndpoint = "";
        String locationsRestEndpoint = "";
        String useParasoftJDBCProxy = "false";
        String parasoftVirtualizeServerUrl = "http://localhost:9080";
        boolean result1 =GlobalUtils.setPreferences_disableBugs(driver,industryType,advertisingEnabled,demoBugs,
                categoriesRestEndpoint, itemsRestEndpoint,cartItemsRestEndpoint,ordersRestEndpoint,locationsRestEndpoint,
                useParasoftJDBCProxy, parasoftVirtualizeServerUrl);
        assertTrue(result1,"Fail to set reference.");
    }

    @Test
    public void testEnableBugsPosition() throws Throwable {

        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME,Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        demoAdminPage.addNewOrder();

        // Verify the bug s whether work
        GlobalUtils.switchToHomepage(driver);
        GlobalUtils.switchToOrdersPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.viewOrderDetail();
        assertEquals("0",ordersPage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,ordersPage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.EARTH_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.EARTH_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.EARTH_IMAGE,ordersPage.image.getAttribute("src"));
        }
        ordersPage.closeWindows();
        GlobalUtils.switchToLogout(driver);

        // Approve the order
        GlobalUtils.login(driver, Properties.APPROVER_USERNAME,Properties.APPROVER_PASSWORD);
        ApproverHomePage approverHomePage = new ApproverHomePage(driver);
        approverHomePage.viewOrderDetail();
        assertEquals("1",approverHomePage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,approverHomePage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.EARTH_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.EARTH_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.EARTH_IMAGE,approverHomePage.image.getAttribute("src"));
        }
        approverHomePage.clickResponse();
        approverHomePage.approveOrder();
        approverHomePage.clickSaveAndSendButton();
        ElementUtils.waitUntilVisible(driver,approverHomePage.requestedAssets,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("1",approverHomePage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,approverHomePage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.EARTH_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.EARTH_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.EARTH_IMAGE,approverHomePage.image.getAttribute("src"));
        }
        approverHomePage.closeWindows();
        approverHomePage.viewOrderDetail();
        ElementUtils.waitUntilVisible(driver,approverHomePage.requestedAssets,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("1",approverHomePage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.AUSTRALIA_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.AUSTRALIA_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.AUSTRALIA_IMAGE,approverHomePage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.NEPTUNE_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.NEPTUNE_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.NEPTUNE_IMAGE,approverHomePage.image.getAttribute("src"));
        }
        approverHomePage.closeWindows();
        GlobalUtils.switchToLogout(driver);
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME,Properties.PURCHASER_PASSWORD);
        GlobalUtils.switchToOrdersPage(driver);
        ordersPage.viewOrderDetail();
        assertEquals("1",ordersPage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.AUSTRALIA_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.AUSTRALIA_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.AUSTRALIA_IMAGE,ordersPage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.NEPTUNE_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.NEPTUNE_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.NEPTUNE_IMAGE,ordersPage.image.getAttribute("src"));
        }
        ordersPage.closeWindows();
        // Disable bugs
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.enableOrDisableBugs();
        GlobalUtils.switchToHomepage(driver);
        GlobalUtils.switchToOrdersPage(driver);
        ordersPage.viewOrderDetail();
        assertEquals("1",ordersPage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,ordersPage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.EARTH_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.EARTH_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.EARTH_IMAGE,ordersPage.image.getAttribute("src"));
        }
        ordersPage.closeWindows();
        GlobalUtils.switchToLogout(driver);
        GlobalUtils.login(driver, Properties.APPROVER_USERNAME,Properties.APPROVER_PASSWORD);
        approverHomePage.viewOrderDetail();
        assertEquals("1",approverHomePage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,approverHomePage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.EARTH_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.EARTH_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.EARTH_IMAGE,approverHomePage.image.getAttribute("src"));
        }
        approverHomePage.closeWindows();

        // Reset database and log out
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        GlobalUtils.switchToLogout(driver);
    }

    @Test
    public void testEnableBugsNegative() throws Throwable {

        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME,Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        demoAdminPage.addNewOrder();

        // Verify the bugs whether work
        GlobalUtils.switchToOrdersPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.viewOrderDetail();
        ordersPage.closeWindows();
        GlobalUtils.switchToLogout(driver);

        // Reject the order
        GlobalUtils.login(driver, Properties.APPROVER_USERNAME,Properties.APPROVER_PASSWORD);
        ApproverHomePage approverHomePage = new ApproverHomePage(driver);
        approverHomePage.viewOrderDetail();
        approverHomePage.clickResponse();
        approverHomePage.rejectOrder();
        approverHomePage.clickSaveAndSendButton();
        approverHomePage.closeWindows();
        approverHomePage.viewOrderDetail();
        assertEquals("1",approverHomePage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,approverHomePage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.EARTH_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.EARTH_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.EARTH_IMAGE,approverHomePage.image.getAttribute("src"));
        }
        approverHomePage.closeWindows();
        GlobalUtils.switchToLogout(driver);
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME,Properties.PURCHASER_PASSWORD);
        GlobalUtils.switchToOrdersPage(driver);
        ordersPage.viewOrderDetail();
        assertEquals("1",ordersPage.requestedAssets.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,ordersPage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.EARTH_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.EARTH_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.EARTH_IMAGE,ordersPage.image.getAttribute("src"));
        }
        ordersPage.closeWindows();

        // Reset database and log out
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToLogout(driver);
    }
}
