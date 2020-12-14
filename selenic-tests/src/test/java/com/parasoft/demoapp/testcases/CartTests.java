package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CartTests {
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
    public void testNegative() throws Throwable {

        // Purchaser login and prepare data.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        HeaderArea headerArea = new HeaderArea(driver);
        CartPage cartPage = new CartPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);
        String categoryName = "new_category";
        String itemName = "new_item";
        String Description = "This is a new products";
        boolean result_category = GlobalUtils.addCategory(driver,categoryName, Description,"");
        assertTrue(result_category,"Fail to add category.");
        int categoryID = GlobalUtils.getCategoryID(driver,categoryName);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            boolean result_item03 = GlobalUtils.addItem(driver,itemName,Description,categoryID ,
                    3,"", LocationConstants.UNITED_STATES_REGION_CAPITAL);
            assertTrue(result_item03,"Fail to add item.");
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            boolean result_item03 = GlobalUtils.addItem(driver,itemName,Description,categoryID ,
                    3,"", LocationConstants.EARTH_REGION_CAPITAL);
            assertTrue(result_item03,"Fail to add item.");
        }

        // Add items to cart.
        GlobalUtils.switchToCategoryPage(driver,categoryName);
        ElementUtils.waitUntilVisible(driver,categoryPage.addToRequisition,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        categoryPage.clickAddToRequisition();
        ElementUtils.waitUntilVisible(driver,categoryPage.inventoryOfItemInPopup,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        categoryPage.clickAddToRequisitionInWindow();
        headerArea.openCartPopup();
        cartPage.increaseItem();
        ElementUtils.waitUntilElementTextAppear(driver,headerArea.quantityInCart,"2",Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("2",headerArea.quantityInCart.getText());
        assertEquals("2",cartPage.quantityInCart.getText());
        String item_Name = cartPage.itemNameInCart.getText();
        cartPage.clickItemName();
        ElementUtils.waitUntilVisible(driver,itemDetailPage.itemName,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        assertEquals(item_Name,itemDetailPage.itemName.getText());

        // Modify inventory less than quantity in cart.
        headerArea.clickSettingButton();
        demoAdminPage.switchToItemsTab();
        demoAdminPage.clickCorrespondingEditIcon(itemName);
        demoAdminPage.setQuantityField("1");
        demoAdminPage.clickModalSaveButton();
        GlobalUtils.switchToHomepage(driver);
        ElementUtils.waitUntilVisible(driver,purchaserHomePage.viewAllLink1,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.availableQuantity,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(cartPage.submitButton.isEnabled());
        assertFalse(cartPage.increaseButtonInCart.isEnabled());
        assertTrue(cartPage.reduceButtonInCart.isEnabled());
        assertTrue(cartPage.removeButtonInCart.isEnabled());
        ElementUtils.waitUntilVisible(driver,cartPage.availableQuantity,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("1 "+WebUIConstants.CART_AVAILABLE,cartPage.availableQuantity.getText());
        cartPage.reduceItem();
        headerArea.closeCartPopup();
        driver.navigate().refresh();
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,headerArea.quantityInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,cartPage.quantityInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("1",headerArea.quantityInCart.getText());
        assertEquals("1",cartPage.quantityInCart.getText());
        assertTrue(cartPage.submitButton.isEnabled());
        assertFalse(cartPage.reduceButtonInCart.isEnabled());
        headerArea.closeCartPopup();

        // Modify inventory is 0.
        headerArea.clickSettingButton();
        demoAdminPage.switchToItemsTab();
        demoAdminPage.clickCorrespondingEditIcon(itemName);
        demoAdminPage.setQuantityField("0");
        demoAdminPage.clickModalSaveButton();
        GlobalUtils.switchToHomepage(driver);
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.availableQuantity,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(cartPage.submitButton.isEnabled());
        assertFalse(cartPage.increaseButtonInCart.isEnabled());
        assertFalse(cartPage.reduceButtonInCart.isEnabled());
        assertTrue(cartPage.removeButtonInCart.isEnabled());
        ElementUtils.waitUntilVisible(driver,cartPage.availableQuantity,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("0 "+WebUIConstants.CART_AVAILABLE,cartPage.availableQuantity.getText());
        headerArea.closeCartPopup();
        GlobalUtils.switchToCategoryPage(driver,categoryName);
        ElementUtils.waitUntilVisible(driver,categoryPage.addToRequisition,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        categoryPage.clickAddToRequisition();
        assertFalse(categoryPage.increaseButton.isEnabled());
        assertFalse(categoryPage.reduceButton.isEnabled());
        assertFalse(categoryPage.addToRequisitionInWindow.isEnabled());
        categoryPage.closePopup();
        categoryPage.viewItemFirst();
        ElementUtils.waitUntilVisible(driver,itemDetailPage.itemInventory,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(itemDetailPage.increaseButton.isEnabled());
        assertFalse(itemDetailPage.reduceButton.isEnabled());
        assertFalse(itemDetailPage.addToRequisitionButton.isEnabled());

        // Remove the item.
        headerArea.clickSettingButton();
        demoAdminPage.switchToItemsTab();
        demoAdminPage.clickCorrespondingDeleteIcon(itemName);
        demoAdminPage.clickConfirmButton();
        GlobalUtils.switchToHomepage(driver);
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.availableQuantity,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(cartPage.submitButton.isEnabled());
        assertFalse(cartPage.increaseButtonInCart.isEnabled());
        assertFalse(cartPage.reduceButtonInCart.isEnabled());
        assertTrue(cartPage.removeButtonInCart.isEnabled());
        assertEquals(WebUIConstants.CART_INVALID,cartPage.itemInvalid.getText());
        cartPage.removeItem();
        headerArea.closeCartPopup();
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.quantityInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("0",cartPage.quantityInCart.getText());
        headerArea.closeCartPopup();

        //Log out.
        GlobalUtils.switchToLogout(driver);
    }
}
