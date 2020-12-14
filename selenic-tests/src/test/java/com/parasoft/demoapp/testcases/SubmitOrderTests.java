package com.parasoft.demoapp.testcases;

import com.parasoft.demoapp.common.*;
import com.parasoft.demoapp.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SubmitOrderTests {
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
    public void testOrderWizardUI() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        GlobalUtils.resetDatabase(driver);
        OrderWizardPage orderWizardPage = new OrderWizardPage(driver);
        GlobalUtils.switchToDifferentURL(driver,Properties.ORDERS_WIZARD_PAGE_URL);
        String message1 = "345-2489-21";
        String message2 = "55-464-95-21";
        String message3 = "4590-324-7894";
        String industry = "";
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            industry = "defense";
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            industry = "aerospace";
        }

        // Verify page UI in wizard one
        assertEquals(WebUIConstants.ORDER_WIZARD_FIRST,orderWizardPage.developmentLocation.getText());
        assertEquals(WebUIConstants.ORDER_WIZARD_SECOND,orderWizardPage.assignCampaign.getText());
        assertEquals(WebUIConstants.ORDER_WIZARD_THIRD,orderWizardPage.review.getText());
        assertFalse(orderWizardPage.getLocationButton.isEnabled());
        assertFalse(orderWizardPage.assignToCampaignButton.isEnabled());
        assertEquals(Properties.BASE_URL + "/"+ industry +"/images/world_map.svg",
                orderWizardPage.imagePathDefault.getAttribute("src"));
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(WebUIConstants.DEFENSE_PLATOON,orderWizardPage.platoonIDOrContinentID.getText());
            assertEquals(WebUIConstants.DEFENSE_REGION,orderWizardPage.regionOrPlanets.getText());
            orderWizardPage.clickRegionDropDownButton();
            ElementUtils.waitUntilVisible(driver,orderWizardPage.option2,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
            assertEquals(LocationConstants.UNITED_STATES_REGION,orderWizardPage.option2.getText());
            assertEquals(LocationConstants.UNITED_KINGDOM_REGION,orderWizardPage.option3.getText());
            assertEquals(LocationConstants.GERMANY_REGION,orderWizardPage.option4.getText());
            assertEquals(LocationConstants.FRANCE_REGION,orderWizardPage.option5.getText());
            assertEquals(LocationConstants.JAPAN_REGION,orderWizardPage.option6.getText());
            assertEquals(LocationConstants.SOUTH_KOREA_REGION,orderWizardPage.option7.getText());
            assertEquals(LocationConstants.SPAIN_REGION,orderWizardPage.option8.getText());
            assertEquals(LocationConstants.AUSTRALIA_REGION,orderWizardPage.option9.getText());
            orderWizardPage.selectRegion(LocationConstants.UNITED_STATES_REGION);
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(WebUIConstants.AEROSPACE_PLANETS,orderWizardPage.regionOrPlanets.getText());
            assertEquals(WebUIConstants.AEROSPACE_STATION_ID,orderWizardPage.platoonIDOrContinentID.getText());
            orderWizardPage.clickRegionDropDownButton();
            ElementUtils.waitUntilVisible(driver,orderWizardPage.option2,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
            assertEquals(LocationConstants.MERCURY_REGION,orderWizardPage.option2.getText());
            assertEquals(LocationConstants.VENUS_REGION,orderWizardPage.option3.getText());
            assertEquals(LocationConstants.EARTH_REGION,orderWizardPage.option4.getText());
            assertEquals(LocationConstants.MARS_REGION,orderWizardPage.option5.getText());
            assertEquals(LocationConstants.JUPITER_REGION,orderWizardPage.option6.getText());
            assertEquals(LocationConstants.SATURN_REGION,orderWizardPage.option7.getText());
            assertEquals(LocationConstants.URANUS_REGION,orderWizardPage.option8.getText());
            assertEquals(LocationConstants.NEPTUNE_REGION,orderWizardPage.option9.getText());
            orderWizardPage.selectRegion(LocationConstants.MERCURY_REGION);
        }
        orderWizardPage.setPlatoonIdInputField(message1);
        assertTrue(orderWizardPage.getLocationButton.isEnabled());
        orderWizardPage.clickGetLocationButton();
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            assertEquals(LocationConstants.UNITED_STATES_INFO,orderWizardPage.coordinate.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE, orderWizardPage.imagePath.getAttribute("src"));

        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            assertEquals(LocationConstants.MERCURY_INFO,orderWizardPage.coordinate.getText());
            assertEquals(LocationConstants.MERCURY_IMAGE, orderWizardPage.imagePathInReview.getAttribute("src"));
        }
        assertTrue(orderWizardPage.assignToCampaignButton.isEnabled());
        orderWizardPage.clickAssignToCampaignButton();

        // Verify page UI in wizard two
        assertFalse(orderWizardPage.goToReviewButton.isEnabled());
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            assertEquals(WebUIConstants.DEFENSE_CAMPAIGN_ID,orderWizardPage.campaignIDOrMissionID.getText());
            assertEquals(WebUIConstants.DEFENSE_CODE_NAME,orderWizardPage.codeNameOrUUPIC.getText());

        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            assertEquals(WebUIConstants.AEROSPACE_MISSION_ID,orderWizardPage.campaignIDOrMissionID.getText());
            assertEquals(WebUIConstants.AEROSPACE_UUPIC,orderWizardPage.codeNameOrUUPIC.getText());
        }
        orderWizardPage.setCampaignIdInputField(message2);
        orderWizardPage.setServiceNumberInputField(message3);
        assertTrue(orderWizardPage.goToReviewButton.isEnabled());
        orderWizardPage.clickGoToReviewButtonButton();

        // Verify page UI in wizard three
        assertTrue(orderWizardPage.submitForApproval.isEnabled());
        assertEquals("0",orderWizardPage.quantityOfOrder.getText());
        assertEquals(message1,orderWizardPage.IDInfo.getText());
        assertEquals(message2,orderWizardPage.campaignInfo.getText());
        assertEquals(message3,orderWizardPage.serviceInfo.getText());
        if (Properties.currentIndustry.equals(IndustryType.DEFENSE)) {
            assertEquals(LocationConstants.UNITED_STATES_INFO,orderWizardPage.coordinateInfo.getText());
            assertEquals(LocationConstants.UNITED_STATES_REGION,orderWizardPage.regionInfo.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE, orderWizardPage.imagePathInReview.getAttribute("src"));
        } else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)) {
            assertEquals(LocationConstants.MERCURY_INFO,orderWizardPage.coordinateInfo.getText());
            assertEquals(LocationConstants.MERCURY_REGION,orderWizardPage.regionInfo.getText());
            assertEquals(LocationConstants.MERCURY_IMAGE, orderWizardPage.imagePathInReview.getAttribute("src"));
        }
        GlobalUtils.switchToLogout(driver);
    }

    @Test
    public void testOrderWizard() throws Throwable {
        // Purchaser log in
        GlobalUtils.login(driver, Properties.PURCHASER_USERNAME, Properties.PURCHASER_PASSWORD);
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.addItemIntoCart(driver,1,5);
        HeaderArea headerArea = new HeaderArea(driver);
        CartPage cartPage = new CartPage(driver);
        OrderWizardPage orderWizardPage = new OrderWizardPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        ApproverHomePage approverHomePage = new ApproverHomePage(driver);
        PurchaserHomePage purchaserHomePage = new PurchaserHomePage(driver);
        headerArea.openCartPopup();
        ElementUtils.waitUntilVisible(driver,cartPage.itemNameInCart,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        String itemName = cartPage.itemNameInCart.getText();
        String itemImagePath = cartPage.itemImagePath.getAttribute("src");
        String message1 = "345-2489-21";
        String message2 = "55-464-95-21";
        String message3 = "4590-324-7894";

        // Submit order
        cartPage.submitOrder();
        orderWizardPage.clickRegionDropDownButton();
        ElementUtils.waitUntilVisible(driver,orderWizardPage.option2,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            orderWizardPage.selectRegion(LocationConstants.UNITED_STATES_REGION);
        }else if(Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            orderWizardPage.selectRegion(LocationConstants.MERCURY_REGION);
        }
        orderWizardPage.setPlatoonIdInputField(message1);
        orderWizardPage.clickGetLocationButton();
        orderWizardPage.clickAssignToCampaignButton();
        orderWizardPage.setCampaignIdInputField(message2);
        orderWizardPage.setServiceNumberInputField(message3);
        orderWizardPage.clickGoToReviewButtonButton();
        assertEquals("5",orderWizardPage.quantityOfOrder.getText());
        assertEquals(itemName,orderWizardPage.itemName.getText());
        assertEquals(itemImagePath,orderWizardPage.itemImagePath.getAttribute("src"));
        assertEquals("5",orderWizardPage.itemQuantity.getText());
        orderWizardPage.clickSubmitForApprovalButton();
        assertEquals("5",orderWizardPage.quantityOfOrder.getText());
        assertEquals(itemName,orderWizardPage.itemName.getText());
        assertEquals(itemImagePath,orderWizardPage.itemImagePath.getAttribute("src"));
        assertEquals("5",orderWizardPage.itemQuantity.getText());
        String orderNumber = orderWizardPage.orderNumber.getText();

        // Click home link to back to home page.
        orderWizardPage.clickHomeLink();
        ElementUtils.waitUntilVisible(driver,purchaserHomePage.assetsTitle,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        String currentURL = driver.getCurrentUrl();
        assertEquals(Properties.HOME_PAGE_URL,currentURL);

        // Verify orders detail information in orders page
        headerArea.clickOrdersButton();
        ElementUtils.waitUntilVisible(driver,ordersPage.orderNumber_1,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("",driver.findElement(By.xpath
                ("//table//a[text()='"+ orderNumber +"']/ancestor ::tr/td/span[text()='New']")).getText());
        ordersPage.clickOrderNumber(orderNumber);
        assertEquals("0",ordersPage.requestedAssets.getText());
        assertEquals(itemName,ordersPage.itemName.getText());
        assertEquals("5",ordersPage.itemQuantity.getText());
        assertEquals(itemImagePath,ordersPage.itemImagePath.getAttribute("src"));
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,ordersPage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.MERCURY_REGION,ordersPage.region.getText());
            assertEquals(LocationConstants.MERCURY_INFO,ordersPage.location.getText());
            assertEquals(LocationConstants.MERCURY_IMAGE,ordersPage.image.getAttribute("src"));
        }
        ordersPage.closeWindows();
        GlobalUtils.switchToLogout(driver);

        // Approver login and verify order detail
        GlobalUtils.login(driver, Properties.APPROVER_USERNAME, Properties.APPROVER_PASSWORD);
        ElementUtils.waitUntilVisible(driver,approverHomePage.orderNumber_1,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        ElementUtils.waitUntilVisible(driver,driver.findElement(By.xpath("//table/tbody/tr[*]/th/a" +
                        "[text()='"+orderNumber+"']/../../td/span[@class='new_label ng-scope']")),
                Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        assertEquals("New",driver.findElement(By.xpath("//table/tbody/tr[*]/th/a[text()='"+orderNumber+"']" +
                "/../../td/span[@class='new_label ng-scope']")).getText());
        approverHomePage.clickOrderNumber(orderNumber);
        assertEquals("5",approverHomePage.requestedAssets.getText());
        assertEquals(itemName,approverHomePage.itemName.getText());
        assertEquals("5",approverHomePage.itemQuantity.getText());
        assertEquals(itemImagePath,approverHomePage.itemImagePath.getAttribute("src"));
        assertEquals(message1,approverHomePage.platoonID.getText());
        assertEquals(message2,approverHomePage.campaignID.getText());
        assertEquals(message3,approverHomePage.codeName.getText());
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            assertEquals(LocationConstants.UNITED_STATES_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.UNITED_STATES_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.UNITED_STATES_IMAGE,approverHomePage.image.getAttribute("src"));
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            assertEquals(LocationConstants.MERCURY_REGION,approverHomePage.region.getText());
            assertEquals(LocationConstants.MERCURY_INFO,approverHomePage.location.getText());
            assertEquals(LocationConstants.MERCURY_IMAGE,approverHomePage.image.getAttribute("src"));
        }
        approverHomePage.clickResponse();
        assertEquals(WebUIConstants.APPROVE,approverHomePage.appprove.getText());
        assertEquals(WebUIConstants.DENY,approverHomePage.reject.getText());
        assertFalse(approverHomePage.saveAndSendButton.isEnabled());
        assertTrue(approverHomePage.cancelButton.isEnabled());
        approverHomePage.clickCancelButton();
        GlobalUtils.resetDatabase(driver);
        GlobalUtils.switchToLogout(driver);
    }
}
