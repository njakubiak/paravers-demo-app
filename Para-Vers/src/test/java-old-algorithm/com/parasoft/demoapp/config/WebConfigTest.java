package com.parasoft.demoapp.config;


import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for WebConfig
 *
 * @author jakubiak
 * @see WebConfig
 */
public class WebConfigTest {
    /**
     * Parasoft Jtest UTA: Test for addInterceptors(InterceptorRegistry)
     *
     * @author jakubiak
     * @see WebConfig#addInterceptors(InterceptorRegistry)
     */
    @Test
    public void testAddInterceptors() throws Throwable {
        // Given
        WebConfig underTest = new WebConfig();

        // When
        InterceptorRegistry registry = mockInterceptorRegistry();
        underTest.addInterceptors(registry);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of InterceptorRegistration
     */
    private static InterceptorRegistration mockInterceptorRegistration() throws Throwable {
        InterceptorRegistration addPathPatternsResult2 = mock(InterceptorRegistration.class);
        InterceptorRegistration addPathPatternsResult3 = mock(InterceptorRegistration.class);
        when(addPathPatternsResult2.addPathPatterns(nullable(String[].class))).thenReturn(addPathPatternsResult3);
        return addPathPatternsResult2;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of InterceptorRegistration
     */
    private static InterceptorRegistration mockInterceptorRegistration2() throws Throwable {
        InterceptorRegistration addPathPatternsResult = mock(InterceptorRegistration.class);
        InterceptorRegistration addPathPatternsResult2 = mockInterceptorRegistration();
        when(addPathPatternsResult.addPathPatterns(nullable(String[].class))).thenReturn(addPathPatternsResult2);
        return addPathPatternsResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of InterceptorRegistration
     */
    private static InterceptorRegistration mockInterceptorRegistration3() throws Throwable {
        InterceptorRegistration addInterceptorResult = mock(InterceptorRegistration.class);
        InterceptorRegistration addPathPatternsResult = mockInterceptorRegistration2();
        when(addInterceptorResult.addPathPatterns(nullable(String[].class))).thenReturn(addPathPatternsResult);
        return addInterceptorResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of InterceptorRegistry
     */
    private static InterceptorRegistry mockInterceptorRegistry() throws Throwable {
        InterceptorRegistry registry = mock(InterceptorRegistry.class);
        InterceptorRegistration addInterceptorResult = mockInterceptorRegistration3();
        when(registry.addInterceptor(nullable(HandlerInterceptor.class))).thenReturn(addInterceptorResult);
        return registry;
    }

    /**
     * Parasoft Jtest UTA: Test for addResourceHandlers(ResourceHandlerRegistry)
     *
     * @author jakubiak
     * @see WebConfig#addResourceHandlers(ResourceHandlerRegistry)
     */
    @Test
    public void testAddResourceHandlers() throws Throwable {
        // Given
        WebConfig underTest = new WebConfig();
        String uploadedImageParentLocationValue = ""; // UTA: default value
        ReflectionTestUtils.setField(underTest, "uploadedImageParentLocation", uploadedImageParentLocationValue);

        // When
        ResourceHandlerRegistry registry = mockResourceHandlerRegistry();
        underTest.addResourceHandlers(registry);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ResourceHandlerRegistration
     */
    private static ResourceHandlerRegistration mockResourceHandlerRegistration() throws Throwable {
        ResourceHandlerRegistration addResourceLocationsResult2 = mock(ResourceHandlerRegistration.class);
        ResourceHandlerRegistration addResourceLocationsResult3 = mock(ResourceHandlerRegistration.class);
        when(addResourceLocationsResult2.addResourceLocations(nullable(String[].class))).thenReturn(addResourceLocationsResult3);
        return addResourceLocationsResult2;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ResourceHandlerRegistration
     */
    private static ResourceHandlerRegistration mockResourceHandlerRegistration2() throws Throwable {
        ResourceHandlerRegistration addResourceLocationsResult = mock(ResourceHandlerRegistration.class);
        ResourceHandlerRegistration addResourceLocationsResult2 = mockResourceHandlerRegistration();
        when(addResourceLocationsResult.addResourceLocations(nullable(String[].class))).thenReturn(addResourceLocationsResult2);
        return addResourceLocationsResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ResourceHandlerRegistration
     */
    private static ResourceHandlerRegistration mockResourceHandlerRegistration3() throws Throwable {
        ResourceHandlerRegistration addResourceHandlerResult = mock(ResourceHandlerRegistration.class);
        ResourceHandlerRegistration addResourceLocationsResult = mockResourceHandlerRegistration2();
        when(addResourceHandlerResult.addResourceLocations(nullable(String[].class))).thenReturn(addResourceLocationsResult);
        return addResourceHandlerResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ResourceHandlerRegistry
     */
    private static ResourceHandlerRegistry mockResourceHandlerRegistry() throws Throwable {
        ResourceHandlerRegistry registry = mock(ResourceHandlerRegistry.class);
        ResourceHandlerRegistration addResourceHandlerResult = mockResourceHandlerRegistration3();
        when(registry.addResourceHandler(nullable(String[].class))).thenReturn(addResourceHandlerResult);
        return registry;
    }

    /**
     * Parasoft Jtest UTA: Test for gerEncoder()
     *
     * @author jakubiak
     * @see WebConfig#gerEncoder()
     */
    @Test
    public void testGerEncoder() throws Throwable {
        // Given
        WebConfig underTest = new WebConfig();

        // When
        PasswordEncoder result = underTest.gerEncoder();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for getServerPort()
     *
     * @author jakubiak
     * @see WebConfig#getServerPort()
     */
    @Test
    public void testGetServerPort() throws Throwable {
        // Given
        WebConfig underTest = new WebConfig();

        // When
        int result = underTest.getServerPort();

        // Then
        // assertEquals(0, result);
    }

    /**
     * Parasoft Jtest UTA: Test for getUploadedImagesStorePath()
     *
     * @author jakubiak
     * @see WebConfig#getUploadedImagesStorePath()
     */
    @Test
    public void testGetUploadedImagesStorePath() throws Throwable {
        // Given
        WebConfig underTest = new WebConfig();

        // When
        String result = underTest.getUploadedImagesStorePath();

        // Then
        // assertEquals("", result);
    }
}