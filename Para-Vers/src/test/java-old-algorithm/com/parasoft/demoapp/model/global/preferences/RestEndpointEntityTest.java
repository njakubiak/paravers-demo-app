package com.parasoft.demoapp.model.global.preferences;


import org.junit.Test;

import static org.junit.Assert.assertFalse;


/**
 * Parasoft Jtest UTA: Test class for RestEndpointEntity
 *
 * @see RestEndpointEntity
 * @author jakubiak
 */
public class RestEndpointEntityTest
{
    /**
     * Parasoft Jtest UTA: Test for isStripPrefix()
     *
     * @author jakubiak
     * @see RestEndpointEntity#isStripPrefix()
     */
    @Test
    public void testIsStripPrefix() throws Throwable {
        // Given
        RestEndpointEntity underTest = new RestEndpointEntity();

        // When
        boolean result = underTest.isStripPrefix();

        // Then
        // assertFalse(result);
    }
}