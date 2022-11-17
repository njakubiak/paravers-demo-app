/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for CustomUserDetailsService
 *
 * @see com.parasoft.demoapp.service.CustomUserDetailsService
 * @author jakubiak
 */
public class CustomUserDetailsServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for loadUserByUsername(String)
	 *
	 * @see com.parasoft.demoapp.service.CustomUserDetailsService#loadUserByUsername(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testLoadUserByUsername() throws Throwable {
		// Given
		CustomUserDetailsService underTest = new CustomUserDetailsService();
		UserService userServiceValue = mock(UserService.class);
		ReflectionTestUtils.setField(underTest, "userService", userServiceValue);

		// When
		String username = "username"; // UTA: default value
		UserDetails result = underTest.loadUserByUsername(username);

		// Then - assertions for result of method loadUserByUsername(String)
		assertNull(result);

	}
}