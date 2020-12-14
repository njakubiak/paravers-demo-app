package com.parasoft.demoapp.common;

import com.parasoft.demoapp.pages.CategoryPage;
import com.parasoft.demoapp.pages.ItemDetailPage;
import com.parasoft.demoapp.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Set;

public class GlobalUtils {

    public static final String BASE_URL = Properties.BASE_URL;

    public static Logger log = Logger.getLogger(GlobalUtils.class);

    /**
     * Login. <br/>
     * @param driver WebDriver
     * @param username account name
     * @param password account password
     */
    public static boolean login(WebDriver driver, String username, String password) throws AWTException, InterruptedException {
        driver.get(Properties.LOGIN_PAGE_URL);
        LoginPage loginPage = new LoginPage(driver);

        if(Properties.AEROSPACE_PRODUCT_NAME.equals(loginPage.productName.getText())){
            Properties.currentIndustry = IndustryType.AEROSPACE;
        }else if(Properties.DEFENSE_PRODUCT_NAME.equals(loginPage.productName.getText())){
            Properties.currentIndustry = IndustryType.DEFENSE;
        }

        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        log.info(MessageFormat.format("User [{0}] is trying to login, the password is [{1}]", username, password));
        loginPage.clickSignInButton();
        waiting();
        String url = driver.getCurrentUrl();
        if(url.equals(Properties.HOME_PAGE_URL)){
            return true;
        }
        log.error("Incorrect username or password." );
        return false;
    }

    /**
     * Log out <br/>
     * This way does not use UI but URL, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @return true if adding the item into cart successfully, false if not.
     */
    public static boolean switchToLogout(WebDriver driver){
        driver.get(Properties.LOGOUT_URL);
        String url = driver.getCurrentUrl();
        if (url.equals(Properties.LOGIN_PAGE_URL)){
            return true;
        }
        log.error("Fail to switch to log out." );
        return false;
    }

    /**
     * Switch to home page, user needs to login first. <br/>
     * This way does not use UI but URL, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @return true if adding the item into cart successfully, false if not.
     */
    public static boolean  switchToHomepage(WebDriver driver){
        driver.get(Properties.HOME_PAGE_URL);
        String url = driver.getCurrentUrl();
        if (url.equals(Properties.HOME_PAGE_URL)){
            return true;
        }
        log.error("Fail to switch to home page." );
        return false;
    }

    /**
     * Switch to item page. <br/>
     * This way does not use UI but, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @param categoryName category of item
     * @param itemName item name
     * @return true if adding the item into cart successfully, false if not.
     */
    public static boolean switchToItemPage(WebDriver driver, String categoryName, String itemName) throws InterruptedException, AWTException {
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        driver.get(BASE_URL);
        waiting();
        WebElement categoryLink = driver.findElement(By.xpath("//span[text()='"+categoryName+"']"));
        ElementUtils.waitUntilClickable(driver,categoryLink,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        ElementUtils.clickElementUseJs(driver,categoryLink);
        waiting();
        WebElement itemLink = driver.findElement(By.xpath("//span[text()='"+itemName+"']/.."));
        ElementUtils.waitUntilClickable(driver,itemLink,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        ElementUtils.clickElementUseJs(driver,itemLink);
        ElementUtils.waitUntilVisible(driver,itemDetailPage.itemName,Properties.WAIT_FOR_ELEMENT_TIMEOUT_15);
        String url = driver.getCurrentUrl();
        String currentItemName = itemDetailPage.itemInNavigateBar.getText() ;
        if(url.contains("/items/") && itemName.equals(currentItemName)){
            return true;
        }
        log.error("Fail to switch to item page." );
        return false;

    }

    /**
     * Add an item into cart, user needs to login first. <br/>
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @param itemId item id
     * @param itemQty quantity of the item
     * @return true if adding the item into cart successfully, false if not.
     */
    public static boolean addItemIntoCart(WebDriver driver, long itemId, int itemQty){

        String method = Properties.HTTP_REQUEST_POST_METHOD;
        String url = Properties.ADD_ITEM_INTO_CART_REST_API_URL +  "?itemId="+ itemId +"&itemQty=" + itemQty;
        String jsonPayLoad = "";

        String response = sendRequestUsingAjax(driver, method, url, null, jsonPayLoad);

        if(response != null && response.contains("\"status\":1")){
            return true;
        }

        log.error("Error message of adding item into cart: " + response);
        return false;
    }

    /**
     * Add an new order, user needs to login first and there is one item in cart at least. <br/>
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @param region region
     * @param location location
     * @param receiverId receiverId
     * @param eventId eventId
     * @param eventNumber eventNumber
     * @return true if adding the order successfully, false if not.
     */
    public static boolean addNewOrder(WebDriver driver, String region, String location, String receiverId,
                                      String eventId, String eventNumber){

        String jsonPayLoad =
                "{" +
                    "\"region\":\"" + region + "\"," +
                    "\"location\":\""+ location + "\"," +
                    "\"receiverId\":\"" + receiverId + "\"," +
                    "\"eventId\":\"" + eventId + "\"," +
                    "\"eventNumber\":\"" + eventNumber + "\"" +
                "}";
        /* the format is like:
            {
                "region": "UNITED_STATES",
                "location": "string",
                "receiverId": "string",
                "eventId": "string",
                "eventNumber": "string"
            }
         */

        String method = Properties.HTTP_REQUEST_POST_METHOD;
        String url = Properties.ADD_NEW_ORDER_REST_API_URL;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;

        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);

        if(response != null && response.contains("\"status\":1")){
            return true;
        }

        log.error("Error message of adding an new order: " + response);
        return false;

    }

    /**
     * Add a category, user needs to login first. <br/>
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @param categoryName category name
     * @param description description
     * @param imagePath image path, image path can be any string for test.
     * @return true if creating the category successfully, false if not. Category may create failed if category name already exists.
     */
    public static boolean addCategory(WebDriver driver, String categoryName, String description, String imagePath){

        String jsonPayLoad =
                "{" +
                    "\"name\":\"" + categoryName + "\"," +
                    "\"description\":\""+ description + "\"," +
                    "\"imagePath\":\"" + imagePath + "\"" +
                "}";
        /* the format is like:
            {
                "name":"categoryName",
                "description":"description",
                "imagePath":"imagePath"
            }
         */

        String method = Properties.HTTP_REQUEST_POST_METHOD;
        String url = Properties.ADD_CATEGORY_REST_API_URL;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;

        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);

        if(response.contains("\"status\":1")){
            return true;
        }

        log.error("Error message of creating new category: " + response);
        return false;
    }

    /**
     * Send request using Ajax directly.
     * @param driver WebDriver
     * @param method http method
     * @param url http url
     * @param contentType This parameter can be null.
     * @param jsonPayLoad Can't be null if no payload, it should be an empty string.
     * @return
     */
    public static String sendRequestUsingAjax(WebDriver driver, String method, String url,
                                              String contentType, String jsonPayLoad){

        JavascriptExecutor jse = (JavascriptExecutor) driver ;

        String ajaxRequestScript =
                "var xmlhttp=new XMLHttpRequest();\n" +
                "xmlhttp.open('"+ method + "','" + url + "',false);\n";

        if(contentType != null){
            ajaxRequestScript = ajaxRequestScript + "xmlhttp.setRequestHeader('" + contentType + "');\n";
        }
        ajaxRequestScript = ajaxRequestScript + "xmlhttp.send('"+ jsonPayLoad + "');\n";
        ajaxRequestScript = ajaxRequestScript + "return xmlhttp.responseText;\n";

        log.info("Javascript executor executes script: \n{" + ajaxRequestScript + "}");

        return (String) jse.executeScript(ajaxRequestScript);
    }

    /**
     * Add a item, user needs to login first. <br/>
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @param itemName item name
     * @param description description
     * @param imagePath image path, image path can be any string for test.
     * @param categoryId item name
     * @param inStock description
     * @param region image path, image path can be any string for test.
     * @return true if creating the item successfully, false if not. Item may create failed if item name already exists.
     */
    public static boolean addItem(WebDriver driver, String itemName, String description, int categoryId,
                                  int inStock, String imagePath, String region){

        String jsonPayLoad =
                "{" +
                        "\"name\":\"" + itemName + "\"," +
                        "\"description\":\""+ description + "\"," +
                        "\"categoryId\":\"" + categoryId + "\"," +
                        "\"inStock\":\"" + inStock + "\"," +
                        "\"imagePath\":\"" + imagePath + "\"," +
                        "\"region\":\"" + region + "\"" +
                        "}";
        /* the format is like:
            {
                "name":"itemName",
                "description":"description",
                "categoryId":"1",
                "inStock":"1",
                "imagePath":"imagePath"
                "region":"UNITED_STATES",
            }
         */

        String method = Properties.HTTP_REQUEST_POST_METHOD;
        String url = Properties.ADD_ITEM_REST_API_URL;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;

        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);

        if(response.contains("\"status\":1")){
            return true;
        }

        log.error("Error message of creating new item: " + response);
        return false;
    }

    /**
     * Switch to category page. <br/>
     * This way does not use UI, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @param categoryName category name
     * @return true if adding the item into cart successfully, false if not.
     */
    public static boolean switchToCategoryPage(WebDriver driver, String categoryName) throws InterruptedException, AWTException {
        driver.get(BASE_URL);
        waiting();
        WebElement categoryLink = driver.findElement(By.xpath("//a/span[text()='"+categoryName+"']"));
        ElementUtils.waitUntilClickable(driver,categoryLink,Properties.DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
        categoryLink.click();
        String url = driver.getCurrentUrl();
        CategoryPage categoryPage = new CategoryPage(driver);
        String currentCategoryName = categoryPage.navigationBarSecond.getText();
        if(url.contains("/categories/") && categoryName.equals(currentCategoryName)){
            return true;
        }
        log.error("Fail to switch to category page." );
        return false;
    }

    /**
     * Switch to orders page. <br/>
     * This way does not use UI but URL, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @return true if adding the item into cart successfully, false if not.
     */
    public static boolean switchToOrdersPage(WebDriver driver) {
        driver.get(Properties.ORDERS_PAGE_URL);
        if (driver.getCurrentUrl().contains("/orders")) {
            return true;
        }
        return false;
    }

    /**
     * Switch to demo admin page. <br/>
     * This way does not use UI but URL, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @return true if adding the item into cart successfully, false if not.
     */
    public static boolean switchToDemoAdminPage(WebDriver driver) {
        driver.get(Properties.DEMO_ADMIN_PAGE_URL);
        if (driver.getCurrentUrl().contains("/demoAdmin")) {
            return true;
        }
        return false;
    }

    /**
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver
     * @return
     */
    public static boolean resetDatabase(WebDriver driver) {

        String jsonPayLoad = "";

        String method = Properties.HTTP_REQUEST_PUT_METHOD;
        String url = Properties.REST_DATABASE_API_URL;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;

        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);

        if (response.contains("\"status\":1")) {
            return true;
        }

        log.error("Error message of reset database: " + response);
        return false;
    }

    public static void waiting() throws InterruptedException, AWTException {
        Thread.sleep(1000);
    }

    /**
     * This is a upload image method.
     * @param imagePath like: "/src/test/resources/rabbit.gif"
     */
    public static void uploadImage(String imagePath) throws InterruptedException, AWTException {
        Path image = Paths.get(System.getProperty("user.dir") + imagePath);
        StringSelection selection = new StringSelection(image.toString());
        waiting();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
        System.out.println("selection"+selection);
        waiting();
        // Create a Reboot class
        Robot robot=new Robot();
        Toolkit.getDefaultToolkit().getScreenSize();
        waiting();
        // Press Ctrl+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        waiting();
        // Release Ctrl+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        waiting();
        // Click enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        waiting();
    }

    /**
     * Enable bugs <br/>
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @param industryType industry
     * @param advertisingEnabled show/hide advertising.
     * @param demoBugs enable/disable bugs.
     * @param categoriesRestEndpoint categories API url
     * @param itemsRestEndpoint items API url
     * @param cartItemsRestEndpoint cart  API url
     * @param ordersRestEndpoint orders API url
     * @param locationsRestEndpoint location API url
     * @return true if creating the item successfully, false if not. Item may create failed if item name already exists.
     */
    public static boolean setPreferences_enableBugs(WebDriver driver, String industryType, String advertisingEnabled,
                                                    Set<String> demoBugs, String categoriesRestEndpoint,
                                                    String itemsRestEndpoint, String cartItemsRestEndpoint,
                                                    String ordersRestEndpoint, String locationsRestEndpoint,
                                                    String useParasoftJDBCProxy,String parasoftVirtualizeServerPath,
                                                    String parasoftVirtualizeGroupId, String parasoftVirtualizeServerUrl
                                                    ){

        String demoBugsString = "[";
        for(String bug : demoBugs){
            demoBugsString = demoBugsString + "\"" + bug + "\"" + ",";
        }
        demoBugsString = demoBugsString.substring(0, demoBugsString.length() - 1);
        demoBugsString = demoBugsString +"]";
        String jsonPayLoad =
                "{" +
                        "\"industryType\":\"" + industryType + "\"," +
                        "\"advertisingEnabled\":\""+ advertisingEnabled + "\"," +
                        "\"demoBugs\":" + demoBugsString + "," +
                        "\"categoriesRestEndpoint\":\"" + categoriesRestEndpoint + "\"," +
                        "\"itemsRestEndpoint\":\"" + itemsRestEndpoint + "\"," +
                        "\"cartItemsRestEndpoint\":\"" + cartItemsRestEndpoint + "\"," +
                        "\"ordersRestEndpoint\":\"" + ordersRestEndpoint + "\"," +
                        "\"locationsRestEndpoint\":\"" + locationsRestEndpoint + "\"," +
                        "\"useParasoftJDBCProxy\":\"" + useParasoftJDBCProxy + "\"," +
                        "\"parasoftVirtualizeServerPath\":\"" + parasoftVirtualizeServerPath + "\"," +
                        "\"parasoftVirtualizeGroupId\":\"" + parasoftVirtualizeGroupId + "\"," +
                        "\"parasoftVirtualizeServerUrl\":\"" + parasoftVirtualizeServerUrl + "\"" +
                        "}";
        /* the format is like:
            {
                "industryType": "DEFENSE",
                "advertisingEnabled": true,
                "demoBugs": [
                         "INCORRECT_LOCATION_FOR_APPROVED_ORDERS"
                 ],
                "categoriesRestEndpoint": "string",
                "itemsRestEndpoint": "string",
                "cartItemsRestEndpoint": "string",
                "ordersRestEndpoint": "string",
                "locationsRestEndpoint": "string",
                "useParasoftJDBCProxy": true,
                "parasoftVirtualizeServerPath": "string",
                "parasoftVirtualizeGroupId": "string",
                "parasoftVirtualizeServerUrl": "string"
            }
         */
        String method = Properties.HTTP_REQUEST_PUT_METHOD;
        String url = Properties.PREFERENCES_API_URL;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;

        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);
        log.info(response);

        if(response.contains("\"status\":1")){
            return true;
        }

        log.error("Error message of set preference: " + response);
        return false;
    }

    /**
     * disable bugs <br/>
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @param industryType industry
     * @param advertisingEnabled show/hide advertising.
     * @param demoBugs enable/disable bugs.
     * @param categoriesRestEndpoint categories API url
     * @param itemsRestEndpoint items API url
     * @param cartItemsRestEndpoint cart  API url
     * @param ordersRestEndpoint orders API url
     * @param locationsRestEndpoint location API url
     * @return true if creating the item successfully, false if not. Item may create failed if item name already exists.
     */
    public static boolean setPreferences_disableBugs(WebDriver driver, String industryType, String advertisingEnabled,
                                                     Set<String> demoBugs, String categoriesRestEndpoint,
                                                     String itemsRestEndpoint, String cartItemsRestEndpoint,
                                                     String ordersRestEndpoint, String locationsRestEndpoint,
                                                     String useParasoftJDBCProxy,String parasoftVirtualizeServerUrl){

        String demoBugsString = "[";
        demoBugsString = demoBugsString +"]";
        String jsonPayLoad =
                "{" +
                        "\"industryType\":\"" + industryType + "\"," +
                        "\"advertisingEnabled\":\""+ advertisingEnabled + "\"," +
                        "\"demoBugs\":" + demoBugsString + "," +
                        "\"categoriesRestEndpoint\":\"" + categoriesRestEndpoint + "\"," +
                        "\"itemsRestEndpoint\":\"" + itemsRestEndpoint + "\"," +
                        "\"cartItemsRestEndpoint\":\"" + cartItemsRestEndpoint + "\"," +
                        "\"ordersRestEndpoint\":\"" + ordersRestEndpoint + "\"," +
                        "\"locationsRestEndpoint\":\"" + locationsRestEndpoint + "\"," +
                        "\"useParasoftJDBCProxy\":\"" + useParasoftJDBCProxy + "\"," +
                        "\"parasoftVirtualizeServerUrl\":\"" + parasoftVirtualizeServerUrl + "\"" +
                        "}";
        /* the format is like:
            {
                "industryType": "DEFENSE",
                "advertisingEnabled": true,
                "demoBugs": [
                         "INCORRECT_LOCATION_FOR_APPROVED_ORDERS"
                 ],
                "categoriesRestEndpoint": "string",
                "itemsRestEndpoint": "string",
                "cartItemsRestEndpoint": "string",
                "ordersRestEndpoint": "string",
                "locationsRestEndpoint": "string",
                 "useParasoftJDBCProxy": true,
                 "parasoftVirtualizeServerUrl": "string"

            }
         */
        String method = Properties.HTTP_REQUEST_PUT_METHOD;
        String url = Properties.PREFERENCES_API_URL;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;

        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);
        log.info(response);

        if(response.contains("\"status\":1")){
            return true;
        }

        log.error("Error message of set preference: " + response);
        return false;
    }

    /**
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver
     * @return
     */
    public static boolean cleanDatabase(WebDriver driver) {

        String jsonPayLoad = "";

        String method = Properties.HTTP_REQUEST_PUT_METHOD;
        String url = Properties.CLEAN_DATABASE_API_URL;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;

        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);

        if (response.contains("\"status\":1")) {
            return true;
        }

        log.error("Error message of clean database: " + response);
        return false;
    }

    /**
     * This method is visit target url directly.
     * @param driver
     * @param url target path
     * @return
     */
    public static boolean switchToDifferentURL(WebDriver driver,String url){
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(url)){
            return true;
        }
        log.error("Page jump failed" );
        return false;
    }

    /**
     * Read a category, user needs to login first. <br/>
     * This way does not use UI but REST api with AJAX directly, so if you want to test UI or functionality, please do not use this way.
     * @param driver WebDriver
     * @return
     */
    public static int getCategoryID(WebDriver driver , String categoryName) {

        String jsonPayLoad ="";
        String method = Properties.HTTP_REQUEST_GET_METHOD;
        String url = Properties.GET_CATEGORY_API_URL + categoryName;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;
        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);
        int categoryID = Integer.valueOf(response.substring(45,46));
        if(response.contains("\"status\":1")){
            return categoryID;
        }
        return categoryID;
    }

    public static int getItemID(WebDriver driver , String itemName) {

        String jsonPayLoad ="";
        String method = Properties.HTTP_REQUEST_GET_METHOD;
        String url = Properties.GET_ITEM_API_URL + itemName;
        String contentType = Properties.HEADER_JSON_CONTENT_TYPE;
        String response = sendRequestUsingAjax(driver, method, url, contentType, jsonPayLoad);
        int categoryID = Integer.valueOf(response.substring(45,47));
        if(response.contains("\"status\":1")){
            return categoryID;
        }
        return categoryID;
    }
}
