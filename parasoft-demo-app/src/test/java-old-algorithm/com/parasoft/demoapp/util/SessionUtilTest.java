package com.parasoft.demoapp.util;


import com.parasoft.demoapp.model.global.UserEntity;
import org.junit.Test;
import org.springframework.security.core.context.SecurityContext;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for SessionUtil
 *
 * @author jakubiak
 * @see SessionUtil
 */
public class SessionUtilTest {
    /**
     * Parasoft Jtest UTA: Test for getUserEntityInSession(HttpSession)
     *
     * @author jakubiak
     * @see SessionUtil#getUserEntityInSession(HttpSession)
     */
    @Test
    public void testGetUserEntityInSession() throws Throwable {
        // When
        HttpSession session = mockHttpSession();
        UserEntity result = SessionUtil.getUserEntityInSession(session);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of HttpSession
     */
    private static HttpSession mockHttpSession() throws Throwable {
        HttpSession session = mock(HttpSession.class);
        SecurityContext getAttributeResult = mock(SecurityContext.class);
        when(session.getAttribute(nullable(String.class))).thenReturn(getAttributeResult);
        return session;
    }
}