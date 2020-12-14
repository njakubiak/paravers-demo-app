package com.parasoft.demoapp.util;


import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for UrlUtil
 *
 * @author jakubiak
 * @see UrlUtil
 */
public class UrlUtilTest {
    /**
     * Parasoft Jtest UTA: Test for isGoodHttpForm(String)
     *
     * @author jakubiak
     * @see UrlUtil#isGoodHttpForm(String)
     */
    @Test
    public void testIsGoodHttpForm() throws Throwable {
        // When
        String urlStr = ""; // UTA: default value
        boolean result = UrlUtil.isGoodHttpForm(urlStr);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Test for isRestfulApiRequest(HttpServletRequest)
     *
     * @author jakubiak
     * @see UrlUtil#isRestfulApiRequest(HttpServletRequest)
     */
    @Test
    public void testIsRestfulApiRequest() throws Throwable {
        // When
        HttpServletRequest req = mockHttpServletRequest();
        boolean result = UrlUtil.isRestfulApiRequest(req);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of HttpServletRequest
     */
    private static HttpServletRequest mockHttpServletRequest() throws Throwable {
        HttpServletRequest req = mock(HttpServletRequest.class);
        String getRequestURIResult = ""; // UTA: default value
        when(req.getRequestURI()).thenReturn(getRequestURIResult);
        return req;
    }

    /**
     * Parasoft Jtest UTA: Test for validateUrl(String)
     *
     * @author jakubiak
     * @see UrlUtil#validateUrl(String)
     */
    @Test
    public void testValidateUrl() throws Throwable {
        // When
        String urlStr = ""; // UTA: default value
        int result = UrlUtil.validateUrl(urlStr);

        // Then
        // assertEquals(0, result);
    }
}