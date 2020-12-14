package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryPageTests {
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
     * Purpose of the test is verify default info depend on current industry in the category page ,
     * like region , sort options and navigate bar.
     */
    @Test
    public void testCategoryPageUI() throws Throwable {

        // Purchaser login.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        CategoryPage categoryPage = new CategoryPage(driver);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();

        // Verify page info depend on different industry.
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            GlobalUtils.switchToCategoryPage(driver,WebUIConstants.DEFAULT_CATEGORY_AIR_SUPPORT_NAME);
            ElementUtils.waitUntilVisible(driver,categoryPage.navigationBarSecond,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
            ElementUtils.waitUntilVisible(driver,categoryPage.categoryName,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
            assertEquals(WebUIConstants.DEFAULT_CATEGORY_AIR_SUPPORT_NAME,categoryPage.navigationBarSecond.getText());
            assertEquals(WebUIConstants.DEFAULT_CATEGORY_AIR_SUPPORT_NAME_CAPITAL,categoryPage.categoryName.getText());
            assertEquals(Properties.DEFENSE_SEARCH_ICON_URL,categoryPage.searchIcon.getAttribute("src"));
            assertEquals(LocationConstants.UNITED_STATES_REGION,categoryPage.UnitedStates.getText());
            assertEquals(LocationConstants.UNITED_KINGDOM_REGION,categoryPage.UnitedKingdom.getText());
            assertEquals(LocationConstants.GERMANY_REGION,categoryPage.Germany.getText());
            assertEquals(LocationConstants.JAPAN_REGION,categoryPage.Japan.getText());
            assertEquals(LocationConstants.SPAIN_REGION,categoryPage.Spain.getText());
            assertEquals(LocationConstants.SOUTH_KOREA_REGION,categoryPage.SouthKorea.getText());
            assertEquals(LocationConstants.AUSTRALIA_REGION,categoryPage.Australia.getText());
            assertEquals(LocationConstants.FRANCE_REGION,categoryPage.France.getText());
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            GlobalUtils.switchToCategoryPage(driver,WebUIConstants.DEFAULT_CATEGORY_AIRPLANE_NAME);
            ElementUtils.waitUntilVisible(driver,categoryPage.navigationBarSecond,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
            ElementUtils.waitUntilVisible(driver,categoryPage.categoryName,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
            assertEquals(WebUIConstants.DEFAULT_CATEGORY_AIRPLANE_NAME,categoryPage.navigationBarSecond.getText());
            assertEquals(WebUIConstants.DEFAULT_CATEGORY_AIRPLANE_NAME_CAPITAL,categoryPage.categoryName.getText());
            assertEquals(Properties.AEROSPACE_SEARCH_ICON_URL,categoryPage.searchIcon.getAttribute("src"));
            assertEquals(LocationConstants.MARS_REGION,categoryPage.Mars.getText());
            assertEquals(LocationConstants.EARTH_REGION,categoryPage.Earth.getText());
            assertEquals(LocationConstants.JUPITER_REGION,categoryPage.Jupiter.getText());
            assertEquals(LocationConstants.MERCURY_REGION,categoryPage.Mercury.getText());
            assertEquals(LocationConstants.URANUS_REGION,categoryPage.Uranus.getText());
            assertEquals(LocationConstants.VENUS_REGION,categoryPage.Venus.getText());
            assertEquals(LocationConstants.NEPTUNE_REGION,categoryPage.Neptune.getText());
            assertEquals(LocationConstants.SATURN_REGION,categoryPage.Saturn.getText());
        }
        categoryPage.clickSortDropdown();
        assertEquals(Properties.SORT_OPTION_ALPHABETICAL,categoryPage.alphabeticalOption.getText());
        assertEquals(Properties.SORT_OPTION_DATA_ADDED,categoryPage.dataAddedOption.getText());

        // Log out.
        GlobalUtils.switchToLogout(driver);
    }

    /**
     * We prepare some data for the test.
     * Purpose of the test is verify functions in the category page .
     * like area filter, keyword search, different collation rules, add to shopping cart, return home page, etc
     */
    @Test
    public void testCategoryPage() throws Throwable {

        // Purchaser login.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        GlobalUtils.cleanDatabase(driver);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        demoAdminPage.setDefaultInfo();
        CategoryPage categoryPage = new CategoryPage(driver);
        HeaderArea headerArea = new HeaderArea(driver);
        CartPage cartPage = new CartPage(driver);
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);
        String industry = "";
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            industry = "defense";
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            industry = "aerospace";
        }

        // Add category and items.
        String categoryName = "new_category";
        String itemName01 = "b_new_item_01";
        String itemName02 = "A_new_item_02";
        String itemName03 = "a_new_item_03";
        String itemName04 = "B_new_item_04";
        String itemDescription = "This is a new item";
        int inventory = 10;
        String imagePath = "";
        boolean result_category = GlobalUtils.addCategory(driver,categoryName,
                "This is a test category.","imagePath");
        assertTrue(result_category,"Fail to add category.");
        int categoryID = 1;
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            boolean result_item03 = GlobalUtils.addItem(driver,itemName03,itemDescription,categoryID ,
                    inventory,imagePath,LocationConstants.UNITED_STATES_REGION_CAPITAL);
            assertTrue(result_item03,"Fail to add item.");
            boolean result_item01 = GlobalUtils.addItem(driver,itemName01,itemDescription, categoryID,
                    inventory,imagePath,LocationConstants.SPAIN_REGION_CAPITAL);
            assertTrue(result_item01,"Fail to add item.");
            boolean result_item02 = GlobalUtils.addItem(driver,itemName02,itemDescription, categoryID,
                    inventory,imagePath,LocationConstants.AUSTRALIA_REGION_CAPITAL);
            assertTrue(result_item02,"Fail to add item.");
            boolean result_item04 = GlobalUtils.addItem(driver,itemName04,itemDescription, categoryID,
                    inventory,imagePath,LocationConstants.UNITED_STATES_REGION_CAPITAL);
            assertTrue(result_item02,"Fail to add item.");
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            boolean result_item03 = GlobalUtils.addItem(driver,itemName03,itemDescription, categoryID,
                    inventory,imagePath,LocationConstants.EARTH_REGION_CAPITAL);
            assertTrue(result_item03,"Fail to add item.");
            boolean result_item01 = GlobalUtils.addItem(driver,itemName01,itemDescription, categoryID,
                    inventory,imagePath,LocationConstants.MARS_REGION_CAPITAL);
            assertTrue(result_item01,"Fail to add item.");
            boolean result_item02 = GlobalUtils.addItem(driver,itemName02,itemDescription, categoryID,
                    inventory,imagePath,LocationConstants.JUPITER_REGION_CAPITAL);
            assertTrue(result_item02,"Fail to add item.");
            boolean result_item04 = GlobalUtils.addItem(driver,itemName04,itemDescription, categoryID,
                    inventory,imagePath,LocationConstants.EARTH_REGION_CAPITAL);
            assertTrue(result_item03,"Fail to add item.");
        }

        // Navigate to category page and verify area filter, keyword search, different collation rules.
        GlobalUtils.switchToCategoryPage(driver,categoryName);
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            categoryPage.chooseRegion(LocationConstants.UNITED_STATES_REGION_CAPITAL);
            assertEquals(2,categoryPage.itemList.size());
            assertTrue(categoryPage.itemFirst.getText().contains(itemName04));
            categoryPage.setSearchStringField("3");
            categoryPage.pressEnterOnSearchStringField();
            assertEquals(1,categoryPage.itemList.size());
            assertTrue(categoryPage.itemFirst.getText().contains(itemName03));
            categoryPage.chooseRegion(LocationConstants.UNITED_STATES_REGION_CAPITAL);
            categoryPage.setSearchStringField("");
            categoryPage.clickSearchIcon();
            categoryPage.chooseRegion(LocationConstants.SPAIN_REGION_CAPITAL);
            assertEquals(1,categoryPage.itemList.size());
            assertTrue(categoryPage.itemFirst.getText().contains(itemName01));
            categoryPage.chooseRegion(LocationConstants.SPAIN_REGION_CAPITAL);
            categoryPage.chooseRegion(LocationConstants.AUSTRALIA_REGION_CAPITAL);
            assertEquals(1,categoryPage.itemList.size());
            assertTrue(categoryPage.itemFirst.getText().contains(itemName02));
            categoryPage.chooseRegion(LocationConstants.AUSTRALIA_REGION_CAPITAL);
            categoryPage.chooseRegion(LocationConstants.JAPAN_REGION_CAPITAL);
            assertEquals(0,categoryPage.itemList.size());
            assertEquals(WebUIConstants.NO_ITEMS_IS_FOUND,categoryPage.noItemMessage.getText());
            categoryPage.chooseRegion(LocationConstants.JAPAN_REGION_CAPITAL);

        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            categoryPage.chooseRegion(LocationConstants.EARTH_REGION_CAPITAL);
            assertEquals(2,categoryPage.itemList.size());
            assertTrue(categoryPage.itemFirst.getText().contains(itemName04));
            categoryPage.setSearchStringField("3");
            categoryPage.pressEnterOnSearchStringField();
            assertEquals(1,categoryPage.itemList.size());
            assertTrue(categoryPage.itemFirst.getText().contains(itemName03));
            categoryPage.chooseRegion(LocationConstants.EARTH_REGION_CAPITAL);
            categoryPage.setSearchStringField("");
            categoryPage.clickSearchIcon();
            categoryPage.chooseRegion(LocationConstants.MARS_REGION_CAPITAL);
            assertEquals(1,categoryPage.itemList.size());
            assertTrue(categoryPage.itemFirst.getText().contains(itemName01));
            categoryPage.chooseRegion(LocationConstants.MARS_REGION_CAPITAL);
            categoryPage.chooseRegion(LocationConstants.JUPITER_REGION_CAPITAL);
            assertEquals(1,categoryPage.itemList.size());
            assertTrue(categoryPage.itemFirst.getText().contains(itemName02));
            categoryPage.chooseRegion(LocationConstants.JUPITER_REGION_CAPITAL);
            categoryPage.chooseRegion(LocationConstants.VENUS_REGION_CAPITAL);
            assertEquals(0,categoryPage.itemList.size());
            assertEquals(WebUIConstants.NO_ITEMS_IS_FOUND,categoryPage.noItemMessage.getText());
            categoryPage.chooseRegion(LocationConstants.VENUS_REGION_CAPITAL);
        }
        categoryPage.selectSortDropdown(Properties.SORT_OPTION_ALPHABETICAL);
        assertEquals(itemName02,categoryPage.itemFirst.getText());
        assertEquals(itemName04,categoryPage.itemSecond.getText());
        assertEquals(itemName03,categoryPage.itemThird.getText());
        assertEquals(itemName01,categoryPage.itemFourth.getText());
        categoryPage.selectSortDropdown(Properties.SORT_OPTION_DATA_ADDED);
        assertEquals(itemName03,categoryPage.itemFirst.getText());
        assertEquals(itemName01,categoryPage.itemSecond.getText());
        assertEquals(itemName02,categoryPage.itemThird.getText());
        assertEquals(itemName04,categoryPage.itemFourth.getText());
        categoryPage.setSearchStringField("1");
        categoryPage.pressEnterOnSearchStringField();
        assertEquals(1,categoryPage.itemList.size());
        assertTrue(categoryPage.itemFirst.getText().contains(itemName01));
        categoryPage.setSearchStringField("category");
        categoryPage.clickSearchIcon();
        assertEquals(0,categoryPage.itemList.size());
        assertEquals(WebUIConstants.NO_ITEMS_IS_FOUND,categoryPage.noItemMessage.getText());
        categoryPage.setSearchStringField("");
        categoryPage.clickSearchIcon();
        driver.navigate().refresh();
        ElementUtils.waitUntilVisible(driver,categoryPage.itemFirst,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        categoryPage.viewItemFirst();
        ElementUtils.waitUntilVisible(driver,itemDetailPage.itemInNavigateBar,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("items"));
        GlobalUtils.switchToCategoryPage(driver,categoryName);
        ElementUtils.waitUntilVisible(driver,categoryPage.itemFirst,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);

        // Add item to cart.
        categoryPage.clickAddToRequisition();
        ElementUtils.waitUntilElementTextAppear(driver,categoryPage.inventoryOfItemInPopup,
                "10",Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(itemName02,categoryPage.itemNameInPopup.getText());
        assertEquals(itemDescription,categoryPage.itemDescriptionInPopup.getText());
        assertEquals("10",categoryPage.inventoryOfItemInPopup.getText());
        assertEquals(Properties.BASE_URL + "/" + industry + "/images/defaultImage.png",
                categoryPage.itemImageInPopup.getAttribute("src"));
        assertFalse(categoryPage.reduceButton.isEnabled());
        assertTrue(categoryPage.increaseButton.isEnabled());
        assertTrue(categoryPage.addToRequisitionInWindow.isEnabled());
        categoryPage.clickIncreaseButton();
        assertTrue(categoryPage.reduceButton.isEnabled());
        categoryPage.clickIncreaseButton();
        categoryPage.clickIncreaseButton();
        categoryPage.clickReduceButton();
        categoryPage.clickAddToRequisitionInWindow();
        categoryPage.clickAddToRequisition();
        ElementUtils.waitUntilElementTextAppear(driver,categoryPage.inventoryOfItemInPopup,
                "10",Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("10",categoryPage.inventoryOfItemInPopup.getText());
        assertEquals("3",categoryPage.quantityInCart.getText());
        categoryPage.closePopup();

        // Verify that the item was added to the cart successfully.
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,headerArea.quantityInCart, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("3",headerArea.quantityInCart.getText());
        assertEquals(itemDescription,cartPage.itemDescriptionInCart.getText());
        assertTrue(cartPage.submitButton.isEnabled());
        assertEquals(itemName02,cartPage.itemNameInCart.getText());
        assertEquals(itemDescription,cartPage.itemDescriptionInCart.getText());
        assertEquals("3",cartPage.quantityInCart.getText());
        assertTrue(cartPage.increaseButtonInCart.isEnabled());
        assertTrue(cartPage.reduceButtonInCart.isEnabled());
        assertTrue(cartPage.removeButtonInCart.isEnabled());
        cartPage.removeItem();
        headerArea.closeCartPopup();

        // Back to home page.
        categoryPage.clickHomeLink();
        ElementUtils.waitUntilVisible(driver,purchaserHomePage.assetsTitle,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        String currentURL = driver.getCurrentUrl();
        assertEquals(Properties.HOME_PAGE_URL,currentURL);

        // Reset database and log out.
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToLogout(driver);
    }


}
