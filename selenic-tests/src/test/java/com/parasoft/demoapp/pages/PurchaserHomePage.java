package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PurchaserHomePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='assets_title']//span[text()='ALL ASSETS']")
    public WebElement assetsTitle;

    @FindBy(xpath = "//*[@class='assets_categories']/div[*]/div[4]/div/p/a/span")
    public List <WebElement> categoriesList;

    @FindBy(xpath = "//*[@class='assets_categories']/div[1]//p[@class='view_all']/a")
    public WebElement viewAllLink1;

    @FindBy(xpath = "//*[@id='right_side_content1_text']/div[@class='common_text']/a")
    public WebElement webReplayLink;

    @FindBy(xpath = "//*[@id='right_side_content2_text']/div[@class='common_text']/a")
    public WebElement analystReportLink;

    @FindBy(xpath = "//*[@id='right_side_content3_text']/div[@class='common_text']/a")
    public WebElement companyBlogLink;

    @FindBy(xpath = "//*[@id='advertisement']/a")
    public WebElement advertisementLink;

    @FindBy(xpath = "//*[@id='right_side_content1_title']/div[2]/p/span")
    public WebElement webReplayText;

    @FindBy(xpath = "//*[@id='right_side_content2_title']/div[2]/p/span")
    public WebElement analystReportText;

    @FindBy(xpath = "//*[@id='right_side_content3_title']/div[2]/p/span")
    public WebElement companyBlogText;

    @FindBy(xpath = "//span[text()='No categories exist.']")
    public WebElement emptyErrorMessage;

    @FindBy(xpath = "//body/div[@class='ng-scope']/div[2]/div/div[@class='common_text']/p")
    public WebElement incorrectCategoriesEndpoint;

    public PurchaserHomePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void viewCategory() {
        ElementUtils.clickElementUseJs(driver,viewAllLink1);
    }

    public void clickWebReplayLink() {
        ElementUtils.clickElementUseJs(driver,webReplayLink);
    }

    public void clickAnalystReportLink() {
        ElementUtils.clickElementUseJs(driver,analystReportLink);
    }

    public void clickCompanyBlogLink() {
        ElementUtils.clickElementUseJs(driver,companyBlogLink);
    }

    public void clickAdvertisementLink() {
        ElementUtils.clickElementUseJs(driver,advertisementLink);
    }
}
