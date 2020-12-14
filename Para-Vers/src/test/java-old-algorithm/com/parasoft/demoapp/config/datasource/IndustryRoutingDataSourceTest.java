package com.parasoft.demoapp.config.datasource;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for IndustryRoutingDataSource
 *
 * @author jakubiak
 * @see IndustryRoutingDataSource
 */
public class IndustryRoutingDataSourceTest {
    /**
     * Parasoft Jtest UTA: Test for determineCurrentLookupKey()
     *
     * @author jakubiak
     * @see IndustryRoutingDataSource#determineCurrentLookupKey()
     */
    @Test
    public void testDetermineCurrentLookupKey() throws Throwable {
        // Given
        IndustryRoutingDataSource underTest = new IndustryRoutingDataSource();

        // When
        Object result = underTest.determineCurrentLookupKey();

        // Then
        // assertNotNull(result);
    }
}