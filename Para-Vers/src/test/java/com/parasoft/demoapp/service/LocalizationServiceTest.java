/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.messages.Messages;
import java.lang.reflect.Field;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for LocalizationService
 *
 * @see com.parasoft.demoapp.service.LocalizationService
 * @author jakubiak
 */
public class LocalizationServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for getLocalization(String)
	 *
	 * @see com.parasoft.demoapp.service.LocalizationService#getLocalization(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetLocalization2() throws Throwable {
		// Given
		LocalizationService underTest = new LocalizationService();
		GlobalPreferencesService globalPreferencesServiceValue = mock(GlobalPreferencesService.class);
		ReflectionTestUtils.setField(underTest, "globalPreferencesService", globalPreferencesServiceValue);
		Messages messagesValue = mockMessages();
		ReflectionTestUtils.setField(underTest, "messages", messagesValue);

		// When
		String language = "language"; // UTA: default value
		String result = underTest.getLocalization(language);

		// Then - assertions for result of method getLocalization(String)
		assertEquals("{}", result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of Messages
	 */
	private static Messages mockMessages() throws Throwable {
		Messages messagesValue = mock(Messages.class);
		String getStringResult = "getStringResult"; // UTA: default value
		when(messagesValue.getString(nullable(String.class))).thenReturn(getStringResult);
		return messagesValue;
	}

}