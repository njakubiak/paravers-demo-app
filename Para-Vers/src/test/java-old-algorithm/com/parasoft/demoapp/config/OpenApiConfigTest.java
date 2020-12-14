package com.parasoft.demoapp.config;


import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springdoc.core.GroupedOpenApi;

import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for OpenApiConfig
 *
 * @author jakubiak
 * @see OpenApiConfig
 */
public class OpenApiConfigTest {
    /**
     * Parasoft Jtest UTA: Test for customOpenAPI()
     *
     * @author jakubiak
     * @see OpenApiConfig#customOpenAPI()
     */
    @Test
    public void testCustomOpenAPI() throws Throwable {
        // Given
        OpenApiConfig underTest = new OpenApiConfig();

        // When
        OpenAPI result = underTest.customOpenAPI();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for proxyRestApiOfV1()
     *
     * @author jakubiak
     * @see OpenApiConfig#proxyRestApiOfV1()
     */
    @Test
    public void testProxyRestApiOfV1() throws Throwable {
        // Given
        OpenApiConfig underTest = new OpenApiConfig();

        // When
        GroupedOpenApi result = underTest.proxyRestApiOfV1();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for regularRestApiOfV1()
     *
     * @author jakubiak
     * @see OpenApiConfig#regularRestApiOfV1()
     */
    @Test
    public void testRegularRestApiOfV1() throws Throwable {
        // Given
        OpenApiConfig underTest = new OpenApiConfig();

        // When
        GroupedOpenApi result = underTest.regularRestApiOfV1();

        // Then
        // assertNotNull(result);
    }
}