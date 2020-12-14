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

public class OrdersPage {

    @FindBy(xpath = "/html/body//th[@class='status ng-scope']")
    public WebElement statusLabel;

    @FindBy(xpath = "/html/body//th[@class='requisition_number ng-scope']")
    public WebElement orderNumberLabel;

    @FindBy(xpath = "/html/body//th[@class='submission_date ng-scope']")
    public WebElement submissionDateLabel;

    @FindBy(xpath = "/html/body//th[@class='approver_reply_date ng-scope']")
    public WebElement approverReplyDateLabel;

    @FindBy(xpath = "/html/body//th[@class='assets ng-scope']")
    public WebElement assetsLabel;

    @FindBy(xpath = "//table/tbody/tr[2]/th/a")
    public WebElement orderNumber_1;

    @FindBy(xpath = "//*[@class='requested_assets common_industry industry_font']/div/p/span[2]")
    public WebElement requestedAssets;

    @FindBy(xpath = "//*[@id='order_detail_region_summary']/div[2]")
    public WebElement region;

    @FindBy(xpath = "//*[@id=\"order_detail_region_summary\"]/div[6]")
    public WebElement location;

    @FindBy(xpath = "//*[@id='order_detail_map']/img")
    public WebElement image;

    @FindBy(xpath = "//*[@id='close_btn']/button")
    public WebElement closeButton;

    @FindBy(xpath = "//*[@id='req_title']//span[text() = 'REQUISITIONS']")
    public WebElement requisitionTitle;

    @FindBy(xpath = "//*[@class='order_content ng-scope']")
    public List<WebElement> ordersList;

    @FindBy(xpath = "//*[@id='order_buttons']/a[@class='pre_btn btn']")
    public WebElement leftArrow;

    @FindBy(xpath = "//*[@id='page_number']/p/span[1]")
    public WebElement currentPage;

    @FindBy(xpath = "//*[@id='page_number']/p/span[3]")
    public WebElement totalPage;

    @FindBy(xpath = "//*[@id='order_buttons']/a[@class='next_btn btn']")
    public WebElement rightArrow;

    @FindBy(xpath = "//*[@id='return_to_home']/div[@class='common_text']/p/a")
    public WebElement homeLick;

    @FindBy(xpath = "//*[@id='order_items']//div[@class='order_item_title common_industry industry_font']" +
            "/div[@class='common_text']/p/span")
    public WebElement itemName;

    @FindBy(xpath = "//*[@id='order_items']//div[@class='common_text']/p/span[2]")
    public WebElement itemQuantity;

    @FindBy(xpath = "//*[@id='order_items']/div[@class='ng-scope']/div[1]/img")
    public WebElement itemImagePath;

    @FindBy(xpath = "//*[@id='order_rejected_reason_content']/div")
    public WebElement comments;

    @FindBy(xpath = "//*[@id='order_detail_title']/div")
    public WebElement orderTitle;

    @FindBy(xpath = "//span[text()='No orders exist.']")
    public WebElement emptyErrorMessage;

    @FindBy(xpath = "//body/div[3]/div[5]/div/div/p/span")
    public WebElement incorrectOrdersEndpoint;

    private WebDriver driver;

    public OrdersPage(WebDriver driver)  {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void viewOrderDetail(){
        ElementUtils.waitUntilClickable(driver, orderNumber_1, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void closeWindows(){
        ElementUtils.waitUntilClickable(driver, closeButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickHomeLink(){
        ElementUtils.waitUntilClickable(driver, homeLick, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickOrderNumber(String orderNumber) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement clickOrderNumber = driver.findElement
                (By.xpath("//table//a[text()='"+ orderNumber + "']"));
        ElementUtils.waitUntilClickable(driver, clickOrderNumber, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        clickOrderNumber.click();
    }
}
