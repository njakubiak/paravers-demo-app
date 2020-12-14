package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.CategoryPage;
import com.parasoft.demoapp.pages.DemoAdminPage;
import com.parasoft.demoapp.pages.PurchaserHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaserHomePageTests {
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
    public void testPurchaserHomePage() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        GlobalUtils.resetDatabase(driver);
        demoAdminPage.setDefaultInfo();
        assertEquals(Properties.WEB_REPLAY_URL,purchaserHomePage.webReplayLink.getAttribute("href"));
        assertEquals(Properties.ANALYST_REPORT_URL,purchaserHomePage.analystReportLink.getAttribute("href"));
        assertEquals(Properties.ADVERTISEMENT_URL,purchaserHomePage.advertisementLink.getAttribute("href"));
        assertEquals(WebUIConstants.WEBINAR_REPLAY,purchaserHomePage.webReplayText.getText());
        assertEquals(WebUIConstants.ANALYST_REPORT,purchaserHomePage.analystReportText.getText());
        assertEquals(WebUIConstants.COMPANY_BLOG,purchaserHomePage.companyBlogText.getText());

        // Verify the page is not empty and the first category can clicked
        int numberOfCategories = purchaserHomePage.categoriesList.size();
        if(numberOfCategories > 0){
            purchaserHomePage.viewCategory();
            ElementUtils.waitUntilVisible(driver,categoryPage.categoryName,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
            String currentURL = driver.getCurrentUrl();
            boolean result = currentURL.contains("categories");
            assertEquals(true, result);
            GlobalUtils.switchToHomepage(driver);
            System.out.println("Database isn't empty");
        }else {
            System.out.println("Database is empty");
        };

        // Click links in the advertisement
        purchaserHomePage.clickWebReplayLink();
        purchaserHomePage.clickAnalystReportLink();
        purchaserHomePage.clickAdvertisementLink();
        GlobalUtils.switchToLogout(driver);
    }
}
