package com.parasoft.demoapp.model.global.preferences;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for DemoBugsType
 *
 * @author jakubiak
 * @see DemoBugsType
 */
public class DemoBugsTypeTest {
    /**
     * Parasoft Jtest UTA: Test for getValue()
     *
     * @author jakubiak
     * @see DemoBugsType#getValue()
     */
    @Test
    public void testGetValue() throws Throwable {
        // Given
        DemoBugsType underTest = DemoBugsType.INCORRECT_LOCATION_FOR_APPROVED_ORDERS; // UTA: default value

        // When
        String result = underTest.getValue();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for valueOf(String)
     *
     * @author jakubiak
     * @see DemoBugsType#valueOf(String)
     */
    @Test
    public void testValueOf() throws Throwable {
        // When
        String name = ""; // UTA: default value
        DemoBugsType result = DemoBugsType.valueOf(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for values()
     *
     * @author jakubiak
     * @see DemoBugsType#values()
     */
    @Test
    public void testValues() throws Throwable {
        // When
        DemoBugsType[] result = DemoBugsType.values();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.length);
    }
}