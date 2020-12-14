package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class ResetEndpointTests {
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
    public void testDemoAdminPage_EndPoint() throws Throwable {

        // Purchaser login.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.switchToDemoAdminPage(driver);

        // Test categories endpoint connection.
        demoAdminPage.setEndPointField("categories",
                "http://localhost:/v1/assets/categories/");
        String result = demoAdminPage.returnEndpointFailMessage(WebUIConstants.CATEGORIES_ENDPOINT);
        assertEquals(WebUIConstants.INCORRECT_URL,result);
        demoAdminPage.resetEndpoint(WebUIConstants.CATEGORIES_ENDPOINT);
        assertEquals(Properties.DEFAULT_CATEGORIES_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.CATEGORIES_ENDPOINT));

        // Test items endpoint connection.
        demoAdminPage.setEndPointField("items",
                "http://localhost:/v1/assets/items/");
        result = demoAdminPage.returnEndpointFailMessage(WebUIConstants.ITEMS_ENDPOINT);
        assertEquals(WebUIConstants.INCORRECT_URL,result);
        demoAdminPage.resetEndpoint(WebUIConstants.ITEMS_ENDPOINT);
        assertEquals(Properties.DEFAULT_ITEMS_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.ITEMS_ENDPOINT));

        // Test cart items endpoint connection.
        demoAdminPage.setEndPointField("cart_items",
                "http://localhost:/v1/cartitems/");
        result = demoAdminPage.returnEndpointFailMessage(WebUIConstants.CART_ITEMS_ENDPOINT);
        assertEquals(WebUIConstants.INCORRECT_URL,result);
        demoAdminPage.resetEndpoint(WebUIConstants.CART_ITEMS_ENDPOINT);
        assertEquals(Properties.DEFAULT_CART_ITEMS_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.CART_ITEMS_ENDPOINT));
        // Test orders endpoint connection.
        demoAdminPage.setEndPointField("orders",
                "http://localhost:/v1/orders/");
        result = demoAdminPage.returnEndpointFailMessage(WebUIConstants.ORDERS_ENDPOINT);
        assertEquals(WebUIConstants.INCORRECT_URL,result);
        demoAdminPage.resetEndpoint(WebUIConstants.ORDERS_ENDPOINT);
        assertEquals(Properties.DEFAULT_ORDERS_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.ORDERS_ENDPOINT));

        // Test locations endpoint connection.
        demoAdminPage.setEndPointField("locations",
                "http://localhost:/v1/locations/");
        result = demoAdminPage.returnEndpointFailMessage(WebUIConstants.LOCATIONS_ENDPOINT);
        assertEquals(WebUIConstants.INCORRECT_URL,result);
        demoAdminPage.resetEndpoint(WebUIConstants.LOCATIONS_ENDPOINT);
        assertEquals(Properties.DEFAULT_LOCATIONS_ENDPOINT_URL,
                demoAdminPage.returnEndPointFieldValue(WebUIConstants.LOCATIONS_ENDPOINT));

        // log out.
        GlobalUtils.switchToLogout(driver);
    }

    @Test
    public void testDemoAdminPage_resetIncorrectEndPoint() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        OrderWizardPage orderWizardPage = new OrderWizardPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        HeaderArea headerArea = new HeaderArea(driver);
        CartPage cartPage = new CartPage(driver);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        NotFoundErrorPage notFoundErrorPage = new NotFoundErrorPage(driver);
        GlobalUtils.switchToDemoAdminPage(driver);

        String categories_incorrect_endpoint_url = "http://localhost:8088/v1/assets/categories/";
        String items_incorrect_endpoint_url = "http://localhost:8088/v1/assets/items/";
        String cart_items_incorrect_endpoint_url = "http://localhost:8088/v1/cartItems";
        String orders_incorrect_endpoint_url = "http://localhost:8088/v1/orders/";
        String locations_incorrect_endpoint_url = "http://localhost:8088/v1/locations/";

        // Reset categories endpoint.
        demoAdminPage.setEndPointField("categories", categories_incorrect_endpoint_url);
        demoAdminPage.setEndPointField("items", items_incorrect_endpoint_url);
        demoAdminPage.setEndPointField("cart_items", cart_items_incorrect_endpoint_url);
        demoAdminPage.setEndPointField("orders", orders_incorrect_endpoint_url);
        demoAdminPage.setEndPointField("locations", locations_incorrect_endpoint_url);
        demoAdminPage.clickSaveChangesButton();
        demoAdminPage.switchToCategoryTab();
        assertEquals(0,demoAdminPage.defaultDataList.size());
        demoAdminPage.switchToItemsTab();
        assertEquals(0,demoAdminPage.defaultDataList.size());
        GlobalUtils.switchToHomepage(driver);
        ElementUtils.waitUntilVisible(driver,purchaserHomePage.incorrectCategoriesEndpoint,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("Categories REST endpoint error: "+ categories_incorrect_endpoint_url +" is unavailable to connect.",
                purchaserHomePage.incorrectCategoriesEndpoint.getText());
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.submitButton,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(cartPage.submitButton.isEnabled());
        headerArea.closeCartPopup();
        GlobalUtils.switchToDifferentURL(driver,Properties.BASE_URL+"/categories/1");
        ElementUtils.waitUntilVisible(driver,categoryPage.incorrectItemsEndpoint,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,categoryPage.incorrectLocationsEndpoint,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("Items REST endpoint error: "+ items_incorrect_endpoint_url +" is unavailable to connect.",
                categoryPage.incorrectItemsEndpoint.getText());
        assertEquals("Locations REST endpoint error: "+ locations_incorrect_endpoint_url +" is unavailable to connect.",
                categoryPage.incorrectLocationsEndpoint.getText());
        GlobalUtils.switchToDifferentURL(driver,Properties.BASE_URL+"/items/1");
        ElementUtils.waitUntilVisible(driver,itemDetailPage.incorrectItemsEndpoint,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("Items REST endpoint error: "+ items_incorrect_endpoint_url +" is unavailable to connect.",
                categoryPage.incorrectItemsEndpoint.getText());
        GlobalUtils.switchToDifferentURL(driver,Properties.BASE_URL+"/categories/100");
        ElementUtils.waitUntilElementTextAppear(driver,notFoundErrorPage.message,
                WebUIConstants.NOT_FOUND_ERROR_MESSAGE,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.NOT_FOUND_ERROR_MESSAGE,notFoundErrorPage.message.getText());
        GlobalUtils.switchToDifferentURL(driver,Properties.BASE_URL+"/items/100");
        ElementUtils.waitUntilElementTextAppear(driver,notFoundErrorPage.message,
                WebUIConstants.NOT_FOUND_ERROR_MESSAGE,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.NOT_FOUND_ERROR_MESSAGE,notFoundErrorPage.message.getText());

        GlobalUtils.switchToDifferentURL(driver,Properties.BASE_URL+"/orderWizard");
        orderWizardPage.clickRegionDropDownButton();
        assertEquals(1,orderWizardPage.options.size());
        GlobalUtils.switchToOrdersPage(driver);
        ElementUtils.waitUntilVisible(driver,ordersPage.incorrectOrdersEndpoint,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        assertEquals("Orders REST endpoint error: "+ orders_incorrect_endpoint_url +" is unavailable to connect.",
                ordersPage.incorrectOrdersEndpoint.getText());
        GlobalUtils.switchToLogout(driver);
        GlobalUtils.login(driver, Properties.APPROVER_USERNAME, Properties.APPROVER_PASSWORD);
        ApproverHomePage approverHomePage = new ApproverHomePage(driver);
        ElementUtils.waitUntilVisible(driver,approverHomePage.incorrectOrdersEndpoint,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        assertEquals("Orders REST endpoint error: "+ orders_incorrect_endpoint_url +" is unavailable to connect.",
                approverHomePage.incorrectOrdersEndpoint.getText());

        // Reset endpoint and log out.
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.resetEndpoint("Categories");
        demoAdminPage.resetEndpoint("Items");
        demoAdminPage.resetEndpoint("Cart Items");
        demoAdminPage.resetEndpoint("Orders");
        demoAdminPage.resetEndpoint("Locations");
        demoAdminPage.clickSaveChangesButton();
        GlobalUtils.switchToLogout(driver);
    }
}
