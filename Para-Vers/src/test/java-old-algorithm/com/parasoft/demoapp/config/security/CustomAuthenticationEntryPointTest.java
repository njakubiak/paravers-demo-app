package com.parasoft.demoapp.config.security;


import org.junit.Test;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for CustomAuthenticationEntryPoint
 *
 * @author jakubiak
 * @see CustomAuthenticationEntryPoint
 */
public class CustomAuthenticationEntryPointTest {
    /**
     * Parasoft Jtest UTA: Test for commence(HttpServletRequest, HttpServletResponse, AuthenticationException)
     *
     * @author jakubiak
     * @see CustomAuthenticationEntryPoint#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)
     */
    @Test
    public void testCommence() throws Throwable {
        // Given
        CustomAuthenticationEntryPoint underTest = new CustomAuthenticationEntryPoint();

        // When
        HttpServletRequest req = mockHttpServletRequest();
        HttpServletResponse resp = mockHttpServletResponse();
        AuthenticationException authException = mockAuthenticationException();
        underTest.commence(req, resp, authException);

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
     * Parasoft Jtest UTA: Helper method to generate and configure mock of HttpServletResponse
     */
    private static HttpServletResponse mockHttpServletResponse() throws Throwable {
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter getWriterResult = mock(PrintWriter.class);
        when(resp.getWriter()).thenReturn(getWriterResult);
        return resp;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of AuthenticationException
     */
    private static AuthenticationException mockAuthenticationException() throws Throwable {
        AuthenticationException authException = mock(AuthenticationException.class);
        String getMessageResult = ""; // UTA: default value
        when(authException.getMessage()).thenReturn(getMessageResult);
        return authException;
    }

    /**
     * Parasoft Jtest UTA: Test for isRestfulApiRequest(HttpServletRequest)
     *
     * @author jakubiak
     * @see CustomAuthenticationEntryPoint#isRestfulApiRequest(HttpServletRequest)
     */
    @Test
    public void testIsRestfulApiRequest() throws Throwable {
        // Given
        CustomAuthenticationEntryPoint underTest = new CustomAuthenticationEntryPoint();

        // When
        HttpServletRequest req = mockHttpServletRequest2();
        boolean result = underTest.isRestfulApiRequest(req);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of HttpServletRequest
     */
    private static HttpServletRequest mockHttpServletRequest2() throws Throwable {
        HttpServletRequest req = mock(HttpServletRequest.class);
        String getRequestURIResult = ""; // UTA: default value
        when(req.getRequestURI()).thenReturn(getRequestURIResult);
        return req;
    }
}