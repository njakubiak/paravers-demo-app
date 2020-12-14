package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderWizardPage {

    @FindBy(linkText = "Home")
    private WebElement homeLink;

    @FindBy(xpath = "//*[@id='order_process']/ol[@class='breadcrumb industry_font']/li[1]")
    public WebElement developmentLocation;

    @FindBy(xpath = "//*[@id='order_process']/ol[@class='breadcrumb industry_font']/li[2]")
    public WebElement assignCampaign;

    @FindBy(xpath = "//*[@id='order_process']/ol[@class='breadcrumb industry_font']/li[3]")
    public WebElement review;

    @FindBy(xpath = "//*[@id='assign_to_campaign']/button")
    public WebElement assignToCampaignButton;

    @FindBy(xpath = "//*[@id='go_to_review']/button")
    public WebElement goToReviewButton;

    @FindBy(xpath = "//*[@id='submit_for_approval']/button")
    public WebElement submitForApproval;

    @FindBy(xpath = "//*[@id='region']/p/span")
    public WebElement regionOrPlanets;

    @FindBy(xpath = "//*[@id='region_select']")
    public WebElement dropDownBox;

    @FindBy(xpath = "//*[@id='map_pointer']/img")
    public WebElement imagePath;

    @FindBy(xpath = "//*[@id='map']/img")
    public WebElement imagePathDefault;

    @FindBy(xpath = "//*[@id='region_select']/option[2]")
    public WebElement option2;

    @FindBy(xpath = "//*[@id='region_select']/option[3]")
    public WebElement option3;

    @FindBy(xpath = "//*[@id='region_select']/option[4]")
    public WebElement option4;

    @FindBy(xpath = "//*[@id='region_select']/option[5]")
    public WebElement option5;

    @FindBy(xpath = "//*[@id='region_select']/option[6]")
    public WebElement option6;

    @FindBy(xpath = "//*[@id='region_select']/option[7]")
    public WebElement option7;

    @FindBy(xpath = "//*[@id='region_select']/option[8]")
    public WebElement option8;

    @FindBy(xpath = "//*[@id='region_select']/option[9]")
    public WebElement option9;

    @FindBy(xpath = "//*[@id='platoon_id']/p/span")
    public WebElement platoonIDOrContinentID;

    @FindBy(xpath = "//*[@id='campaign_id']/p/span")
    public WebElement campaignIDOrMissionID;

    @FindBy(xpath = "//*[@id='service_number']/p/span")
    public WebElement codeNameOrUUPIC;

    @FindBy(xpath = "//*[@id='get_location']/button")
    public WebElement getLocationButton;

    @FindBy(id = "platoon_id_input")
    public WebElement platoonIdInputField;

    @FindBy(id = "campaign_id_input")
    public WebElement campaignIdInputField;

    @FindBy(id = "service_number_input")
    public WebElement codeNameInputField;

    @FindBy(xpath = "//*[@id='position_info']/div/p/span")
    public WebElement coordinate;

    @FindBy(xpath = "//*[@id='order_process']//div[@class='wizard_title common_industry industry_font']" +
            "/div[@class='common_text']/p/span[@class='ng-binding']")
    public WebElement quantityOfOrder;

    @FindBy(xpath = "//*[@id='items']//div[@class='item_title item_title0 common_industry " +
            "industry_font']/div[@class='common_text']/p/span")
    public WebElement itemName;

    @FindBy(xpath = "//*[@id='items']//div[@class='wizard_item_description item_description0 common_industry " +
            "industry_font']/div[@class='common_text']/p/span")
    public WebElement itemDescription;

    @FindBy(xpath = "//*[@id='items']/div/div[1]/img")
    public WebElement itemImagePath;

    @FindBy(xpath = "//*[@id='items']//div[@class='item_quantity item_quantity0 common_industry industry_font']" +
            "/div[@class='common_text']/p/span[2]")
    public WebElement itemQuantity;

    @FindBy(xpath = "//*[@id='summary_content']/div/div[3]")
    public WebElement regionInfo;

    @FindBy(xpath = "//*[@id='summary_content']/div/div[7]")
    public WebElement coordinateInfo;

    @FindBy(xpath = "//*[@id='summary_content']/div/div[5]")
    public WebElement IDInfo;

    @FindBy(xpath = "//*[@id='summary_content']/div/div[12]")
    public WebElement campaignInfo;

    @FindBy(xpath = "//*[@id='summary_content']/div/div[10]")
    public WebElement serviceInfo;

    @FindBy(xpath = "//*[@id='summary_map']/img")
    public WebElement imagePathInReview;

    @FindBy(xpath = "//*[@id='submit_status']/span[@class='font_bold ng-binding']")
    public WebElement orderNumber;

    @FindBy(xpath = "//*[@id='region_select']/option")
    public List<WebElement> options;

    private WebDriver driver;

    public OrderWizardPage(WebDriver driver)  {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void clickGetLocationButton() {
        ElementUtils.waitUntilClickable(driver, getLocationButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickAssignToCampaignButton() {
        ElementUtils.clickElementUseJs(driver,assignToCampaignButton);
    }

    public void clickGoToReviewButtonButton() {
        ElementUtils.clickElementUseJs(driver,goToReviewButton);
    }

    public void clickSubmitForApprovalButton() {
        ElementUtils.clickElementUseJs(driver,submitForApproval); }

    public void clickRegionDropDownButton() {
        ElementUtils.clickElementUseJs(driver,dropDownBox);
    }

    public void clickHomeLink() {
        ElementUtils.clickElementUseJs(driver,homeLink);
    }

    public void selectRegion(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(webdriver -> new Select(dropDownBox).getFirstSelectedOption().getText().trim().length() > 0);
        Select dropdown = new Select(dropDownBox);
        dropdown.selectByVisibleText(text);
    }

    public void setPlatoonIdInputField(String text) {
        ElementUtils.waitUntilClickable(driver, platoonIdInputField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        platoonIdInputField.sendKeys(text);
    }

    public void setCampaignIdInputField(String text) {
        ElementUtils.waitUntilClickable(driver, campaignIdInputField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        campaignIdInputField.sendKeys(text);
    }

    public void setServiceNumberInputField(String text) {
        ElementUtils.waitUntilClickable(driver, codeNameInputField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        codeNameInputField.sendKeys(text);
    }



}
