package com.parasoft.demoapp.model.global;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for RoleType
 *
 * @author jakubiak
 * @see RoleType
 */
public class RoleTypeTest {
    /**
     * Parasoft Jtest UTA: Test for valueOf(String)
     *
     * @author jakubiak
     * @see RoleType#valueOf(String)
     */
    @Test
    public void testValueOf() throws Throwable {
        // When
        String name = ""; // UTA: default value
        RoleType result = RoleType.valueOf(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for values()
     *
     * @author jakubiak
     * @see RoleType#values()
     */
    @Test
    public void testValues() throws Throwable {
        // When
        RoleType[] result = RoleType.values();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.length);
    }
}