package com.parasoft.demoapp.config.security;


import org.junit.Test;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for CustomLogoutSuccessHandler
 *
 * @author jakubiak
 * @see CustomLogoutSuccessHandler
 */
public class CustomLogoutSuccessHandlerTest {
    /**
     * Parasoft Jtest UTA: Test for onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)
     *
     * @author jakubiak
     * @see CustomLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)
     */
    @Test
    public void testOnLogoutSuccess() throws Throwable {
        // Given
        CustomLogoutSuccessHandler underTest = new CustomLogoutSuccessHandler();

        // When
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        Authentication authentication = mock(Authentication.class);
        underTest.onLogoutSuccess(request, response, authentication);

    }
}