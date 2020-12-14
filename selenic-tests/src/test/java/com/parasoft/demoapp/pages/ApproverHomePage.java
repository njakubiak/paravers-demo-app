package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.GlobalUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class ApproverHomePage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='middle']/table/tbody/tr[2]/th/a")
    public WebElement orderNumber_1;

    @FindBy(xpath = "//*[@class='requested_assets common_industry industry_font']/div/p/span[2]")
    public WebElement requestedAssets;

    @FindBy(xpath = "//*[@id='order_detail_region_summary']/div[2]")
    public WebElement region;

    @FindBy(xpath = "//*[@id='order_detail_region_summary']/div[6]")
    public WebElement location;

    @FindBy(xpath = "//*[@id='response_select']")
    public WebElement response;

    @FindBy(xpath = "//*[@id='response_select']/option[2]")
    public WebElement appprove;

    @FindBy(xpath = "//*[@id='response_select']/option[3]")
    public WebElement reject;

    @FindBy(xpath = "//*[@id='order_detail_map']/img")
    public WebElement image;

    @FindBy(xpath = "//*[@id='save_btn']")
    public WebElement saveAndSendButton;

    @FindBy(xpath = "/descendant::span[normalize-space(.)='X']")
    public WebElement x;

    @FindBy(xpath = "//*[@id='middle']//tr[@class='order_title']/th[@class='status ng-scope']")
    public WebElement statusLabel;

    @FindBy(xpath = "//*[@id='middle']//tr[@class='order_title']/th[@class='requisition_number ng-scope']")
    public WebElement requisitionNumberLabel;

    @FindBy(xpath = "//*[@id='middle']//tr[@class='order_title']/th[@class='submission_date ng-scope']")
    public WebElement submissionDateLabel;

    @FindBy(xpath = "//*[@id='middle']//tr[@class='order_title']/th[@class='time ng-scope']")
    public WebElement timeLabel;

    @FindBy(xpath = "//*[@id='middle']/table/tbody/tr[*]/th/a")
    public List<WebElement> ordersList;

    @FindBy(xpath = "//*[@id='map']/img")
    public WebElement imagePath;

    @FindBy(xpath = "//*[@id='order_buttons']/a[@class='pre_btn btn']")
    public WebElement leftArrow;

    @FindBy(xpath = "//*[@id='page_number']/p/span[1]")
    public WebElement currentPage;

    @FindBy(xpath = "//*[@id='page_number']/p/span[3]")
    public WebElement totalPage;

    @FindBy(xpath = "//*[@id='order_buttons']/a[@class='next_btn btn']")
    public WebElement rightArrow;

    @FindBy(xpath = "//*[@id='page_title']/p/span")
    public WebElement requisition;

    @FindBy(xpath = "//div[@class='item_title item_title1 common_industry industry_font']" +
            "/div[@class='common_text']/p/span")
    public WebElement itemName;

    @FindBy(xpath = "//div[@class='item_quantity item_quantity1 common_industry industry_font']" +
            "/div[@class='common_text']//span[2]")
    public WebElement itemQuantity;

    @FindBy(xpath = "//*[@id='order_items']/div[@class='ng-scope']/div[1]/img")
    public WebElement itemImagePath;

    @FindBy(xpath = "//*[@id='order_detail_region_summary']/div[4]")
    public WebElement platoonID;

    @FindBy(xpath = "//*[@id='order_detail_assigned_campaign_summary']/div[2]")
    public WebElement campaignID;

    @FindBy(xpath = "//*[@id='order_detail_assigned_campaign_summary']/div[4]")
    public WebElement codeName;

    @FindBy(name = "comments")
    public WebElement commentsField;

    @FindBy(xpath = "//*[@id='cancel_btn']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id='requisition_response']/div[2]/span")
    public WebElement responseResult;

    @FindBy(xpath = "//*[@id='comments']/span")
    public WebElement reason;

    @FindBy(xpath = "//span[text()='No orders exist.']")
    public WebElement emptyErrorMessage;

    @FindBy(xpath = "/html/body//div[@class='common_text']/p/span")
    public WebElement incorrectOrdersEndpoint;

    public ApproverHomePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void viewOrderDetail(){
        ElementUtils.waitUntilClickable(driver,orderNumber_1,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.clickElementUseJs(driver,orderNumber_1);
    }

    public void clickResponse(){
        ElementUtils.waitUntilClickable(driver,response,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void approveOrder(){ ElementUtils.waitUntilClickable
            (driver,appprove,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click(); }

    public void rejectOrder(){ ElementUtils.waitUntilClickable
            (driver,reject,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click(); }

    public void clickSaveAndSendButton(){
        ElementUtils.waitUntilClickable
                (driver,saveAndSendButton,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void closeWindows(){
        ElementUtils.waitUntilClickable(driver,x,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickCancelButton(){
        ElementUtils.waitUntilClickable(driver,cancelButton,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickOrderNumber(String orderNumber) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement clickOrderNumber = driver.findElement
                (By.xpath("//*[@id='middle']/table/tbody/tr[*]/th/a[text()='"+orderNumber+"']"));
        ElementUtils.waitUntilClickable(driver, clickOrderNumber, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        clickOrderNumber.click();
    }

    public void setReasonField(String text) {
        ElementUtils.waitUntilClickable(driver, commentsField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        commentsField.sendKeys(text);
    }
}
