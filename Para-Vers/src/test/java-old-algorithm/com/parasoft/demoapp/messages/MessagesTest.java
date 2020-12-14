package com.parasoft.demoapp.messages;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for Messages
 *
 * @author jakubiak
 * @see Messages
 */
public class MessagesTest {
    /**
     * Parasoft Jtest UTA: Test for getString(String)
     *
     * @author jakubiak
     * @see Messages#getString(String)
     */
    @Test
    public void testGetString() throws Throwable {
        // Given
        String baseName = ""; // UTA: default value
        Messages underTest = new Messages(baseName);

        // When
        String key = ""; // UTA: default value
        String result = underTest.getString(key);

        // Then
        // assertEquals("", result);
    }
}