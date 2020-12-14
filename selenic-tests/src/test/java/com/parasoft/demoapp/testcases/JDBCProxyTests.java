package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.testng.Assert.assertTrue;

public class JDBCProxyTests {
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
    public void testJDBCProxy() throws Throwable {
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.enableJDBC();
        assertTrue(demoAdminPage.JDBCProxyPathResetButtons.isEnabled());
        assertTrue(demoAdminPage.JDBCProxyGroupIDResetButtons.isEnabled());
        assertTrue(demoAdminPage.JDBCProxyURLResetButtons.isEnabled());
        assertTrue(demoAdminPage.JDBCProxyTestConnectButtons.isEnabled());
        demoAdminPage.setJDBCPathProxy("!");
        assertEquals(WebUIConstants.INCORRECT_PATH,demoAdminPage.invalidPathMessage.getText());
        demoAdminPage.clickJDBCProxyPathResetButton();
        assertEquals(Properties.DEFAULT_PARASOFT_JDBC_PROXY_PATH,demoAdminPage.JDBCProxyPathInputFeild.getAttribute("value"));
        demoAdminPage.setJDBCGroupIDProxy("!");
        assertEquals(WebUIConstants.INCORRECT_GROUP_ID,demoAdminPage.invalidGroupIDMessage.getText());
        demoAdminPage.clickJDBCProxyGroupIDResetButton();
        assertEquals(Properties.DEFAULT_PARASOFT_JDBC_PROXY_GROUP_ID,demoAdminPage.JDBCProxyGroupIDInputFeild.getAttribute("value"));
        demoAdminPage.setJDBCURLProxy("http://localhost:");
        assertEquals(WebUIConstants.INCORRECT_URL,demoAdminPage.invalidURLMessage.getText());
        demoAdminPage.setJDBCURLProxy("http://localhost:8080");
        demoAdminPage.clickSaveChangesButton();
        driver.navigate().refresh();
        demoAdminPage.enableJDBC();
        assertEquals(Properties.DEFAULT_PARASOFT_JDBC_PROXY_URL,demoAdminPage.JDBCProxyURLInputFeild.getAttribute("value"));
        demoAdminPage.setJDBCURLProxy("http://localhost:8080");
        demoAdminPage.clickJDBCProxyTestConnectButton();
        ElementUtils.waitUntilVisible(driver,demoAdminPage.connectFail,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.URL_CONNECT_FAIL,demoAdminPage.connectFail.getText());
        demoAdminPage.clickJDBCProxyURLResetButton();
        assertEquals(Properties.DEFAULT_PARASOFT_JDBC_PROXY_URL,demoAdminPage.JDBCProxyURLInputFeild.getAttribute("value"));
        demoAdminPage.clickJDBCProxyTestConnectButton();
        assertTrue(demoAdminPage.saveChangesButton.isEnabled());
        ElementUtils.waitUntilVisible(driver,demoAdminPage.connectFail,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals(WebUIConstants.URL_CONNECT_FAIL,demoAdminPage.connectFail.getText());

    }
}
