package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.global.preferences.DataAccessMode;
import com.parasoft.demoapp.model.global.preferences.DemoBugEntity;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Parasoft Jtest UTA: Test class for GlobalPreferencesDefaultSettingsService
 *
 * @author jakubiak
 * @see GlobalPreferencesDefaultSettingsService
 */
public class GlobalPreferencesDefaultSettingsServiceTest {
    /**
     * Parasoft Jtest UTA: Test for defaultAdvertisingEnabled()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultAdvertisingEnabled()
     */
    @Test
    public void testDefaultAdvertisingEnabled() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        boolean result = underTest.defaultAdvertisingEnabled();

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultDataAccessMode()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultDataAccessMode()
     */
    @Test
    public void testDefaultDataAccessMode() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        DataAccessMode result = underTest.defaultDataAccessMode();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultDemoBugs()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultDemoBugs()
     */
    @Test
    public void testDefaultDemoBugs() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        Set<DemoBugEntity> result = underTest.defaultDemoBugs();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.contains(null));
    }

    /**
     * Parasoft Jtest UTA: Test for defaultIncorrectLocationDemoBugs()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultIncorrectLocationDemoBugs()
     */
    @Test
    public void testDefaultIncorrectLocationDemoBugs() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        DemoBugEntity result = underTest.defaultIncorrectLocationDemoBugs();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultIncorrectNumberDemoBugs()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultIncorrectNumberDemoBugs()
     */
    @Test
    public void testDefaultIncorrectNumberDemoBugs() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        DemoBugEntity result = underTest.defaultIncorrectNumberDemoBugs();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultIndustry()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultIndustry()
     */
    @Test
    public void testDefaultIndustry() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        IndustryType result = underTest.defaultIndustry();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultParasoftJdbcDriverArguments()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultParasoftJdbcDriverArguments()
     */
    @Test
    public void testDefaultParasoftJdbcDriverArguments() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        Map<String, String> result = underTest.defaultParasoftJdbcDriverArguments();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.containsKey(""));
        // assertTrue(result.containsValue(""));
    }

    /**
     * Parasoft Jtest UTA: Test for defaultParasoftVirtualizeGroupId()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultParasoftVirtualizeGroupId()
     */
    @Test
    public void testDefaultParasoftVirtualizeGroupId() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        String result = underTest.defaultParasoftVirtualizeGroupId();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultParasoftVirtualizeServerPath()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultParasoftVirtualizeServerPath()
     */
    @Test
    public void testDefaultParasoftVirtualizeServerPath() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        String result = underTest.defaultParasoftVirtualizeServerPath();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultParasoftVirtualizeServerUrl()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultParasoftVirtualizeServerUrl()
     */
    @Test
    public void testDefaultParasoftVirtualizeServerUrl() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        String result = underTest.defaultParasoftVirtualizeServerUrl();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultSoapEndPoint()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultSoapEndPoint()
     */
    @Test
    public void testDefaultSoapEndPoint() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        String result = underTest.defaultSoapEndPoint();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for defaultUseParasoftJDBCProxy()
     *
     * @author jakubiak
     * @see GlobalPreferencesDefaultSettingsService#defaultUseParasoftJDBCProxy()
     */
    @Test
    public void testDefaultUseParasoftJDBCProxy() throws Throwable {
        // Given
        GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

        // When
        boolean result = underTest.defaultUseParasoftJDBCProxy();

        // Then
        // assertFalse(result);
    }
}