package com.parasoft.demoapp.model.global.preferences;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for DataAccessMode
 *
 * @author jakubiak
 * @see DataAccessMode
 */
public class DataAccessModeTest {
    /**
     * Parasoft Jtest UTA: Test for getValue()
     *
     * @author jakubiak
     * @see DataAccessMode#getValue()
     */
    @Test
    public void testGetValue() throws Throwable {
        // Given
        DataAccessMode underTest = DataAccessMode.JDBC; // UTA: default value

        // When
        String result = underTest.getValue();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for valueOf(String)
     *
     * @author jakubiak
     * @see DataAccessMode#valueOf(String)
     */
    @Test
    public void testValueOf() throws Throwable {
        // When
        String name = ""; // UTA: default value
        DataAccessMode result = DataAccessMode.valueOf(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for values()
     *
     * @author jakubiak
     * @see DataAccessMode#values()
     */
    @Test
    public void testValues() throws Throwable {
        // When
        DataAccessMode[] result = DataAccessMode.values();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.length);
    }
}