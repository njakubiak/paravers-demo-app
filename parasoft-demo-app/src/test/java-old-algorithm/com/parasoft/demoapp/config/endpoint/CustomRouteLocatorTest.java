package com.parasoft.demoapp.config.endpoint;


import com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService;
import com.parasoft.demoapp.service.RestEndpointService;
import org.junit.Test;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for CustomRouteLocator
 *
 * @see CustomRouteLocator
 * @author jakubiak
 */
public class CustomRouteLocatorTest
{
    /**
     * Parasoft Jtest UTA: Test for refresh()
     *
     * @author jakubiak
     * @see CustomRouteLocator#refresh()
     */
    @Test
    public void testRefresh() throws Throwable {
        // Given
        String servletPath = ""; // UTA: default value
        ZuulProperties properties = mockZuulProperties();
        RestEndpointService restEndpointService = mock(RestEndpointService.class);
        GlobalPreferencesDefaultSettingsService defaultGlobalPreferencesSettingsService = mock(GlobalPreferencesDefaultSettingsService.class);
        CustomRouteLocator underTest = new CustomRouteLocator(servletPath, properties, restEndpointService, defaultGlobalPreferencesSettingsService);

        // When
        underTest.refresh();

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ZuulProperties
     */
    private static ZuulProperties mockZuulProperties() throws Throwable {
        ZuulProperties properties = mock(ZuulProperties.class);
        String getServletPathResult = ""; // UTA: default value
        when(properties.getServletPath()).thenReturn(getServletPathResult);
        return properties;
    }
}