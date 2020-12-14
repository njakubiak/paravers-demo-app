package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.DemoAdminPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class EditCategoryTests {

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
    public void testEditCategoryPositive() throws Throwable {
        // login
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.switchToCategoryTab();

        // Assertion of initial data
        String industry = "";
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            industry = "defense";
            assertEquals(6, demoAdminPage.defaultDataList.size());
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            industry = "aerospace";
            assertEquals(2, demoAdminPage.defaultDataList.size());
        }

        // Verify button status
        demoAdminPage.clickAddNewButton();
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        assertTrue(demoAdminPage.cancelButton.isEnabled());
        demoAdminPage.clickCloseCategoryWindowButton();
        demoAdminPage.clickAddNewButton();

        // create new category
        String testCategoryName = "A Test Category";
        String testCategoryDescription = "Just to be in the first row.";
        demoAdminPage.setNameField(testCategoryName);
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        demoAdminPage.setDescriptionField(testCategoryDescription);
        demoAdminPage. clickModalSaveButton();
        ElementUtils.waitUntilElementTextAppear(
                driver, demoAdminPage.defaultData, testCategoryName, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        String categoryName = driver.findElement(By.xpath("//td[@title='"+ testCategoryName + "']/span")).getText();
        String categoryDescription = driver.findElement
                (By.xpath("//td[@title='"+ testCategoryName + "']/ancestor ::tr/td[2]/span")).getText();
        String categoryImagePath = driver.findElement
                (By.xpath("//td[@title='"+ testCategoryName + "']/ancestor ::tr/td[3]/img")).getAttribute("src");
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            assertEquals(7, demoAdminPage.defaultDataList.size());
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            assertEquals(3, demoAdminPage.defaultDataList.size());
        }
        assertEquals(testCategoryName, categoryName);
        assertEquals(testCategoryDescription, categoryDescription);
        assertEquals( Properties.BASE_URL + "/" + industry +"/images/defaultImage.png",
                categoryImagePath);

        // edit new category
        String testCategoryName1 = "After Update";
        testCategoryDescription = "It is still in the front row after modification.";
        demoAdminPage.clickCorrespondingEditIcon(testCategoryName);
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        demoAdminPage.setNameField(testCategoryName1);
        demoAdminPage.setDescriptionField(testCategoryDescription);
        demoAdminPage.removeImage();
        uploadImage(demoAdminPage, "/src/test/resources/rabbit.gif");
        demoAdminPage.clickModalSaveButton();
        ElementUtils.waitUntilElementTextAppear(
                driver, demoAdminPage.defaultData, testCategoryName1, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        categoryName = driver.findElement(By.xpath("//td[@title='"+ testCategoryName1 + "']/span")).getText();
        categoryDescription = driver.findElement
                (By.xpath("//td[@title='"+ testCategoryName1 + "']/ancestor ::tr/td[2]/span")).getText();
        categoryImagePath = driver.findElement
                (By.xpath("//td[@title='"+ testCategoryName1 + "']/ancestor ::tr/td[3]/img")).getAttribute("src");
        assertEquals(testCategoryName1, categoryName);
        assertEquals(testCategoryDescription, categoryDescription);
        assertEquals(Properties.BASE_URL + "/uploaded_images/"+ industry +"/rabbit.gif",
                categoryImagePath);

        // delete new category
        demoAdminPage.clickCorrespondingDeleteIcon(testCategoryName1);
        demoAdminPage.ClickModalConfirmButton();
        driver.navigate().refresh();
        demoAdminPage.switchToCategoryTab();
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            assertEquals(6, demoAdminPage.defaultDataList.size());
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            assertEquals(2, demoAdminPage.defaultDataList.size());
        }

        // logout
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToLogout(driver);
    }
    private void uploadImage(DemoAdminPage demoAdminPage, String imagePath) throws AWTException, InterruptedException {
        demoAdminPage.chooseImage();
        GlobalUtils.uploadImage(imagePath);
        GlobalUtils.waiting();
    }

    @Test
    public void testEditCategoryNegative() throws Throwable {
        // login
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.switchToCategoryTab();

        // create a new category
        String testCategoryName = "A Test Category";
        String testCategoryDescription = "Just to be in the first row.";
        demoAdminPage.clickAddNewButton();
        demoAdminPage.setNameField(testCategoryName);
        demoAdminPage.setDescriptionField(testCategoryDescription);
        uploadImage(demoAdminPage, "/src/test/resources/unsupported_file.txt");
        ElementUtils.waitUntilElementTextAppear(driver, demoAdminPage.categoryUploadErrorMessage,
                WebUIConstants.IMAGE_FORMAT_ERROR, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        assertEquals(WebUIConstants.IMAGE_FORMAT_ERROR, demoAdminPage.categoryUploadErrorMessage.getText());
        uploadImage(demoAdminPage, "/src/test/resources/picture.jpg");
        ElementUtils.waitUntilElementTextAppear(driver, demoAdminPage.categoryUploadErrorMessage,
                WebUIConstants.IMAGE_TOO_LARGE, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        assertEquals(WebUIConstants.IMAGE_TOO_LARGE, demoAdminPage.categoryUploadErrorMessage.getText());
        uploadImage(demoAdminPage, "/src/test/resources/empty.jpg");
        demoAdminPage.clickModalSaveButton();
        ElementUtils.waitUntilElementTextAppear(driver, demoAdminPage.errorMessageInCategory,
                WebUIConstants.IMAGE_IS_EMPTY, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.IMAGE_IS_EMPTY, demoAdminPage.errorMessageInCategory.getText());
        uploadImage(demoAdminPage, "/src/test/resources/rabbit.gif");
        demoAdminPage.clickModalSaveButton();

        //Remove description
        demoAdminPage.clickCorrespondingEditIcon(testCategoryName);
        demoAdminPage.setDescriptionField("");
        assertFalse(demoAdminPage.modalSaveButton.isEnabled());
        demoAdminPage.clickCancelButton();

        // edit new category
        testCategoryDescription = "It is still in the front row after modification.";
        demoAdminPage.clickAddNewButton();
        demoAdminPage.setNameField(testCategoryName);
        demoAdminPage.setDescriptionField(testCategoryDescription);
        demoAdminPage.clickModalSaveButton();
        ElementUtils.waitUntilElementTextAppear(driver, demoAdminPage.errorMessageInCategory,
                WebUIConstants.CATEGORY_NAME_ALREADY_EXISTS, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.CATEGORY_NAME_ALREADY_EXISTS, demoAdminPage.errorMessageInCategory.getText());
        demoAdminPage.clickCancelButton();

        // delete new category
        demoAdminPage.clickCorrespondingDeleteIcon(testCategoryName);
        demoAdminPage.ClickModalConfirmButton();
    }
}