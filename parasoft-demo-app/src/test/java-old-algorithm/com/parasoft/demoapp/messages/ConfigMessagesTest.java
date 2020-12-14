package com.parasoft.demoapp.messages;


import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for ConfigMessages
 *
 * @author jakubiak
 * @see ConfigMessages
 */
public class ConfigMessagesTest {
    /**
     * Parasoft Jtest UTA: Test for getString(String)
     *
     * @author jakubiak
     * @see Messages#getString(String)
     */
    @Test
    public void testGetString() throws Throwable {
        // Given
        ConfigMessages underTest = new ConfigMessages();
        ResourceBundle resourceBundleValue = mockResourceBundle();
        ReflectionTestUtils.setField(underTest, "resourceBundle", resourceBundleValue);

        // When
        String key = ""; // UTA: default value
        String result = underTest.getString(key);

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ResourceBundle
     */
    private static ResourceBundle mockResourceBundle() throws Throwable {
        ResourceBundle resourceBundleValue = mock(ResourceBundle.class);
        return resourceBundleValue;
    }
}