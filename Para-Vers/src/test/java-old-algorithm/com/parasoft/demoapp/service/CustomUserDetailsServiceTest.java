package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.global.UserEntity;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for CustomUserDetailsService
 *
 * @author jakubiak
 * @see CustomUserDetailsService
 */
public class CustomUserDetailsServiceTest {
    /**
     * Parasoft Jtest UTA: Test for loadUserByUsername(String)
     *
     * @author jakubiak
     * @see CustomUserDetailsService#loadUserByUsername(String)
     */
    @Test
    public void testLoadUserByUsername() throws Throwable {
        // Given
        CustomUserDetailsService underTest = new CustomUserDetailsService();
        UserService userServiceValue = mockUserService();
        ReflectionTestUtils.setField(underTest, "userService", userServiceValue);

        // When
        String username = ""; // UTA: default value
        UserDetails result = underTest.loadUserByUsername(username);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of UserService
     */
    private static UserService mockUserService() throws Throwable {
        UserService userServiceValue = mock(UserService.class);
        UserEntity getUserByUsernameResult = mock(UserEntity.class);
        when(userServiceValue.getUserByUsername(nullable(String.class))).thenReturn(getUserByUsernameResult);
        return userServiceValue;
    }
}