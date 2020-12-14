package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='item_title']//span[@class='font_color2 nowrap retract_format ng-binding']")
    public WebElement itemName;

    @FindBy(xpath = "//*[@id='item_detail_breadcrumb']/ol/li[2]/a")
    public WebElement categoryLink;

    @FindBy(xpath = "//*[@id='item_detail_breadcrumb']/ol/li[3]")
    public WebElement itemInNavigateBar;

    @FindBy(xpath = "//*[@id='item_description']//span[@class='item_detail_des_format ng-binding']")
    public WebElement itemDescription;

    @FindBy(xpath = "//*[@id='item_available']/div[2]/p[@class='in_stock']/span[@class='ng-binding']")
    public WebElement itemInventory;

    @FindBy(xpath = "//*[@id='item_available']/div[2]/p[2]/span[@class='ng-binding']")
    public WebElement itemQuantityInCart;

    @FindBy(xpath = "//*[@id='item_img']/img")
    public WebElement itemImage;

    @FindBy(linkText = "Home")
    public WebElement homeLink;

    @FindBy(xpath = "//*[@id='item_plus']/div[@class='common_text']/button")
    public WebElement increaseButton;

    @FindBy(xpath = "//*[@id='item_minus']/div[@class='common_text']/button")
    public WebElement reduceButton;

    @FindBy(xpath = "//*[@id='item_to_requisition']/div[@class='common_text']/button")
    public WebElement addToRequisitionButton;

    @FindBy(xpath = "//div[@class='ng-scope']//p[@class='ng-scope']/span")
    public WebElement incorrectItemsEndpoint;

    public ItemDetailPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void clickIncreaseButton() {
        ElementUtils.clickElementUseJs(driver,increaseButton);
    }

    public void clickReduceButton() {
        ElementUtils.clickElementUseJs(driver,reduceButton);
    }

    public void clickAddToRequisition() {
        ElementUtils.clickElementUseJs(driver,addToRequisitionButton);
    }

    public void clickHomeLink() {
        ElementUtils.clickElementUseJs(driver,homeLink);
    }

    public void clickCategoryLink() {
        ElementUtils.clickElementUseJs(driver,categoryLink);
    }

}
