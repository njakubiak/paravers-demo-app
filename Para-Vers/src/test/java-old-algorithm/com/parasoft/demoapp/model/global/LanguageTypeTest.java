package com.parasoft.demoapp.model.global;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for LanguageType
 *
 * @author jakubiak
 * @see LanguageType
 */
public class LanguageTypeTest {
    /**
     * Parasoft Jtest UTA: Test for getValue()
     *
     * @author jakubiak
     * @see LanguageType#getValue()
     */
    @Test
    public void testGetValue() throws Throwable {
        // Given
        LanguageType underTest = LanguageType.DEFAULT; // UTA: default value

        // When
        String result = underTest.getValue();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for valueOf(String)
     *
     * @author jakubiak
     * @see LanguageType#valueOf(String)
     */
    @Test
    public void testValueOf() throws Throwable {
        // When
        String name = ""; // UTA: default value
        LanguageType result = LanguageType.valueOf(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for values()
     *
     * @author jakubiak
     * @see LanguageType#values()
     */
    @Test
    public void testValues() throws Throwable {
        // When
        LanguageType[] result = LanguageType.values();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.length);
    }
}