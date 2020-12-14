package com.parasoft.demoapp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverDecider {

    public static final String CHROME_DRIVER = "chrome";
    public static final String IE_DRIVER = "iexplore";
    public static final String FIREFOX_DRIVER = "firefox";
    public static final String MICROSOFT_EDGE = "edge";
    public static final String MICROSOFT_EDGE_LEGACY = "edge_Legacy";

    public static WebDriver decide(){

        if(Properties.ACTUAL_WEB_DRIVER.equals(CHROME_DRIVER)){
            ChromeOptions chromeOptions = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("intl.accept_languages", "en-US,en");
            chromeOptions.setExperimentalOption("prefs", prefs);
            return new ChromeDriver(chromeOptions);
        }

        if(Properties.ACTUAL_WEB_DRIVER.equals(IE_DRIVER)){

            InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
            internetExplorerOptions.ignoreZoomSettings();
            internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
            return new InternetExplorerDriver(internetExplorerOptions);
        }

        if(Properties.ACTUAL_WEB_DRIVER.equals(MICROSOFT_EDGE)){
            return new EdgeDriver();
        }

        if(Properties.ACTUAL_WEB_DRIVER.equals(FIREFOX_DRIVER)){
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("intl.accept_languages", "en-US,en");
            firefoxOptions.setProfile(firefoxProfile);
            return new FirefoxDriver(firefoxOptions);
        }

        throw new RuntimeException("No driver matched, please set System Environment property(WEB_DRIVER_USING) with value " +
                CHROME_DRIVER + ", " + IE_DRIVER  +", " + MICROSOFT_EDGE + "or " + FIREFOX_DRIVER);
    }

}
