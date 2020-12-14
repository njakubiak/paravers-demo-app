package com.parasoft.demoapp.service;

import static com.parasoft.demoapp.config.ParasoftJDBCProxyConfig.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parasoft.demoapp.config.WebConfig;
import com.parasoft.demoapp.config.datasource.IndustryRoutingDataSource;
import com.parasoft.demoapp.model.global.preferences.DataAccessMode;
import com.parasoft.demoapp.model.global.preferences.DemoBugEntity;
import com.parasoft.demoapp.model.global.preferences.DemoBugsType;
import com.parasoft.demoapp.model.global.preferences.GlobalPreferencesEntity;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import com.parasoft.demoapp.model.global.preferences.RestEndpointEntity;
import com.parasoft.demoapp.util.BugsTypeSortOfDemoBugs;
import com.parasoft.demoapp.util.RouteIdSortOfRestEndpoint;

@Service
public class GlobalPreferencesDefaultSettingsService {

    public static final String HOST_WITHOUT_PORT = "http://localhost:";

    public static final String CATEGORIES_ENDPOINT_ID = "categories";
    public static final String CATEGORIES_ENDPOINT_PATH = "/proxy/v1/assets/categories/**";
    public static final String CATEGORIES_ENDPOINT_REAL_PATH = "/v1/assets/categories";

    public static final String ITEMS_ENDPOINT_ID = "items";
    public static final String ITEMS_ENDPOINT_PATH = "/proxy/v1/assets/items/**";
    public static final String ITEMS_ENDPOINT_REAL_PATH = "/v1/assets/items";

    public static final String CART_ENDPOINT_ID = "cart";
    public static final String CART_ENDPOINT_PATH = "/proxy/v1/cartItems/**";
    public static final String CART_ENDPOINT_REAL_PATH = "/v1/cartItems";

    public static final String ORDERS_ENDPOINT_ID = "orders";
    public static final String ORDERS_ENDPOINT_PATH = "/proxy/v1/orders/**";
    public static final String ORDERS_ENDPOINT_REAL_PATH = "/v1/orders";

    public static final String LOCATIONS_ENDPOINT_ID = "locations";
    public static final String LOCATIONS_ENDPOINT_PATH = "/proxy/v1/locations/**";
    public static final String LOCATIONS_ENDPOINT_REAL_PATH = "/v1/locations";

    @Autowired
    private WebConfig webConfig;

    public GlobalPreferencesEntity defaultPreferences(){

        GlobalPreferencesEntity defaultPreferences = new GlobalPreferencesEntity();

        DataAccessMode dataAccessMode = defaultDataAccessMode();
        String soapEndPoint = defaultSoapEndPoint();
        Set<RestEndpointEntity> restEndpoints = defaultEndpoints();
        IndustryType industryType = defaultIndustry();
        Set<DemoBugEntity> demoBugs = defaultDemoBugs();
        Boolean advertisingEnabled = defaultAdvertisingEnabled();
        boolean useParasoftJDBCProxy = defaultUseParasoftJDBCProxy();
        String parasoftVirtualizeServerUrl = defaultParasoftVirtualizeServerUrl();
        String parasoftVirtualizeServerPath = defaultParasoftVirtualizeServerPath();
        String parasoftVirtualizeGroupId = defaultParasoftVirtualizeGroupId();

        defaultPreferences.setDataAccessMode(dataAccessMode);
        defaultPreferences.setSoapEndPoint(soapEndPoint);
        defaultPreferences.setRestEndPoints(restEndpoints);
        defaultPreferences.setIndustryType(industryType);
        defaultPreferences.setDemoBugs(demoBugs);
        defaultPreferences.setAdvertisingEnabled(advertisingEnabled);
        defaultPreferences.setUseParasoftJDBCProxy(useParasoftJDBCProxy);
        defaultPreferences.setParasoftVirtualizeServerUrl(parasoftVirtualizeServerUrl);
        defaultPreferences.setParasoftVirtualizeServerPath(parasoftVirtualizeServerPath);
        defaultPreferences.setParasoftVirtualizeGroupId(parasoftVirtualizeGroupId);

        return defaultPreferences;
    }

    public DemoBugEntity defaultIncorrectNumberDemoBugs() {

    	return new DemoBugEntity(DemoBugsType.INCORRECT_LOCATION_FOR_APPROVED_ORDERS);
    }

    public DemoBugEntity defaultIncorrectLocationDemoBugs() {

    	return new DemoBugEntity(DemoBugsType.INCORRECT_NUMBER_OF_ITEMS_IN_SUMMARY_OF_PENDING_ORDER);
    }

    public Set<DemoBugEntity> defaultDemoBugs(){
        Set<DemoBugEntity> defaultDemoBugs = new TreeSet<>(new BugsTypeSortOfDemoBugs());

        defaultDemoBugs.add(defaultIncorrectLocationDemoBugs());
        defaultDemoBugs.add(defaultIncorrectNumberDemoBugs());

        return defaultDemoBugs;
    }

    public RestEndpointEntity defaultCategoriesEndpoint(){
        return new RestEndpointEntity(CATEGORIES_ENDPOINT_ID, CATEGORIES_ENDPOINT_PATH,
                HOST_WITHOUT_PORT + webConfig.getServerPort() + CATEGORIES_ENDPOINT_REAL_PATH);
    }

    public RestEndpointEntity defaultItemsEndpoint(){
        return new RestEndpointEntity(ITEMS_ENDPOINT_ID, ITEMS_ENDPOINT_PATH,
                HOST_WITHOUT_PORT + webConfig.getServerPort() + ITEMS_ENDPOINT_REAL_PATH);
    }

    public RestEndpointEntity defaultCartItemsEndpoint(){
        return new RestEndpointEntity(CART_ENDPOINT_ID, CART_ENDPOINT_PATH,
                HOST_WITHOUT_PORT + webConfig.getServerPort() + CART_ENDPOINT_REAL_PATH);
    }

    public RestEndpointEntity defaultOrdersEndpoint(){
        return new RestEndpointEntity(ORDERS_ENDPOINT_ID, ORDERS_ENDPOINT_PATH,
                HOST_WITHOUT_PORT + webConfig.getServerPort() + ORDERS_ENDPOINT_REAL_PATH);
    }

    public RestEndpointEntity defaultLocationsEndpoint(){
        return new RestEndpointEntity(LOCATIONS_ENDPOINT_ID, LOCATIONS_ENDPOINT_PATH,
                HOST_WITHOUT_PORT + webConfig.getServerPort() + LOCATIONS_ENDPOINT_REAL_PATH);
    }

    public Set<RestEndpointEntity> defaultEndpoints(){
        Set<RestEndpointEntity> defaultEndpoints = new TreeSet<>(new RouteIdSortOfRestEndpoint());

        defaultEndpoints.add(defaultCategoriesEndpoint());
        defaultEndpoints.add(defaultItemsEndpoint());
        defaultEndpoints.add(defaultCartItemsEndpoint());
        defaultEndpoints.add(defaultOrdersEndpoint());
        defaultEndpoints.add(defaultLocationsEndpoint());

        return defaultEndpoints;
    }

    public IndustryType defaultIndustry(){
        return IndustryRoutingDataSource.DEFAULT_INDUSTRY;
    }

    public boolean defaultAdvertisingEnabled(){
        return true;
    }

    public DataAccessMode defaultDataAccessMode(){
        return null;
    }

    public String defaultSoapEndPoint(){
        return null;
    }

    public boolean defaultUseParasoftJDBCProxy(){
        return false;
    }

    public String defaultParasoftVirtualizeServerUrl(){
        return PARASOFT_JDBC_PROXY_VIRTUALIZE_SERVER_URL_DEFAULT_VALUE;
    }

    public String defaultParasoftVirtualizeServerPath(){
        return PARASOFT_JDBC_PROXY_VIRTUALIZE_SERVER_PATH_DEFAULT_VALUE;
    }

    public String defaultParasoftVirtualizeGroupId(){
        return PARASOFT_JDBC_PROXY_VIRTUALIZE_GROUP_ID_DEFAULT_VALUE;
    }

    public Map<String, String> defaultParasoftJdbcDriverArguments(){
        Map<String, String> arguments = new HashMap<>();

        arguments.put(PARASOFT_JDBC_PROXY_VIRTUALIZE_SERVER_URL_KEY, PARASOFT_JDBC_PROXY_VIRTUALIZE_SERVER_URL_DEFAULT_VALUE);
        arguments.put(PARASOFT_JDBC_PROXY_VIRTUALIZE_GROUP_ID_KEY, PARASOFT_JDBC_PROXY_VIRTUALIZE_GROUP_ID_DEFAULT_VALUE);
        arguments.put(PARASOFT_JDBC_PROXY_REGISTER_JDBCPROXYDRIVER_IN_DRIVERMANAGER_KEY, PARASOFT_JDBC_PROXY_REGISTER_JDBCPROXYDRIVER_IN_DRIVERMANAGER_DEFAULT_VALUE);
        arguments.put(PARASOFT_JDBC_PROXY_DIRECT_KEY, PARASOFT_JDBC_PROXY_DIRECT_DEFAULT_VALUE);
        arguments.put(PARASOFT_JDBC_PROXY_VIRTUALIZE_SERVER_PATH_KEY, PARASOFT_JDBC_PROXY_VIRTUALIZE_SERVER_PATH_DEFAULT_VALUE);

        return arguments;
    }
}
