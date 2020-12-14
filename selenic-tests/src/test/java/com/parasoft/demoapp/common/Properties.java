package com.parasoft.demoapp.common;

public class Properties {

    public static final String BASE_URL = System.getProperty("BASE_URL", "http://localhost:8080");
    public static final String ACTUAL_WEB_DRIVER = System.getProperty("WEB_DRIVER_USING", WebDriverDecider.CHROME_DRIVER);
    public static final String TARGET_INDUSTRY = System.getProperty("TARGET_INDUSTRY", IndustryType.DEFENSE.toString());

    public static final String LOGIN_PAGE_URL = BASE_URL + "/loginPage";
    public static final String LOGOUT_URL = BASE_URL + "/logout";
    public static final String HOME_PAGE_URL = BASE_URL + "/";
    public static final String DEMO_ADMIN_PAGE_URL = BASE_URL + "/demoAdmin";
    public static final String ORDERS_PAGE_URL = BASE_URL + "/orders";
    public static final String ORDERS_WIZARD_PAGE_URL = BASE_URL + "/orderWizard";
    public static final String ADD_CATEGORY_REST_API_URL = BASE_URL +  "/v1/assets/categories";
    public static final String ADD_ITEM_INTO_CART_REST_API_URL = BASE_URL +  "/v1/cartItems";
    public static final String ADD_NEW_ORDER_REST_API_URL = BASE_URL +  "/v1/orders";
    public static final String ADD_ITEM_REST_API_URL = BASE_URL +  "/v1/assets/items";
    public static final String REST_DATABASE_API_URL = BASE_URL +  "/v1/demoAdmin/databaseReset";
    public static final String PREFERENCES_API_URL = BASE_URL +  "/v1/demoAdmin/preferences";
    public static final String CLEAN_DATABASE_API_URL = BASE_URL +  "/v1/demoAdmin/databaseClear";
    public static final String GET_CATEGORY_API_URL = BASE_URL +  "/v1/assets/categories/name/";
    public static final String GET_ITEM_API_URL = BASE_URL +  "/v1/assets/items/name/";

    public static final String HEADER_JSON_CONTENT_TYPE = "Content-type','application/json";
    public static final String HTTP_REQUEST_POST_METHOD = "POST";
    public static final String HTTP_REQUEST_GET_METHOD = "GET";
    public static final String HTTP_REQUEST_PUT_METHOD = "PUT";

    public static final String PURCHASER_USERNAME = "purchaser";
    public static final String PURCHASER_PASSWORD = "password";
    public static final String APPROVER_USERNAME = "approver";
    public static final String APPROVER_PASSWORD = "password";

    public static final String ERROR_PURCHASER_USERNAME = "PURCHASER";
    public static final String ERROR_PURCHASER_PASSWORD = "PASSWORD";
    public static final String ERROR_APPROVER_USERNAME = "Approver";
    public static final String ERROR_APPROVER_PASSWORD = "Password";
    public static final String EMPTY_APPROVER_USERNAME = "";
    public static final String EMPTY_APPROVER_PASSWORD = "";

    public static final String AEROSPACE_PRODUCT_NAME = "PARA-VERS";
    public static final String DEFENSE_PRODUCT_NAME = "PARA TROOPERS";

    public static final String SORT_OPTION_DATA_ADDED = "Date added";
    public static final String SORT_OPTION_ALPHABETICAL = "Alphabetical";

    public static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 30;
    public static final int WAIT_FOR_ELEMENT_TIMEOUT = 100;
    public static final int WAIT_FOR_ELEMENT_TIMEOUT_15 = 15;

    public static final String WEB_REPLAY_URL = "https://alm.parasoft.com/expand-beyond-ui-with-ai-" +
            "powered-codeless-api-testing";
    public static final String ANALYST_REPORT_URL = "https://alm.parasoft.com/forrester-wave-continuous-" +
            "functional-test-automation";
    public static final String COMPANY_BLOG_URL = "";
    public static final String ADVERTISEMENT_URL = "https://alm.parasoft.com/automated-software-testing-quality-summit";
    public static final String DEFENSE_SEARCH_ICON_URL = BASE_URL + "/defense/images/search_button.svg";
    public static final String AEROSPACE_SEARCH_ICON_URL = BASE_URL + "/aerospace/images/search_button.svg";

    public static final String DEFAULT_CATEGORIES_ENDPOINT_URL = "http://localhost:8080/v1/assets/categories";
    public static final String DEFAULT_ITEMS_ENDPOINT_URL = "http://localhost:8080/v1/assets/items";
    public static final String DEFAULT_CART_ITEMS_ENDPOINT_URL = "http://localhost:8080/v1/cartItems";
    public static final String DEFAULT_ORDERS_ENDPOINT_URL = "http://localhost:8080/v1/orders";
    public static final String DEFAULT_LOCATIONS_ENDPOINT_URL = "http://localhost:8080/v1/locations";
    public static final String DEFAULT_PARASOFT_JDBC_PROXY_URL = "http://localhost:9080";
    public static final String DEFAULT_PARASOFT_JDBC_PROXY_PATH = "/virtualDb";
    public static final String DEFAULT_PARASOFT_JDBC_PROXY_GROUP_ID = "pda";

    public static IndustryType currentIndustry = IndustryType.DEFENSE;

}
