package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTests {
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
    public void testDatabase() throws Throwable {

        // Purchaser Login.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);
        NotFoundErrorPage notFoundErrorPage = new NotFoundErrorPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        HeaderArea headerArea = new HeaderArea(driver);
        CartPage cartPage = new CartPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();

        // Prepare data.
        demoAdminPage.addNewOrder();
        boolean result_cart = GlobalUtils.addItemIntoCart(driver,1,1);
        assertTrue(result_cart,"Fail to add items to cart.");
        String categoryName = "new_category";
        boolean result_category = GlobalUtils.addCategory(driver,categoryName,
                "This is a test category.","");
        assertTrue(result_category,"Fail to add category.");

        // Verify data added successfully.
        GlobalUtils.switchToCategoryPage(driver,categoryName);
        ElementUtils.waitUntilVisible(driver,categoryPage.emptyErrorMessage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.ITEMS_PAGE_IS_EMPTY,categoryPage.emptyErrorMessage.getText());
        GlobalUtils.switchToOrdersPage(driver);
        ElementUtils.waitUntilVisible(driver,ordersPage.currentPage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(1, ordersPage.ordersList.size());
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.quantityInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertTrue(cartPage.submitButton.isEnabled());
        headerArea.closeCartPopup();

        // Clean database and verify data.
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.cleanDatabase();
        demoAdminPage.clickConfirmButton();
        GlobalUtils.switchToHomepage(driver);
        ElementUtils.waitUntilVisible(driver,purchaserHomePage.emptyErrorMessage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(0,purchaserHomePage.categoriesList.size());
        assertEquals(WebUIConstants.CATEGORIES_PAGE_IS_EMPTY,purchaserHomePage.emptyErrorMessage.getText());
        GlobalUtils.switchToOrdersPage(driver);
        ElementUtils.waitUntilVisible(driver,ordersPage.currentPage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(0, ordersPage.ordersList.size());
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.quantityInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(cartPage.submitButton.isEnabled());
        headerArea.closeCartPopup();
        GlobalUtils.switchToDifferentURL(driver,Properties.BASE_URL+"/categories/1");
        ElementUtils.waitUntilElementTextAppear(driver,notFoundErrorPage.message,
                WebUIConstants.NOT_FOUND_ERROR_MESSAGE,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.NOT_FOUND_ERROR_MESSAGE,notFoundErrorPage.message.getText());
        GlobalUtils.switchToDifferentURL(driver,Properties.BASE_URL+"/items/1");
        ElementUtils.waitUntilElementTextAppear(driver,notFoundErrorPage.message,
                WebUIConstants.NOT_FOUND_ERROR_MESSAGE,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.NOT_FOUND_ERROR_MESSAGE,notFoundErrorPage.message.getText());
        notFoundErrorPage.backToHomePage();
        assertEquals(Properties.BASE_URL+"/",driver.getCurrentUrl());

        // Reset database and verify data.
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.resetDatabase();
        demoAdminPage.clickConfirmButton();
        demoAdminPage.switchToCategoryTab();
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            assertEquals(6, demoAdminPage.defaultDataList.size());
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            assertEquals(2, demoAdminPage.defaultDataList.size());
        }
        demoAdminPage.switchToItemsTab();
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(11,demoAdminPage.defaultDataList.size());
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(8,demoAdminPage.defaultDataList.size());
        }
        GlobalUtils.switchToOrdersPage(driver);
        ElementUtils.waitUntilVisible(driver,ordersPage.currentPage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(0, ordersPage.ordersList.size());
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.quantityInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(cartPage.submitButton.isEnabled());

        // log out.
        GlobalUtils.switchToLogout(driver);
    }
}
