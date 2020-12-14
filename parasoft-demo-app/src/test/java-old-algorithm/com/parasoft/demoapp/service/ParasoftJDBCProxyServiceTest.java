package com.parasoft.demoapp.service;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for ParasoftJDBCProxyService
 *
 * @author jakubiak
 * @see ParasoftJDBCProxyService
 */
public class ParasoftJDBCProxyServiceTest {
    /**
     * Parasoft Jtest UTA: Test for getProxyKeyOfCurrentIndustry()
     *
     * @author jakubiak
     * @see ParasoftJDBCProxyService#getProxyKeyOfCurrentIndustry()
     */
    @Test
    public void testGetProxyKeyOfCurrentIndustry() throws Throwable {
        // Given
        ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();

        // When
        String result = underTest.getProxyKeyOfCurrentIndustry();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for validateVirtualizeGroupId(String)
     *
     * @author jakubiak
     * @see ParasoftJDBCProxyService#validateVirtualizeGroupId(String)
     */
    @Test
    public void testValidateVirtualizeGroupId() throws Throwable {
        // Given
        ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();

        // When
        String virtualizeGroupId = ""; // UTA: default value
        underTest.validateVirtualizeGroupId(virtualizeGroupId);

    }

    /**
     * Parasoft Jtest UTA: Test for validateVirtualizeServerPath(String)
     *
     * @author jakubiak
     * @see ParasoftJDBCProxyService#validateVirtualizeServerPath(String)
     */
    @Test
    public void testValidateVirtualizeServerPath() throws Throwable {
        // Given
        ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();

        // When
        String virtualizeServerPath = ""; // UTA: default value
        underTest.validateVirtualizeServerPath(virtualizeServerPath);

    }

    /**
     * Parasoft Jtest UTA: Test for validateVirtualizeServerUrl(String)
     *
     * @author jakubiak
     * @see ParasoftJDBCProxyService#validateVirtualizeServerUrl(String)
     */
    @Test
    public void testValidateVirtualizeServerUrl() throws Throwable {
        // Given
        ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();

        // When
        String virtualizeServerUrl = ""; // UTA: default value
        underTest.validateVirtualizeServerUrl(virtualizeServerUrl);

    }
}