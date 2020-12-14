package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.DemoAdminPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class EditAItemTests {
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
    public void testEditItemPositive() throws Throwable {
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME,Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        GlobalUtils.switchToDemoAdminPage(driver);
        String testItemName = "a-new-item";
        String testItemDescription = "A new item.";
        String testItemInventory = "100";

        // Verify button status
        demoAdminPage.switchToItemsTab();
        demoAdminPage.clickAddNewButton();
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        assertTrue(demoAdminPage.cancelButton.isEnabled());

        // Add item
        String industry = "";
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            industry = "defense";
            assertEquals(11,demoAdminPage.defaultDataList.size());
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            industry = "aerospace";
            assertEquals(8,demoAdminPage.defaultDataList.size());
        }
        demoAdminPage.setNameField(testItemName);
        demoAdminPage.setDescriptionField(testItemDescription);
        demoAdminPage.setQuantityField(testItemInventory);
        demoAdminPage.chooseImage();
        GlobalUtils.uploadImage("/src/test/resources/rabbit.gif");
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            demoAdminPage.selectRegionDropdown(LocationConstants.UNITED_STATES_REGION);
            demoAdminPage.selectCategoryDropdown(WebUIConstants.DEFAULT_CATEGORY_AIR_SUPPORT_NAME);
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            demoAdminPage.selectRegionDropdown(LocationConstants.EARTH_REGION);
            demoAdminPage.selectCategoryDropdown(WebUIConstants.DEFAULT_CATEGORY_AIRCRAFT_NAME);
        }
        demoAdminPage.clickModalSaveButton();
        ElementUtils.waitUntilElementTextAppear
                (driver, demoAdminPage.defaultData, testItemName, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        String itemName = driver.findElement
                (By.xpath("//td[@title='"+ testItemName + "']/span")).getText();
        String categoryOfItem = driver.findElement
                (By.xpath("//td[@title='"+ testItemName + "']/ancestor ::tr/td[2]/span")).getText();
        String itemDescription = driver.findElement
                (By.xpath("//td[@title='"+ testItemName + "']/ancestor ::tr/td[3]/span")).getText();
        String itemRegion = driver.findElement
                (By.xpath("//td[@title='"+ testItemName + "']/ancestor ::tr/td[4]/span")).getText();
        String itemInventory = driver.findElement
                (By.xpath("//td[@title='"+ testItemName + "']/ancestor ::tr/td[5]/span")).getText();
        String itemImagePath = driver.findElement
                (By.xpath("//td[@title='"+ testItemName + "']/ancestor ::tr/td[6]/img")).getAttribute("src");
        assertEquals(testItemName,itemName);
        assertEquals(testItemInventory,itemInventory);
        assertEquals(testItemDescription,itemDescription);
        assertEquals(Properties.BASE_URL + "/uploaded_images/"+ industry +"/rabbit.gif",
               itemImagePath);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(12,demoAdminPage.defaultDataList.size());
            assertEquals(LocationConstants.UNITED_STATES_REGION,itemRegion);
            assertEquals(WebUIConstants.DEFAULT_CATEGORY_AIR_SUPPORT_NAME,categoryOfItem);
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.EARTH_REGION,itemRegion);
            assertEquals(WebUIConstants.DEFAULT_CATEGORY_AIRCRAFT_NAME,categoryOfItem);
            assertEquals(9,demoAdminPage.defaultDataList.size());
        }

        // Edit item
        String testItemName1 = "A-new-item";
        testItemDescription = "This is a new item.";
        testItemInventory = "200";
        demoAdminPage.clickCorrespondingEditIcon(testItemName);
        demoAdminPage.removeImage();
        demoAdminPage.setNameField(testItemName1);
        demoAdminPage.setDescriptionField(testItemDescription);
        demoAdminPage.setQuantityField(testItemInventory);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            demoAdminPage.selectRegionDropdown(LocationConstants.UNITED_KINGDOM_REGION);
            demoAdminPage.selectCategoryDropdown(WebUIConstants.DEFAULT_CATEGORY_PERSONNEL_NAME);
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            demoAdminPage.selectRegionDropdown(LocationConstants.MARS_REGION);
            demoAdminPage.selectCategoryDropdown(WebUIConstants.DEFAULT_CATEGORY_AIRPLANE_NAME);
        }
        demoAdminPage.clickModalSaveButton();
        ElementUtils.waitUntilElementTextAppear
                (driver, demoAdminPage.defaultData, testItemName1, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        itemName = driver.findElement
                (By.xpath("//td[@title='"+ testItemName1 + "']/span")).getText();
        categoryOfItem = driver.findElement
                (By.xpath("//td[@title='"+ testItemName1 + "']/ancestor ::tr/td[2]/span")).getText();
        itemDescription = driver.findElement
                (By.xpath("//td[@title='"+ testItemName1 + "']/ancestor ::tr/td[3]/span")).getText();
        itemRegion = driver.findElement
                (By.xpath("//td[@title='"+ testItemName1 + "']/ancestor ::tr/td[4]/span")).getText();
        itemInventory = driver.findElement
                (By.xpath("//td[@title='"+ testItemName1 + "']/ancestor ::tr/td[5]/span")).getText();
        itemImagePath = driver.findElement
                (By.xpath("//td[@title='"+ testItemName1 + "']/ancestor ::tr/td[6]/img")).getAttribute("src");
        assertEquals(testItemName1,itemName);
        assertEquals(testItemInventory,itemInventory);
        assertEquals(testItemDescription,itemDescription);
        assertEquals(Properties.BASE_URL + "/"+ industry +"/images/defaultImage.png", itemImagePath);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_KINGDOM_REGION,itemRegion);
            assertEquals(WebUIConstants.DEFAULT_CATEGORY_PERSONNEL_NAME,categoryOfItem);
            assertEquals(12,demoAdminPage.defaultDataList.size());
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.MARS_REGION,itemRegion);
            assertEquals(WebUIConstants.DEFAULT_CATEGORY_AIRPLANE_NAME,categoryOfItem);
            assertEquals(9,demoAdminPage.defaultDataList.size());
        }

        // Remove item
        demoAdminPage.clickCorrespondingDeleteIcon(testItemName1);
        demoAdminPage.clickConfirmButton();
        driver.navigate().refresh();
        demoAdminPage.switchToItemsTab();
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(11,demoAdminPage.defaultDataList.size());
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(8,demoAdminPage.defaultDataList.size());
        }
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToLogout(driver);
    }

    @Test
    public void testEditItemNegative() throws Throwable {
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME,Properties.PURCHASER_PASSWORD);
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToDemoAdminPage(driver);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        String testItemName = "a-new-item";
        String testItemDescription = "A new item.";
        String testItemInventory = "100";

        demoAdminPage.switchToItemsTab();
        demoAdminPage.clickAddNewButton();
        demoAdminPage.setNameField(testItemName);
        demoAdminPage.setDescriptionField(testItemDescription);
        demoAdminPage.setQuantityField(testItemInventory);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            demoAdminPage.selectRegionDropdown(LocationConstants.UNITED_STATES_REGION);
            demoAdminPage.selectCategoryDropdown(WebUIConstants.DEFAULT_CATEGORY_AIR_SUPPORT_NAME);
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            demoAdminPage.selectRegionDropdown(LocationConstants.EARTH_REGION);
            demoAdminPage.selectCategoryDropdown(WebUIConstants.DEFAULT_CATEGORY_AIRCRAFT_NAME);
        }
        demoAdminPage.clickModalSaveButton();
        ElementUtils.waitUntilElementTextAppear
                (driver, demoAdminPage.defaultData, testItemName, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);

        // Item name exists
        demoAdminPage.clickAddNewButton();
        demoAdminPage.setNameField(testItemName);
        demoAdminPage.setDescriptionField(testItemDescription);
        demoAdminPage.setQuantityField(testItemInventory);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            demoAdminPage.selectRegionDropdown(LocationConstants.UNITED_STATES_REGION);
            demoAdminPage.selectCategoryDropdown(WebUIConstants.DEFAULT_CATEGORY_AIR_SUPPORT_NAME);
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            demoAdminPage.selectRegionDropdown(LocationConstants.EARTH_REGION);
            demoAdminPage.selectCategoryDropdown(WebUIConstants.DEFAULT_CATEGORY_AIRCRAFT_NAME);
        }
        demoAdminPage.clickModalSaveButton();
        ElementUtils.waitUntilVisible(driver,demoAdminPage.errorMessageInItem,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.ITEM_NAME_ALREADY_EXISTS,demoAdminPage.errorMessageInItem.getText());
        demoAdminPage.clickCancelButton();

        // Remove description
        demoAdminPage.clickCorrespondingEditIcon(testItemName);
        demoAdminPage.setDescriptionField("");
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        demoAdminPage.clickCancelButton();

        // Image is more than 1MB
        demoAdminPage.clickCorrespondingEditIcon(testItemName);
        demoAdminPage.removeImage();
        demoAdminPage.chooseImage();
        GlobalUtils.uploadImage("/src/test/resources/picture.jpg");
        WebElement imageUploadError = driver.findElement(By.xpath("//*[@id='item_modal']/div/div/div[2]/span"));
        ElementUtils.waitUntilElementTextAppear
                (driver,demoAdminPage.itemUploadErrorMessage,WebUIConstants.IMAGE_TOO_LARGE,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.IMAGE_TOO_LARGE,demoAdminPage.itemUploadErrorMessage.getText());
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());

        // Image is empty
        demoAdminPage.chooseImage();
        GlobalUtils.uploadImage("/src/test/resources/empty.jpg");
        demoAdminPage.clickModalSaveButton();
        assertEquals(WebUIConstants.IMAGE_IS_EMPTY,demoAdminPage.errorMessageInItem.getText());
        assertEquals(WebUIConstants.IMAGE_UPLOAD_FAILED,demoAdminPage.itemUploadErrorMessage.getText());

        // Image format is wrong
        demoAdminPage.chooseImage();
        GlobalUtils.uploadImage("/src/test/resources/unsupported_file.txt");
        ElementUtils.waitUntilElementTextAppear(driver, demoAdminPage.itemUploadErrorMessage,
                        WebUIConstants.IMAGE_FORMAT_ERROR, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.IMAGE_FORMAT_ERROR,demoAdminPage.itemUploadErrorMessage.getText());
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        demoAdminPage.clickCloseItemWindowButton();
        GlobalUtils.resetDatabase(driver);
    }
}
