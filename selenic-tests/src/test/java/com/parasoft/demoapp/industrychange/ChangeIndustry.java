package com.parasoft.demoapp.industrychange;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.DemoAdminPage;
import com.parasoft.demoapp.pages.HeaderArea;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeIndustry {


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
    public void testChangeIndustry() throws Throwable {
        GlobalUtils.login(driver,Properties.PURCHASER_USERNAME,Properties.PURCHASER_PASSWORD);
        GlobalUtils.switchToDemoAdminPage(driver);

        // Switch to different industry
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        HeaderArea headerArea = new HeaderArea(driver);
        if(IndustryType.AEROSPACE.toString().equals(Properties.TARGET_INDUSTRY)){
            demoAdminPage.switchToAerospace();
            ElementUtils.waitUntilElementTextAppear
                    (driver,headerArea.titleInPurchaserPage,Properties.AEROSPACE_PRODUCT_NAME,
                            Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
            ElementUtils.waitUntilElementTextAppear
                    (driver,headerArea.nickNameInPurchaser,WebUIConstants.PURCHASING_AEROSPACE,
                            Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
            ElementUtils.waitUntilElementTextAppear
                    (driver,demoAdminPage.currentIndustry,IndustryType.AEROSPACE.toString(),
                            Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
            assertEquals(Properties.AEROSPACE_PRODUCT_NAME, headerArea.titleInPurchaserPage.getText());
            assertEquals(WebUIConstants.PURCHASING_AEROSPACE, headerArea.nickNameInPurchaser.getText());
            assertEquals(IndustryType.AEROSPACE.toString(), demoAdminPage.currentIndustry.getText());
        }else if(IndustryType.DEFENSE.toString().equals(Properties.TARGET_INDUSTRY)){
            demoAdminPage.switchToDefense();
            ElementUtils.waitUntilElementTextAppear
                    (driver,headerArea.titleInPurchaserPage,Properties.DEFENSE_PRODUCT_NAME,
                            Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
            ElementUtils.waitUntilElementTextAppear
                    (driver,headerArea.nickNameInPurchaser,WebUIConstants.PURCHASING_DEFENSE,
                            Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
            ElementUtils.waitUntilElementTextAppear
                    (driver,demoAdminPage.currentIndustry,IndustryType.DEFENSE.toString(),
                            Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
            assertEquals(Properties.DEFENSE_PRODUCT_NAME, headerArea.titleInPurchaserPage.getText());
            assertEquals(WebUIConstants.PURCHASING_DEFENSE, headerArea.nickNameInPurchaser.getText());
            assertEquals(IndustryType.DEFENSE.toString(), demoAdminPage.currentIndustry.getText());
        }
        GlobalUtils.switchToLogout(driver);
    }
}
