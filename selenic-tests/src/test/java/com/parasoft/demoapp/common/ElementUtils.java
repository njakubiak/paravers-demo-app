package com.parasoft.demoapp.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ElementUtils {

    public static WebElement waitUntilClickable(WebDriver driver, WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(elementToBeClickable(element));
    }

    public static WebElement waitUntilVisible(WebDriver driver, WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(visibilityOf(element));
    }

    public static void clickElementUseJs(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();",element);
    }

    public static WebElement waitUntilElementTextAppear(WebDriver driver, WebElement element, String text,long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        return wait.until(visibilityOf(element));
    }

    private Boolean waitUntilAttributeToBe(WebDriver driver,WebElement element, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(attributeToBe(element, attribute, value));
    }
}
