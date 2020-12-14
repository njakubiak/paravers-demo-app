package com.parasoft.demoapp.service;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ParameterValidator
 *
 * @author jakubiak
 * @see ParameterValidator
 */
public class ParameterValidatorTest {
    /**
     * Parasoft Jtest UTA: Test for requireNonBlank(CharSequence, String)
     *
     * @author jakubiak
     * @see ParameterValidator#requireNonBlank(CharSequence, String)
     */
    @Test
    public void testRequireNonBlank() throws Throwable {
        // When
        CharSequence cs = mockCharSequence();
        String message = ""; // UTA: default value
        CharSequence result = ParameterValidator.requireNonBlank(cs, message);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CharSequence
     */
    private static CharSequence mockCharSequence() throws Throwable {
        CharSequence cs = mock(CharSequence.class);
        char charAtResult = 'c'; // UTA: default value
        when(cs.charAt(anyInt())).thenReturn(charAtResult);

        int lengthResult = 0; // UTA: default value
        when(cs.length()).thenReturn(lengthResult);
        return cs;
    }

    /**
     * Parasoft Jtest UTA: Test for requireNonNegative(int, String)
     *
     * @author jakubiak
     * @see ParameterValidator#requireNonNegative(int, String)
     */
    @Test
    public void testRequireNonNegative() throws Throwable {
        // When
        int number = 0; // UTA: default value
        String message = ""; // UTA: default value
        int result = ParameterValidator.requireNonNegative(number, message);

        // Then
        // assertEquals(0, result);
    }

    /**
     * Parasoft Jtest UTA: Test for requireNonNull(T, String)
     *
     * @author jakubiak
     * @see ParameterValidator#requireNonNull(T, String)
     */
    @Test
    public void testRequireNonNull() throws Throwable {
        // When
        Object obj = new Object(); // UTA: default value
        String message = ""; // UTA: default value
        Object result = ParameterValidator.requireNonNull(obj, message);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for requireNonZero(int, String)
     *
     * @author jakubiak
     * @see ParameterValidator#requireNonZero(int, String)
     */
    @Test
    public void testRequireNonZero() throws Throwable {
        // When
        int number = 0; // UTA: default value
        String message = ""; // UTA: default value
        int result = ParameterValidator.requireNonZero(number, message);

        // Then
        // assertEquals(0, result);
    }
}