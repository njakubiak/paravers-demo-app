/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.parasoft.demoapp.config.WebConfig;
import com.parasoft.demoapp.model.global.preferences.DataAccessMode;
import com.parasoft.demoapp.model.global.preferences.DemoBugEntity;
import com.parasoft.demoapp.model.global.preferences.GlobalPreferencesEntity;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import com.parasoft.demoapp.model.global.preferences.RestEndpointEntity;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for GlobalPreferencesDefaultSettingsService
 *
 * @see com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService
 * @author jakubiak
 */
public class GlobalPreferencesDefaultSettingsServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for defaultAdvertisingEnabled()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService#defaultAdvertisingEnabled()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testDefaultAdvertisingEnabled() throws Throwable {
		// Given
		GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

		// When
		boolean result = underTest.defaultAdvertisingEnabled();

		// Then - assertions for result of method defaultAdvertisingEnabled()
		assertTrue(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for defaultDemoBugs()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService#defaultDemoBugs()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testDefaultDemoBugs() throws Throwable {
		// Given
		GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

		// When
		Set<DemoBugEntity> result = underTest.defaultDemoBugs();

		// Then - assertions for result of method defaultDemoBugs()
		assertNotNull(result);
		assertEquals(2, result.size());

	}

	/**
	 * Parasoft Jtest UTA: Test for defaultLocationsEndpoint()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService#defaultLocationsEndpoint()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testDefaultLocationsEndpoint() throws Throwable {
		// Given
		GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();
		WebConfig webConfigValue = mock(WebConfig.class);
		ReflectionTestUtils.setField(underTest, "webConfig", webConfigValue);

		// When
		RestEndpointEntity result = underTest.defaultLocationsEndpoint();

		// Then - assertions for result of method defaultLocationsEndpoint()
		assertNotNull(result);
		assertNull(result.getId());
		assertEquals("locations", result.getRouteId());
		assertEquals("/proxy/v1/locations/**", result.getPath());
		assertNull(result.getServiceId());
		assertEquals("http://localhost:0/v1/locations", result.getUrl());
		assertTrue(result.isStripPrefix());
		assertNotNull(result.getRetryable());
		assertFalse(result.getRetryable());
		assertNull(result.getGlobalPreferences());

	}

	/**
	 * Parasoft Jtest UTA: Test for defaultParasoftJdbcDriverArguments()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService#defaultParasoftJdbcDriverArguments()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testDefaultParasoftJdbcDriverArguments() throws Throwable {
		// Given
		GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();

		// When
		Map<String, String> result = underTest.defaultParasoftJdbcDriverArguments();

		// Then - assertions for result of method defaultParasoftJdbcDriverArguments()
		assertNotNull(result);
		assertEquals(5, result.size());

	}

	/**
	 * Parasoft Jtest UTA: Test for defaultPreferences()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService#defaultPreferences()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testDefaultPreferences() throws Throwable {
		// Given
		GlobalPreferencesDefaultSettingsService underTest = new GlobalPreferencesDefaultSettingsService();
		WebConfig webConfigValue = mock(WebConfig.class);
		ReflectionTestUtils.setField(underTest, "webConfig", webConfigValue);

		// When
		GlobalPreferencesEntity result = underTest.defaultPreferences();

		// Then - assertions for result of method defaultPreferences()
		assertNotNull(result);
		assertNull(result.getId());
		assertNull(result.getDataAccessMode());
		assertNull(result.getSoapEndPoint());
		assertEquals(com.parasoft.demoapp.model.global.preferences.IndustryType.DEFENSE, result.getIndustryType());
		assertNotNull(result.getAdvertisingEnabled());
		assertTrue(result.getAdvertisingEnabled());
		assertNotNull(result.getUseParasoftJDBCProxy());
		assertFalse(result.getUseParasoftJDBCProxy());
		assertEquals("http://localhost:9080", result.getParasoftVirtualizeServerUrl());
		assertEquals("/virtualDb", result.getParasoftVirtualizeServerPath());
		assertEquals("pda", result.getParasoftVirtualizeGroupId());
		assertNotNull(result.getDemoBugs());
		assertEquals(2, result.getDemoBugs().size());
		assertNotNull(result.getRestEndPoints());
		assertEquals(5, result.getRestEndPoints().size());

	}

}