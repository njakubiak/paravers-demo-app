package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.GlobalUtils;
import com.parasoft.demoapp.common.Properties;
import com.parasoft.demoapp.common.WebDriverDecider;
import com.parasoft.demoapp.pages.DemoAdminPage;
import com.parasoft.demoapp.pages.PurchaserHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowOrHideAdvertisementTests {
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
    public void ShowOrHideAdvertisement() throws Throwable {

        // Purchaser login.
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);

        // Hide advertisement.
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.showOrHideAdvertisement();
        assertEquals(null,demoAdminPage.showRatio.getAttribute("checked"));

        // Display advertisement.
        GlobalUtils.switchToDemoAdminPage(driver);
        demoAdminPage.showOrHideAdvertisement();
        assertEquals("true",demoAdminPage.showRatio.getAttribute("checked"));

        // log out.
        GlobalUtils.switchToLogout(driver);
    }

}
