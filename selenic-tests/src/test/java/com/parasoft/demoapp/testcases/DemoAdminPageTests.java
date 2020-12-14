package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertTrue;

public class DemoAdminPageTests {
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
    public void testDemoAdminPageUI() throws Throwable {

        // Purchaser login.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        demoAdminPage.setDefaultInfo();
        GlobalUtils.switchToDemoAdminPage(driver);

        // Verify demo admin page text information and buttons and links status.
        // Industry information.
        assertEquals(WebUIConstants.INDUSTRY_SITE_DESIGN,demoAdminPage.industrySideDesign.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(IndustryType.DEFENSE.toString(),demoAdminPage.currentIndustry.getText());
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(IndustryType.AEROSPACE.toString(),demoAdminPage.currentIndustry.getText());
        }
        // Label.
        assertEquals(WebUIConstants.GENERAL_LABEL,demoAdminPage.generalTab.getText());
        assertEquals(WebUIConstants.CATEGORIES_LABEL,demoAdminPage.categoryTab.getText());
        assertEquals(WebUIConstants.ITEMS_LABEL,demoAdminPage.itemsTab.getText());
        // Database part.
        assertEquals(WebUIConstants.DATABASE,demoAdminPage.database.getText());
        assertEquals(WebUIConstants.RESET_DATABASE_BUTTON,demoAdminPage.resetDatabase.getText());
        assertEquals(WebUIConstants.CLEAN_DATABASE_BUTTON,demoAdminPage.cleanDatabase.getText());
        assertTrue(demoAdminPage.resetDatabase.isEnabled());
        assertTrue(demoAdminPage.cleanDatabase.isEnabled());
        // Web service endpoint part.
        assertEquals(WebUIConstants.WEB_SERVICE_ENDPOINTS,demoAdminPage.webServiceEndpoint.getText());
        String labelName = demoAdminPage.returnEndPointLabelText(WebUIConstants.CATEGORIES_ENDPOINT);
        String resetButton = demoAdminPage.returnResetButtonText(WebUIConstants.CATEGORIES_ENDPOINT);
        assertEquals(WebUIConstants.CATEGORIES_ENDPOINT,labelName);
        assertEquals(WebUIConstants.RESET_BUTTON,resetButton);
        assertEquals(Properties.DEFAULT_CATEGORIES_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.CATEGORIES_ENDPOINT));
        labelName = demoAdminPage.returnEndPointLabelText(WebUIConstants.ITEMS_ENDPOINT);
        resetButton = demoAdminPage.returnResetButtonText(WebUIConstants.ITEMS_ENDPOINT);
        assertEquals(WebUIConstants.ITEMS_ENDPOINT,labelName);
        assertEquals(WebUIConstants.RESET_BUTTON,resetButton);
        assertEquals(Properties.DEFAULT_ITEMS_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.ITEMS_ENDPOINT));
        labelName = demoAdminPage.returnEndPointLabelText(WebUIConstants.CART_ITEMS_ENDPOINT);
        resetButton = demoAdminPage.returnResetButtonText(WebUIConstants.CATEGORIES_ENDPOINT);
        assertEquals(WebUIConstants.CART_ITEMS_ENDPOINT,labelName);
        assertEquals(WebUIConstants.RESET_BUTTON,resetButton);
        assertEquals(Properties.DEFAULT_CART_ITEMS_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.CART_ITEMS_ENDPOINT));
        labelName = demoAdminPage.returnEndPointLabelText(WebUIConstants.ORDERS_ENDPOINT);
        resetButton = demoAdminPage.returnResetButtonText(WebUIConstants.ORDERS_ENDPOINT);
        assertEquals(WebUIConstants.ORDERS_ENDPOINT,labelName);
        assertEquals(WebUIConstants.RESET_BUTTON,resetButton);
        assertEquals(Properties.DEFAULT_ORDERS_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.ORDERS_ENDPOINT));
        labelName = demoAdminPage.returnEndPointLabelText(WebUIConstants.LOCATIONS_ENDPOINT);
        resetButton = demoAdminPage.returnResetButtonText(WebUIConstants.LOCATIONS_ENDPOINT);
        assertEquals(WebUIConstants.LOCATIONS_ENDPOINT,labelName);
        assertEquals(WebUIConstants.RESET_BUTTON,resetButton);
        assertEquals(Properties.DEFAULT_LOCATIONS_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.LOCATIONS_ENDPOINT));
        assertEquals(true,demoAdminPage.returnEndpointResetButtonStatus(WebUIConstants.CATEGORIES_ENDPOINT));
        assertEquals(true,demoAdminPage.returnEndpointResetButtonStatus(WebUIConstants.ITEMS_ENDPOINT));
        assertEquals(true,demoAdminPage.returnEndpointResetButtonStatus(WebUIConstants.CART_ITEMS_ENDPOINT));
        assertEquals(true,demoAdminPage.returnEndpointResetButtonStatus(WebUIConstants.ORDERS_ENDPOINT));
        assertEquals(true,demoAdminPage.returnEndpointResetButtonStatus(WebUIConstants.LOCATIONS_ENDPOINT));
        // PARASOFT JDBC proxy part.
        assertEquals(WebUIConstants.PARASOFT_JDBC_PROXY,demoAdminPage.PARASOFTJDBCProxy.getText());
        assertEquals(WebUIConstants.JDBC_VIRTUALIZE_SERVER_PATH,demoAdminPage.JDBCProxyPathLabel.getText());
        assertEquals(WebUIConstants.JDBC_VIRTUALIZE_GROUP_ID,demoAdminPage.JDBCProxyGroupIDLabel.getText());
        assertEquals(WebUIConstants.JDBC_VIRTUALIZE_SERVER_URL,demoAdminPage.JDBCProxyURLLabel.getText());
        assertEquals(WebUIConstants.RESET_BUTTON,demoAdminPage.JDBCProxyPathResetButtons.getText());
        assertEquals(WebUIConstants.RESET_BUTTON,demoAdminPage.JDBCProxyGroupIDResetButtons.getText());
        assertEquals(WebUIConstants.RESET_BUTTON,demoAdminPage.JDBCProxyURLResetButtons.getText());
        assertEquals(WebUIConstants.TEST_CONNECT_BUTTON,demoAdminPage.JDBCProxyTestConnectButtons.getText());
        assertEquals(Properties.DEFAULT_PARASOFT_JDBC_PROXY_PATH,demoAdminPage.JDBCProxyPathInputFeild.getAttribute("value"));
        assertEquals(Properties.DEFAULT_PARASOFT_JDBC_PROXY_GROUP_ID,demoAdminPage.JDBCProxyGroupIDInputFeild.getAttribute("value"));
        assertEquals(Properties.DEFAULT_PARASOFT_JDBC_PROXY_URL,demoAdminPage.JDBCProxyURLInputFeild.getAttribute("value"));
        assertFalse(demoAdminPage.JDBCProxyPathResetButtons.isEnabled());
        assertFalse(demoAdminPage.JDBCProxyGroupIDResetButtons.isEnabled());
        assertFalse(demoAdminPage.JDBCProxyURLResetButtons.isEnabled());
        assertFalse(demoAdminPage.JDBCProxyTestConnectButtons.isEnabled());
        // Demo bugs part.
        assertEquals(WebUIConstants.DEMO_BUGS,demoAdminPage.demoBugs.getText());
        assertEquals(WebUIConstants.LOCATION_BUG_TEXT,demoAdminPage.locationBugText.getText());
        assertEquals(WebUIConstants.QUANTITY_BUG_TEXT,demoAdminPage.quantityBugText.getText());
        assertEquals("true",demoAdminPage.locationBugSelector.getAttribute("checked"));
        assertEquals("true",demoAdminPage.quantityBugSelector.getAttribute("checked"));
        // Save changes button
        assertEquals(WebUIConstants.SAVE_CHANGES_BUTTON,demoAdminPage.saveChangesButton.getText());
        assertTrue(demoAdminPage.saveChangesButton.isEnabled());
        // OpenAPI part.
        assertEquals(WebUIConstants.DEMO_APP_OPEN_API,demoAdminPage.demoAPPOpenAPI.getText());
        assertEquals(WebUIConstants.GATEWAY_OPEN_API,demoAdminPage.proxyOpenAPI.getText());
        assertTrue(demoAdminPage.demoAPPOpenAPI.isEnabled());
        assertTrue(demoAdminPage.proxyOpenAPI.isEnabled());
        // Advertisement and news part
        assertEquals(WebUIConstants.ADVERTISEMENT_AND_NEWS,demoAdminPage.advertisingAndNews.getText());
        assertEquals("true",demoAdminPage.showRatio.getAttribute("checked"));

        assertTrue(demoAdminPage.saveChangesButton.isEnabled());
        demoAdminPage.backToHomePage();

        // log out.
        GlobalUtils.switchToLogout(driver);
    }
}
