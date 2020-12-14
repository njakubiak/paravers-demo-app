package com.parasoft.demoapp.model.global.preferences;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for IndustryType
 *
 * @author jakubiak
 * @see IndustryType
 */
public class IndustryTypeTest {
    /**
     * Parasoft Jtest UTA: Test for getValue()
     *
     * @author jakubiak
     * @see IndustryType#getValue()
     */
    @Test
    public void testGetValue() throws Throwable {
        // Given
        IndustryType underTest = IndustryType.AEROSPACE; // UTA: default value

        // When
        String result = underTest.getValue();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for valueOf(String)
     *
     * @author jakubiak
     * @see IndustryType#valueOf(String)
     */
    @Test
    public void testValueOf() throws Throwable {
        // When
        String name = ""; // UTA: default value
        IndustryType result = IndustryType.valueOf(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for values()
     *
     * @author jakubiak
     * @see IndustryType#values()
     */
    @Test
    public void testValues() throws Throwable {
        // When
        IndustryType[] result = IndustryType.values();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.length);
    }
}