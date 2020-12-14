package com.parasoft.demoapp.model.industry;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for OrderStatus
 *
 * @author jakubiak
 * @see OrderStatus
 */
public class OrderStatusTest {
    /**
     * Parasoft Jtest UTA: Test for getStatus()
     *
     * @author jakubiak
     * @see OrderStatus#getStatus()
     */
    @Test
    public void testGetStatus() throws Throwable {
        // Given
        OrderStatus underTest = OrderStatus.APPROVED; // UTA: default value

        // When
        String result = underTest.getStatus();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for valueOf(String)
     *
     * @author jakubiak
     * @see OrderStatus#valueOf(String)
     */
    @Test
    public void testValueOf() throws Throwable {
        // When
        String name = ""; // UTA: default value
        OrderStatus result = OrderStatus.valueOf(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for values()
     *
     * @author jakubiak
     * @see OrderStatus#values()
     */
    @Test
    public void testValues() throws Throwable {
        // When
        OrderStatus[] result = OrderStatus.values();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.length);
    }
}