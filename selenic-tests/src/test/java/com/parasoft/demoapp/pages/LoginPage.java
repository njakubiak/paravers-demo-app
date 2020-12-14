package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='submit_button']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id='title_text']/a")
    public WebElement productName;

    @FindBy(xpath = "//*[@id='error_message']")
    public WebElement loginErrorText;

    private WebDriver driver;

    public LoginPage(WebDriver driver)  {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void setUsernameField(String text) {
        ElementUtils.waitUntilClickable(driver, usernameField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        usernameField.sendKeys(text);
    }

    public void setPasswordField(String text) {
        ElementUtils.waitUntilClickable(driver, passwordField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        passwordField.sendKeys(text);
    }

    public void clickSignInButton() {
        ElementUtils.waitUntilClickable(driver, signInButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }
}
