package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderAreaTests {

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
    public void testPurchaserHeaderArea() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);

        // Verify header area info whether match to current industry (nick name and title)
        HeaderArea headerArea = new HeaderArea(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        DemoAdminPage demoAdminPage = new DemoAdminPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        ElementUtils.waitUntilVisible(driver,headerArea.titleInPurchaserPage,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,headerArea.nickNameInPurchaser,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(Properties.DEFENSE_PRODUCT_NAME, headerArea.titleInPurchaserPage.getText());
            assertEquals(WebUIConstants.PURCHASING_DEFENSE, headerArea.nickNameInPurchaser.getText());
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(Properties.AEROSPACE_PRODUCT_NAME, headerArea.titleInPurchaserPage.getText());
            assertEquals(WebUIConstants.PURCHASING_AEROSPACE, headerArea.nickNameInPurchaser.getText());
        }

        // Verify buttons in header area whether can be click and pages jump correct
        // Navigate to demo admin page
        headerArea.clickSettingButton();
        WebElement demoAdministrationLabel = driver.findElement
                (By.xpath("//*[@id='industry_title']//span[text()='DEMO ADMINISTRATION: ']"));
        ElementUtils.waitUntilVisible(driver, demoAdministrationLabel, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(WebUIConstants.DEFENSE,demoAdminPage.currentIndustry.getText());
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(WebUIConstants.AEROSPACE,demoAdminPage.currentIndustry.getText());
        }
        String currentUrlURL = driver.getCurrentUrl();
        assertEquals(Properties.DEMO_ADMIN_PAGE_URL,currentUrlURL);

        // Navigate to home page
        headerArea.clickProductName();
        WebElement allAssetsLabel = driver.findElement(By.xpath("//div[@id='assets_title']//span[text()='ALL ASSETS']"));
        ElementUtils.waitUntilVisible(driver, allAssetsLabel, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        currentUrlURL = driver.getCurrentUrl();
        assertEquals(Properties.HOME_PAGE_URL,currentUrlURL);

        // Navigate to orders page
        headerArea.clickOrdersButton();
        ElementUtils.waitUntilElementTextAppear
                (driver, ordersPage.requisitionTitle, "REQUISITIONS", Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        currentUrlURL = driver.getCurrentUrl();
        assertEquals(Properties.ORDERS_PAGE_URL,currentUrlURL);

        // Open and close cart
        headerArea.openCartPopup();
        assertFalse(cartPage.submitButton.isEnabled());
        headerArea.closeCartPopup();

        // log out
        headerArea.clickNickNameInPurchaser();
        ElementUtils.waitUntilClickable(driver, headerArea.signOutLink,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        headerArea.clickSignOutLink();
        ElementUtils.waitUntilVisible(driver,loginPage.signInButton,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
//        WebElement titleLabelInLoginPage = driver.findElement(By.xpath("//*[@id='submit_button']"));
//        ElementUtils.waitUntilVisible(driver, titleLabelInLoginPage, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        currentUrlURL = driver.getCurrentUrl();
        assertEquals(Properties.LOGIN_PAGE_URL,currentUrlURL);
    }
    @Test
    public void testApproverHeaderArea() throws Throwable {

        // Approver log in
        GlobalUtils.login(driver, Properties.APPROVER_USERNAME, Properties.APPROVER_PASSWORD);

        // Verify header area info whether match to current industry (nick name)
        HeaderArea headerArea = new HeaderArea(driver);
        LoginPage loginPage = new LoginPage(driver);
        ElementUtils.waitUntilClickable(driver, headerArea.titleInApproverPage,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(WebUIConstants.APPROVER_TITLE, headerArea.titleInApproverPage.getText());
            assertEquals(WebUIConstants.APPROVER_DEFENSE, headerArea.nickNameInApprover.getText());
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(WebUIConstants.APPROVER_TITLE, headerArea.titleInApproverPage.getText());
            assertEquals(WebUIConstants.APPROVER_AEROSPACE, headerArea.nickNameInApprover.getText());
        }

        // Verify setting button in header area whether can be click and page jumps correct
        // Navigate to demo admin page
        headerArea.clickSettingButton();
        WebElement demoAdministrationLabel = driver.findElement
                (By.xpath("//*[@id='industry_title']//span[text()='DEMO ADMINISTRATION: ']"));
        ElementUtils.waitUntilVisible(driver, demoAdministrationLabel, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        String currentUrlURL = driver.getCurrentUrl();
        assertEquals(Properties.DEMO_ADMIN_PAGE_URL,currentUrlURL);

        // Navigate to home page
        headerArea.clickProductName();
        WebElement allAssetsLabel = driver.findElement(By.xpath("//*[@id='page_title']//span[text()='REQUISITION REQUESTS']"));
        ElementUtils.waitUntilVisible(driver, allAssetsLabel, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        currentUrlURL = driver.getCurrentUrl();
        assertEquals(Properties.HOME_PAGE_URL,currentUrlURL);

        // Log out
        headerArea.clickNickNameInApprover();
        ElementUtils.waitUntilClickable(driver, headerArea.signOutLink,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        headerArea.clickSignOutLink();
        ElementUtils.waitUntilVisible(driver,loginPage.signInButton,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
//        WebElement titleLabelInLoginPage = driver.findElement(By.xpath("//*[@id='submit_button']"));
//        ElementUtils.waitUntilVisible(driver, titleLabelInLoginPage, Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        currentUrlURL = driver.getCurrentUrl();
        assertEquals(Properties.LOGIN_PAGE_URL, currentUrlURL);
    }
    }
