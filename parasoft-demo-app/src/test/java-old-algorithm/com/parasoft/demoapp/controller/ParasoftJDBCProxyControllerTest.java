package com.parasoft.demoapp.controller;


import com.parasoft.demoapp.dto.ParasoftJDBCProxyStatusResponseDTO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for ParasoftJDBCProxyController
 *
 * @author jakubiak
 * @see ParasoftJDBCProxyController
 */
public class ParasoftJDBCProxyControllerTest {
    /**
     * Parasoft Jtest UTA: Test for getParasoftJDBCProxyStatus()
     *
     * @author jakubiak
     * @see ParasoftJDBCProxyController#getParasoftJDBCProxyStatus()
     */
    @Test
    public void testGetParasoftJDBCProxyStatus() throws Throwable {
        // Given
        ParasoftJDBCProxyController underTest = new ParasoftJDBCProxyController();

        // When
        ResponseResult<ParasoftJDBCProxyStatusResponseDTO> result = underTest.getParasoftJDBCProxyStatus();

        // Then
        // assertNotNull(result);
    }
}