package com.parasoft.demoapp.pages;

import com.parasoft.demoapp.common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoAdminPage {
    @FindBy(xpath = "/descendant::label[normalize-space(.)='Defense']")
    public WebElement defenseRatio;

    @FindBy(xpath = "/descendant::label[normalize-space(.)='Aerospace']")
    public WebElement aerospaceRatio;

    @FindBy(xpath = "/descendant::span[normalize-space(.)='SAVE CHANGES']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//*[@id='industry_title']//span[@class='ng-binding']")
    public WebElement currentIndustry;

    @FindBy(xpath = "//*[@id='demo_bugs_checkbox']/div/p[1]/label/input")
    public WebElement locationBugSelector;

    @FindBy(xpath = "//*[@id='demo_bugs_checkbox']/div/p[2]/label/input")
    public WebElement quantityBugSelector;

    @FindBy(xpath = "//*[@class='category_tab']")
    public WebElement categoryTab;

    @FindBy(xpath = "//*[@id='add_btn']")
    public WebElement addNewButton;

    @FindBy(xpath = "//*[@class='btn orange_button modal_save_btn ng-scope']")
    public WebElement modalSaveButton;

    @FindBy(xpath = "//*[@class='btn orange_button modal_confirm_btn ng-scope']")
    public WebElement modalConfirmButton;

    @FindBy(linkText = "ITEMS")
    public WebElement itemsTab;

    @FindBy(name = "name")
    public WebElement nameField;

    @FindBy(name = "inStock")
    public WebElement quantityField;

    @FindBy(name = "region")
    public WebElement regionDropdown;

    @FindBy(name = "categoryId")
    public WebElement categoryDropdown;

    @FindBy(xpath = "//*[@id=\"image_form\"]")
    public WebElement imageField;

    @FindBy(name = "description")
    public WebElement descriptionField;

    @FindBy(className = "fa")
    public WebElement removeImage;

    @FindBy(xpath = "/descendant::button[normalize-space(.)='CONFIRM']")
    public WebElement confirmButton;

    @FindBy(xpath = "//table/tbody/tr[@class='ng-scope']/td[1]/span")
    public List<WebElement> defaultDataList;

    @FindBy(xpath = "//*[@id='category_form']//div[@class='error_box']/span")
    public WebElement errorMessageInCategory;

    @FindBy(xpath = "/descendant::button[normalize-space(.)='CANCEL']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id='item_modal']//div[@class='modal-header']/button")
    public WebElement closeItemWindow;

    @FindBy(xpath = "//*[@id='category_modal']//div[@class='modal-header']/button")
    public WebElement closeCategoryWindow;

    @FindBy(xpath = "//table/tbody/tr[@class='ng-scope']/td[1]/span")
    public WebElement defaultData;

    @FindBy(xpath = "//*[@id='category_modal']//div[@class='category_image_upload_box']/span")
    public WebElement categoryUploadErrorMessage;

    @FindBy(xpath = "//*[@id='item_form']//div[@class='error_box']/span")
    public WebElement errorMessageInItem;

    @FindBy(xpath = "//*[@id='item_modal']//div[@class='image_upload_box']/span")
    public WebElement itemUploadErrorMessage;

    @FindBy(xpath = "//*[@id='database_button_text']/button[1]")
    public WebElement resetDatabase;

    @FindBy(xpath = "//*[@class='active']")
    public WebElement generalTab;

    @FindBy(xpath = "//*[@id='database_button_text']/button[2]")
    public WebElement cleanDatabase;

    @FindBy(xpath = "//*[@id='advertising_and_news_rasdio']//input[@name='advertisingEnabled']")
    public WebElement showRatio;

    @FindBy(xpath = "//*[@id='demo_bugs_checkbox']/div/p[2]/label/span")
    public WebElement locationBugText;

    @FindBy(xpath = "//*[@id='demo_bugs_checkbox']/div/p[1]/label/span")
    public WebElement quantityBugText;

    @FindBy(xpath = "//*[@id='doc2']/div[@class='industry_font']/p[1]/a")
    public WebElement demoAPPOpenAPI;

    @FindBy(xpath = "//*[@id='doc2']/div[@class='industry_font']/p[2]/a")
    public WebElement proxyOpenAPI;

    @FindBy(xpath = "//*[@id='return_to_home']/div[@class='common_text']/p/a")
    public WebElement homeLick;

    @FindBy(xpath = "//*[@id='database']//p/span")
    public WebElement database;

    @FindBy(xpath = "//*[@id='web_service']//p/span")
    public WebElement webServiceEndpoint;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_title']//p/span")
    public WebElement PARASOFTJDBCProxy;

    @FindBy(xpath = "//*[@id='demo_bugs']//p/span")
    public WebElement demoBugs;

    @FindBy(xpath = "//*[@id='design']//p/span")
    public WebElement industrySideDesign;

    @FindBy(xpath = "//*[@id='advertising_and_news_title']//p/span")
    public WebElement advertisingAndNews;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_radio']//input[@name='useParasoftJDBCProxy']")
    public WebElement enableRatio;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_radio']/div[2]/label")
    public WebElement JDBCProxyURLLabel;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_radio']/div[3]/label")
    public WebElement JDBCProxyPathLabel;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_radio']/div[4]/label")
    public WebElement JDBCProxyGroupIDLabel;

    @FindBy(xpath = "//*[@id='parasoft_virtualize_server_url']")
    public WebElement JDBCProxyURLInputFeild;

    @FindBy(xpath = "//*[@id='parasoft_virtualize_server_path']")
    public WebElement JDBCProxyPathInputFeild;

    @FindBy(xpath = "//*[@id='parasoft_virtualize_gourp_id']")
    public WebElement JDBCProxyGroupIDInputFeild;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_radio']/div[2]/button[1]")
    public WebElement JDBCProxyURLResetButtons;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_radio']/div[3]/button[1]")
    public WebElement JDBCProxyPathResetButtons;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_radio']/div[4]/button[1]")
    public WebElement JDBCProxyGroupIDResetButtons;

    @FindBy(xpath = "//*[@id='parasoft_jdbc_proxy_radio']/div[2]/button[2]")
    public WebElement JDBCProxyTestConnectButtons;

    @FindBy(xpath = "//*[@id=\"parasoft_jdbc_proxy_radio\"]/div[2]/div/span[1]")
    public WebElement invalidURLMessage;

    @FindBy(xpath = "//*[@id=\"parasoft_jdbc_proxy_radio\"]/div[2]/div/span[3]")
    public WebElement connectFail;

    @FindBy(xpath = "//*[@id=\"parasoft_jdbc_proxy_radio\"]/div[3]/div/span[1]")
    public WebElement invalidPathMessage;

    @FindBy(xpath = "//*[@id=\"parasoft_jdbc_proxy_radio\"]/div[4]/div/span[1]")
    public WebElement invalidGroupIDMessage;

    @FindBy(xpath = "//*[@id='toast-container']//div[@class='toast-message']")
    public WebElement saveSuccessfully;

    private WebDriver driver;

    private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

    public DemoAdminPage(WebDriver driver)  {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(driver, this);
    }

    public void clickSaveChangesButton() throws InterruptedException {
        ElementUtils.waitUntilClickable(driver, saveChangesButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        ElementUtils.waitUntilVisible(driver,saveSuccessfully,Properties.WAIT_FOR_ELEMENT_TIMEOUT);
    }

    // Change to aerospace
    public void switchToAerospace() throws InterruptedException {
        ElementUtils.waitUntilClickable(driver, aerospaceRatio, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        clickSaveChangesButton();
    }

    // Change to defense
    public void switchToDefense() throws InterruptedException {
        ElementUtils.waitUntilClickable(driver, defenseRatio, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        clickSaveChangesButton();
    }

    public void enableOrDisableBugs() throws InterruptedException {
        ElementUtils.waitUntilClickable(driver, locationBugSelector, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        ElementUtils.waitUntilClickable(driver, quantityBugSelector, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        clickSaveChangesButton();
    }

    public void switchToItemsTab() {
        ElementUtils.waitUntilClickable(driver, itemsTab, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        ElementUtils.waitUntilVisible(driver,addNewButton,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
    }

    public void setNameField(String text) {
        ElementUtils.waitUntilClickable(driver, nameField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        nameField.sendKeys(text);
    }

    public void setQuantityField(String text) {
        ElementUtils.waitUntilClickable(driver, quantityField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        quantityField.sendKeys(text);
    }

    public void selectRegionDropdown(String text) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(webdriver -> new Select(regionDropdown).getFirstSelectedOption().getText().trim().length() > 0);
        Select dropdown = new Select(regionDropdown);
        dropdown.selectByVisibleText(text);
    }

    public void selectCategoryDropdown(String text) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(webdriver -> new Select(categoryDropdown).getFirstSelectedOption().getText().trim().length() > 0);
        Select dropdown = new Select(categoryDropdown);
        dropdown.selectByVisibleText(text);
    }

    public void setDescriptionField(String text) {
        ElementUtils.waitUntilClickable(driver, descriptionField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        descriptionField.sendKeys(text);
    }

    public void removeImage() {
        ElementUtils.waitUntilClickable(driver, removeImage, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void switchToCategoryTab() {
        ElementUtils.waitUntilClickable(driver, categoryTab, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        ElementUtils.waitUntilVisible(driver,addNewButton,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
    }

    public void clickAddNewButton() {
        ElementUtils.waitUntilClickable(driver, addNewButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickModalSaveButton() {
        ElementUtils.waitUntilClickable(driver, modalSaveButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void ClickModalConfirmButton() {
        ElementUtils.waitUntilClickable(driver, modalConfirmButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void chooseImage() {
        ElementUtils.waitUntilClickable(driver, imageField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickConfirmButton() throws InterruptedException, AWTException {
        ElementUtils.waitUntilClickable(driver, confirmButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        GlobalUtils.waiting();
    }

    public void clickCorrespondingEditIcon(String name) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement correspondingEditIcon = driver.findElement
                (By.xpath("//td[@title='"+ name + "']/ancestor ::tr/td[last()]/img[@class='edit_icon']"));
        ElementUtils.waitUntilClickable(driver, correspondingEditIcon, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        correspondingEditIcon.click();
    }

    public void clickCorrespondingDeleteIcon(String name) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement correspondingDeleteIcon = driver.findElement
                (By.xpath("//td[@title='"+ name + "']/ancestor ::tr/td[last()]/img[@class='delete_icon']"));
        ElementUtils.waitUntilClickable(driver, correspondingDeleteIcon, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        correspondingDeleteIcon.click();
    }

    public void clickCancelButton() {
        ElementUtils.waitUntilClickable(driver, cancelButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickCloseItemWindowButton() {
        ElementUtils.waitUntilClickable(driver, closeItemWindow, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void clickCloseCategoryWindowButton() {
        ElementUtils.waitUntilClickable(driver, closeCategoryWindow, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void addNewOrder() throws Throwable {
        // Add items to cart
        boolean result = GlobalUtils.addItemIntoCart(driver, 1, 1);
        assertTrue(result,"Failed to add item to cart.");
        // Add new order
        String receiverId = "1029";
        String eventId = "102901";
        String eventNumber = "102902";
        if(Properties.currentIndustry.equals(IndustryType.DEFENSE)){
            String region= "UNITED_STATES";
            String location = LocationConstants.UNITED_STATES_INFO;
            boolean result1 = GlobalUtils.addNewOrder(driver, region, location, receiverId, eventId, eventNumber);
            assertTrue(result1,"Fail to add orders.");
        }else if (Properties.currentIndustry.equals(IndustryType.AEROSPACE)){
            String region= "EARTH";
            String location = LocationConstants.EARTH_INFO;
            boolean result1 = GlobalUtils.addNewOrder(driver, region, location, receiverId, eventId, eventNumber);
            assertTrue(result1,"Fail to add orders.");
        }
    }

    public void cleanDatabase() {
        ElementUtils.waitUntilClickable(driver, cleanDatabase, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void resetDatabase() {
        ElementUtils.waitUntilClickable(driver, resetDatabase, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
    }

    public void showOrHideAdvertisement() throws InterruptedException {
        ElementUtils.waitUntilClickable(driver, showRatio, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).click();
        clickSaveChangesButton();
    }

    public void backToHomePage() { ElementUtils.clickElementUseJs(driver,homeLick); }

    public String returnEndpointFailMessage(String labelName) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement correspondingMessageLocation = driver.findElement
                (By.xpath("//*[@id='rest_endpoint_set']//label//span[text()='"+labelName+"']/../../div/span"));
        ElementUtils.waitUntilClickable(driver, correspondingMessageLocation, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        return correspondingMessageLocation.getText();
    }

    public void clickJDBCProxyTestConnectButton() throws InterruptedException {
        ElementUtils.clickElementUseJs(driver,JDBCProxyTestConnectButtons);
    }

    public void clickJDBCProxyURLResetButton() throws InterruptedException {
        ElementUtils.clickElementUseJs(driver,JDBCProxyURLResetButtons);
    }

    public void clickJDBCProxyPathResetButton() throws InterruptedException {
        ElementUtils.clickElementUseJs(driver,JDBCProxyPathResetButtons);
    }

    public void clickJDBCProxyGroupIDResetButton() throws InterruptedException {
        ElementUtils.clickElementUseJs(driver,JDBCProxyGroupIDResetButtons);
    }

    public void resetEndpoint(String labelName) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement correspondingResetButton = driver.findElement
                (By.xpath("//*[@id='rest_endpoint_set']//label/span[text()='"+ labelName +"']/../../button"));
        ElementUtils.waitUntilClickable(driver, correspondingResetButton, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        correspondingResetButton.click();
    }

    public boolean returnEndpointResetButtonStatus(String labelName) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement correspondingResetButton = driver.findElement
                (By.xpath("//*[@id='rest_endpoint_set']//label/span[text()='"+ labelName +"']/../../button"));
        return correspondingResetButton.isEnabled();
    }

    public String returnResetButtonText(String labelName) throws InterruptedException, AWTException {
        GlobalUtils.waiting();
        WebElement correspondingResetButton = driver.findElement
                (By.xpath("//*[@id='rest_endpoint_set']//label/span[text()='"+ labelName +"']/../../button"));
        return correspondingResetButton.getText();
    }

    public String returnEndPointFieldValue(String labelName)  {
        WebElement correspondingInputField = driver.findElement
                (By.xpath("//*[@id='rest_endpoint_set']//label/span[text()='"+ labelName +"']/../../input"));
        return correspondingInputField.getAttribute("value");
    }

    public String returnEndPointLabelText(String labelName)  {
        WebElement correspondingInputField = driver.findElement
                (By.xpath("//*[@id='rest_endpoint_set']//label/span[text()='"+ labelName +"']"));
        return correspondingInputField.getText();
    }

    public void setEndPointField(String labelName,String endpointURL)  {
        WebElement correspondingInputField = driver.findElement
                (By.xpath("//*[@id='"+ labelName +"_rest_endpoint']"));
        ElementUtils.waitUntilClickable(driver, correspondingInputField, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        correspondingInputField.sendKeys(endpointURL);
    }

    public void setJDBCURLProxy(String URL) {
        ElementUtils.waitUntilClickable(driver, JDBCProxyURLInputFeild, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        JDBCProxyURLInputFeild.sendKeys(URL);
    }

    public void setJDBCPathProxy(String path) {
        ElementUtils.waitUntilClickable(driver, JDBCProxyPathInputFeild, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        JDBCProxyPathInputFeild.sendKeys(path);
    }

    public void setJDBCGroupIDProxy(String id) {
        ElementUtils.waitUntilClickable(driver, JDBCProxyGroupIDInputFeild, Properties.WAIT_FOR_ELEMENT_TIMEOUT_15).clear();
        JDBCProxyGroupIDInputFeild.sendKeys(id);
    }


    public void enableJDBC() throws InterruptedException {
        ElementUtils.clickElementUseJs(driver,enableRatio);
    }

    public void setDefaultInfo()throws Throwable{
        String industryType = Properties.currentIndustry.toString();
        String advertisingEnabled = "true";
        Set<String> demoBugs = new HashSet<>();
        demoBugs.add(WebUIConstants.LOCATION_BUG);
        demoBugs.add(WebUIConstants.QUANTITY_BUG);
        String categoriesRestEndpoint = "http://localhost:8080/v1/assets/categories";
        String itemsRestEndpoint = "http://localhost:8080/v1/assets/items";
        String cartItemsRestEndpoint = "http://localhost:8080/v1/cartItems";
        String ordersRestEndpoint = "http://localhost:8080/v1/orders";
        String locationsRestEndpoint = "http://localhost:8080/v1/locations";
        String useParasoftJDBCProxy = "false";
        String parasoftVirtualizeServerPath = "/virtualDb";
        String parasoftVirtualizeGroupId = "pda";
        String parasoftVirtualizeServerUrl = "http://localhost:9080";
        boolean result1 =GlobalUtils.setPreferences_enableBugs(driver,industryType,advertisingEnabled,demoBugs,
                categoriesRestEndpoint, itemsRestEndpoint,cartItemsRestEndpoint,ordersRestEndpoint,locationsRestEndpoint,
                useParasoftJDBCProxy,parasoftVirtualizeServerPath,parasoftVirtualizeGroupId,parasoftVirtualizeServerUrl);
        assertTrue(result1,"Fail to set reference.");
    }
}
