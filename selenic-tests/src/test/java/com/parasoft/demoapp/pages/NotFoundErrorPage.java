package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.ElementUtils;
import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotFoundErrorPage {
    private WebDriver driver;

    @FindBy(xpath = "/html//div[@class='content']/div")
    public WebElement message;

    @FindBy(xpath = "/html//a[@class='go_home']")
    public WebElement returnToHomePageLink;

    public NotFoundErrorPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void backToHomePage(){
        ElementUtils.waitUntilClickable(driver,returnToHomePageLink,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }
}
