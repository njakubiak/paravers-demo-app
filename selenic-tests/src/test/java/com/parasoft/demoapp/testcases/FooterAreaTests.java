package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.FooterArea;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FooterAreaTests {
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
    public void testPurchaserFooterArea() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        FooterArea footerArea = new FooterArea(driver);
        ElementUtils.waitUntilVisible(driver,footerArea.footerInfo,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(Properties.DEFENSE_PRODUCT_NAME,footerArea.footerInfo.getText());
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(Properties.AEROSPACE_PRODUCT_NAME,footerArea.footerInfo.getText());
        }
    }
    @Test
    public void testApproverFooterArea() throws Throwable {
        // Approver log in
        GlobalUtils.login(driver, Properties.APPROVER_USERNAME, Properties.APPROVER_PASSWORD);
        FooterArea footerArea = new FooterArea(driver);
        ElementUtils.waitUntilVisible(driver,footerArea.footerInfo,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(Properties.DEFENSE_PRODUCT_NAME,footerArea.footerInfo.getText());
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(Properties.AEROSPACE_PRODUCT_NAME,footerArea.footerInfo.getText());
        }
    }
}
