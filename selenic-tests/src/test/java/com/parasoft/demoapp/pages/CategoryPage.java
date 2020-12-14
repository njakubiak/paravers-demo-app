package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.GlobalUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class CategoryPage {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id='items_breadcrumb']//" +
            "li[@class='unClickable_color1 retract_format breadcrumb_unclickable_button ng-binding']")
    public WebElement navigationBarSecond;

    @FindBy(xpath = "//*[@id='items_breadcrumb']/ol[@class='breadcrumb industry_font font_color1']/li[1]/a")
    public WebElement navigationBarFirst;

    @FindBy(xpath = "//*[@id='UNITED_STATES']/span")
    public WebElement UnitedStates;

    @FindBy(xpath = "//*[@id='UNITED_KINGDOM']/span")
    public WebElement UnitedKingdom;

    @FindBy(xpath = "//*[@id='GERMANY']/span")
    public WebElement Germany;

    @FindBy(xpath = "//*[@id='FRANCE']/span")
    public WebElement France;

    @FindBy(xpath = "//*[@id='JAPAN']/span")
    public WebElement Japan;

    @FindBy(xpath = "//*[@id='SOUTH_KOREA']/span")
    public WebElement SouthKorea;

    @FindBy(xpath = "//*[@id='SPAIN']/span")
    public WebElement Spain;

    @FindBy(xpath = "//*[@id='AUSTRALIA']/span")
    public WebElement Australia;

    @FindBy(xpath = "//*[@id='MERCURY']/span")
    public WebElement Mercury;

    @FindBy(xpath = "//*[@id='VENUS']/span")
    public WebElement Venus;

    @FindBy(xpath = "//*[@id='EARTH']/span")
    public WebElement Earth;

    @FindBy(xpath = "//*[@id='MARS']/span")
    public WebElement Mars;

    @FindBy(xpath = "//*[@id='JUPITER']/span")
    public WebElement Jupiter;

    @FindBy(xpath = "//*[@id='SATURN']/span")
    public WebElement Saturn;

    @FindBy(xpath = "//*[@id='URANUS']/span")
    public WebElement Uranus;

    @FindBy(xpath = "//*[@id='NEPTUNE']/span")
    public WebElement Neptune;

    @FindBy(xpath = "//*[@id='asset_type']/div[@class='common_text']/p/span")
    public WebElement categoryName;

    @FindBy(name = "searchString")
    public WebElement searchStringField;

    @FindBy(css = "[title='search']")
    public WebElement searchIcon;

    @FindBy(name = "sort")
    public WebElement sortDropdown;

    @FindBy(xpath = "//*[@id=\"add_to_requisition_btn\"]")
    public WebElement addToRequisition;

    @FindBy(xpath = "//*[@id='requsition_detail_plus']/button")
    public WebElement increaseButton;

    @FindBy(xpath = "//*[@id='requsition_detail_minus']/button")
    public WebElement reduceButton;

    @FindBy(xpath = "//*[@id=\"detail_button\"]")
    public WebElement addToRequisitionInWindow;

    @FindBy(xpath = "//*[@id='item_select_content']/option[@translate='DATE_ADDED']")
    public WebElement dataAddedOption;

    @FindBy(xpath = "//*[@id='item_select_content']/option[@translate='ALPHABETICAL']")
    public WebElement alphabeticalOption;

    @FindBy(xpath = "//*[@id='no_result_text']")
    public WebElement noItemMessage;

    @FindBy(xpath = "//*[@id='items']/div[@class='item ng-scope']//div[@class='common_text']/p/a/span")
    public List<WebElement> itemList;

    @FindBy(xpath = "//*[@id='items']/div[1]//div[@class='common_text']/p/a")
    public WebElement itemFirst;

    @FindBy(xpath = "//*[@id='items']/div[2]//div[@class='common_text']/p/a/span")
    public WebElement itemSecond;

    @FindBy(xpath = "//*[@id='items']/div[3]//div[@class='common_text']/p/a/span")
    public WebElement itemThird;

    @FindBy(xpath = "//*[@id='items']/div[4]//div[@class='common_text']/p/a/span")
    public WebElement itemFourth;

    @FindBy(xpath = "//*[@id='requsition_detail_title']/div[@class='common_text']/p/span")
    public WebElement itemNameInPopup;

    @FindBy(xpath = "//*[@id='requsition_detail_description']/div[@class='common_text']/p/span")
    public WebElement itemDescriptionInPopup;

    @FindBy(xpath = "//*[@id='requsition_detail_content']/div[3]/img")
    public WebElement itemImageInPopup;

    @FindBy(xpath = "//*[@id='requsition_detail_available']//p[@class='in_stock']/span[1]")
    public WebElement inventoryOfItemInPopup;

    @FindBy(xpath = "//*[@id='requsition_detail_available']//p[@class='in_requisition_request']/span[1]")
    public WebElement quantityInCart;

    @FindBy(xpath = "//*[@id='requsition_detail_cross']/div[@class='common_text']")
    public WebElement closeButtonInPopup;

    @FindBy(xpath = "//span[text()='No items exist.']")
    public WebElement emptyErrorMessage;

    @FindBy(xpath = "//div[@class='ng-scope']//p[@class='ng-scope']/span")
    public WebElement incorrectItemsEndpoint;

    @FindBy(xpath = "//div[@class='ng-scope']/div[3]/p/span")
    public WebElement incorrectLocationsEndpoint;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void setSearchStringField(String text) {
        ElementUtils.waitUntilClickable(driver, searchStringField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        searchStringField.sendKeys(text);
    }

    public void pressEnterOnSearchStringField() throws InterruptedException {
        ElementUtils.waitUntilClickable(driver, searchStringField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        searchStringField.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public void clickSearchIcon() throws InterruptedException {
        ElementUtils.waitUntilClickable(driver, searchIcon, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        Thread.sleep(1000);
    }

    public void selectSortDropdown(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(webdriver -> new Select(sortDropdown).getFirstSelectedOption().getText().trim().length() > 0);
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText(text);
    }

    public void clickSortDropdown() {
        ElementUtils.waitUntilClickable(driver, sortDropdown, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickAddToRequisition() throws AWTException, InterruptedException {
        ElementUtils.clickElementUseJs(driver, addToRequisition);
        GlobalUtils.waiting();
    }


    public void clickIncreaseButton() {
        ElementUtils.clickElementUseJs(driver,increaseButton);
    }


    public void clickReduceButton() {
        ElementUtils.clickElementUseJs(driver,reduceButton);
    }

    public void clickAddToRequisitionInWindow() throws AWTException, InterruptedException {
        ElementUtils.waitUntilClickable(driver, addToRequisitionInWindow, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        GlobalUtils.waiting();
    }

    public void clickHomeLink() {
        ElementUtils.clickElementUseJs(driver,navigationBarFirst);
    }

    public void closePopup() {
        ElementUtils.waitUntilClickable(driver, closeButtonInPopup, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void chooseRegion(String name) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement correspondingDeleteIcon = driver.findElement
                (By.xpath("//label[@id='"+ name + "']/input"));
        ElementUtils.waitUntilClickable(driver, correspondingDeleteIcon, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        correspondingDeleteIcon.click();
        GlobalUtils.waiting();
    }

    public void viewItemFirst() {
        ElementUtils.clickElementUseJs(driver,itemFirst);
    }
}
