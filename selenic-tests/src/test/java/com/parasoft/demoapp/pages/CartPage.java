package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='submit_button']/button")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='assets_amount']")
    public WebElement quantityInCart;

    @FindBy(xpath = "//*[@id='shopping_cart']//div[@class='common_text']/p/a")
    public WebElement itemNameInCart;

    @FindBy(xpath = "//*[@id='shopping_cart']/div/div[2]/img")
    public WebElement itemImagePath;

    @FindBy(xpath = "//*[@id='shopping_cart']//div[@class='common_text']/textarea")
    public WebElement itemDescriptionInCart;

    @FindBy(xpath = "//*[@id='shopping_cart']/div/div[8]/button")
    public WebElement increaseButtonInCart;

    @FindBy(xpath = "//*[@id='shopping_cart']/div/div[7]/button")
    public WebElement reduceButtonInCart;

    @FindBy(xpath = "//*[@id='shopping_cart']/div/div[9]/a")
    public WebElement removeButtonInCart;

    @FindBy(xpath = "//*[@id=\"shopping_cart\"]//div[@class='requisition_error requisition_error1']")
    public WebElement availableQuantity;

    @FindBy(xpath = "//*[@id=\"shopping_cart\"]//div[@class='requisition_error requisition_error1']/span[3]")
    public WebElement itemInvalid;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void removeItem() {
        ElementUtils.clickElementUseJs(driver,removeButtonInCart);
    }

    public void increaseItem() {
        ElementUtils.waitUntilClickable(driver,increaseButtonInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void reduceItem() {
        ElementUtils.waitUntilClickable(driver,reduceButtonInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void submitOrder() {
        ElementUtils.clickElementUseJs(driver,submitButton);
    }

    public void clickItemName() {
        ElementUtils.clickElementUseJs(driver,itemNameInCart);
    }
}
