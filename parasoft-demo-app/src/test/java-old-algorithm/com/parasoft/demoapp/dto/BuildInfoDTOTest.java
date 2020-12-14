package com.parasoft.demoapp.dto;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for BuildInfoDTO
 *
 * @see BuildInfoDTO
 * @author jakubiak
 */
public class BuildInfoDTOTest
{
    /**
     * Parasoft Jtest UTA: Test for getBuildTime()
     *
     * @author jakubiak
     * @see BuildInfoDTO#getBuildTime()
     */
    @Test
    public void testGetBuildTime() throws Throwable {
        // Given
        BuildInfoDTO underTest = new BuildInfoDTO();

        // When
        long result = underTest.getBuildTime();

        // Then
        // assertEquals(0L, result);
    }
}