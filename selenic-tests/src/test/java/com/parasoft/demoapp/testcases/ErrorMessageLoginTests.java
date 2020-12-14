package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorMessageLoginTests {
    private WebDriver driver;

    @BeforeEach
    public void beforeTest() {
        driver = WebDriverDecider.decide();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testErrorMessageLogin() throws Throwable {
        // Error password login
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.ERROR_PURCHASER_PASSWORD);
        LoginPage loginPage = new LoginPage(driver);
        ElementUtils.waitUntilVisible(driver,loginPage.loginErrorText,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.LOGIN_ERROR_TEXT,loginPage.loginErrorText.getText());

        // Error username login
        GlobalUtils.login(driver, Properties.ERROR_APPROVER_USERNAME, Properties.APPROVER_PASSWORD);
        ElementUtils.waitUntilVisible(driver,loginPage.loginErrorText,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.LOGIN_ERROR_TEXT,loginPage.loginErrorText.getText());

        // Error username and password login
        GlobalUtils.login(driver, Properties.ERROR_PURCHASER_USERNAME, Properties.ERROR_APPROVER_PASSWORD);
        ElementUtils.waitUntilVisible(driver,loginPage.loginErrorText,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.LOGIN_ERROR_TEXT,loginPage.loginErrorText.getText());

        // Username or password is empty
        GlobalUtils.login(driver, Properties.EMPTY_APPROVER_USERNAME, Properties.EMPTY_APPROVER_PASSWORD);
        ElementUtils.waitUntilVisible(driver,loginPage.loginErrorText,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.LOGIN_ERROR_TEXT,loginPage.loginErrorText.getText());
    }
}
