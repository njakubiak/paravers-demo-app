package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class ItemDetailPageTests {
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
    public void testItemDetailPage() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.cleanDatabase(driver);
        demoAdminPage.setDefaultInfo();
        HeaderArea headerArea = new HeaderArea(driver);
        CartPage cartPage = new CartPage(driver);
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);
        String industry = "";
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            industry = "defense";
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            industry = "aerospace";
        }
        // Add category and items
        String categoryName = "new_category";
        String itemName = "new_item";
        String itemDescription = "This is a new item";
        int inventory = 20;
        boolean result_category = GlobalUtils.addCategory(driver,categoryName,
                "This is a test category.","");
        assertTrue(result_category,"Fail to add category.");
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            boolean result_item03 = GlobalUtils.addItem(driver,itemName,itemDescription,1 ,
                    inventory,"", LocationConstants.UNITED_STATES_REGION_CAPITAL);
            assertTrue(result_item03,"Fail to add item.");
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            boolean result_item03 = GlobalUtils.addItem(driver,itemName,itemDescription,1 ,
                    inventory,"", LocationConstants.EARTH_REGION_CAPITAL);
            assertTrue(result_item03,"Fail to add item.");
        }
        GlobalUtils.switchToItemPage(driver,categoryName,itemName);
        ElementUtils.waitUntilElementTextAppear(driver,itemDetailPage.itemInventory,
                "20",Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(categoryName,itemDetailPage.categoryLink.getText());
        assertEquals(itemName,itemDetailPage.itemName.getText());
        assertEquals(itemName,itemDetailPage.itemInNavigateBar.getText());
        assertEquals("20",itemDetailPage.itemInventory.getText());
        assertEquals(itemDescription,itemDetailPage.itemDescription.getText());
        assertEquals(Properties.BASE_URL + "/" + industry + "/images/defaultImage.png",
                itemDetailPage.itemImage.getAttribute("src"));
        assertTrue(itemDetailPage.increaseButton.isEnabled());
        assertTrue(itemDetailPage.addToRequisitionButton.isEnabled());
        assertFalse(itemDetailPage.reduceButton.isEnabled());
        itemDetailPage.clickCategoryLink();
        ElementUtils.waitUntilVisible(driver,categoryPage.categoryName,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        String currentURL = driver.getCurrentUrl();
        boolean result = currentURL.contains("categories");
        assertEquals(true, result);
        GlobalUtils.switchToItemPage(driver,categoryName,itemName);
        itemDetailPage.clickHomeLink();
        ElementUtils.waitUntilVisible(driver,purchaserHomePage.assetsTitle,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        currentURL = driver.getCurrentUrl();
        assertEquals(Properties.HOME_PAGE_URL,currentURL);
        GlobalUtils.switchToItemPage(driver,categoryName,itemName);
        itemDetailPage.clickIncreaseButton();
        assertTrue(itemDetailPage.reduceButton.isEnabled());
        itemDetailPage.clickIncreaseButton();
        itemDetailPage.clickIncreaseButton();
        itemDetailPage.clickReduceButton();
        itemDetailPage.clickAddToRequisition();
        ElementUtils.waitUntilElementTextAppear(driver,itemDetailPage.itemInventory,
                "20",Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("3",itemDetailPage.itemQuantityInCart.getText());
        headerArea.openCartPopup();
        ElementUtils.waitUntilElementTextAppear(driver,cartPage.itemDescriptionInCart,
                itemDescription,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilElementTextAppear(driver,headerArea.quantityInCart,
                "3",Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("3",headerArea.quantityInCart.getText());
        assertEquals(itemDescription,cartPage.itemDescriptionInCart.getText());
        assertTrue(cartPage.submitButton.isEnabled());
        assertEquals(itemName,cartPage.itemNameInCart.getText());
        assertEquals(itemDescription,cartPage.itemDescriptionInCart.getText());
        assertEquals("3",cartPage.quantityInCart.getText());
        assertTrue(cartPage.increaseButtonInCart.isEnabled());
        assertTrue(cartPage.reduceButtonInCart.isEnabled());
        assertTrue(cartPage.removeButtonInCart.isEnabled());
        cartPage.removeItem();
        headerArea.closeCartPopup();
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToLogout(driver);
    }

}
