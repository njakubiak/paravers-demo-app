package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.Properties;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterArea {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='footer_div']//span[@class='ng-scope']")
    public WebElement footerInfo;

    public FooterArea(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }
}
