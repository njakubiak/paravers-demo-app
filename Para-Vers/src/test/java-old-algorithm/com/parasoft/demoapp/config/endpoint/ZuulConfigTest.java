package com.parasoft.demoapp.config.endpoint;


import com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService;
import com.parasoft.demoapp.service.RestEndpointService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for ZuulConfig
 *
 * @author jakubiak
 * @see ZuulConfig
 */
public class ZuulConfigTest {
    /**
     * Parasoft Jtest UTA: Test for routeLocator(RestEndpointService, GlobalPreferencesDefaultSettingsService)
     *
     * @author jakubiak
     * @see ZuulConfig#routeLocator(RestEndpointService, GlobalPreferencesDefaultSettingsService)
     */
    @Test
    public void testRouteLocator() throws Throwable {
        // Given
        ZuulConfig underTest = new ZuulConfig();

        // When
        RestEndpointService restEndpointService = mock(RestEndpointService.class);
        GlobalPreferencesDefaultSettingsService defaultGlobalPreferencesSettingsService = mock(GlobalPreferencesDefaultSettingsService.class);
        CustomRouteLocator result = underTest.routeLocator(restEndpointService, defaultGlobalPreferencesSettingsService);

        // Then
        // assertNotNull(result);
    }
}