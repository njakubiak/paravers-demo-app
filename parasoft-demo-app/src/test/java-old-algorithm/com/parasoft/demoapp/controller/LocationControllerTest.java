package com.parasoft.demoapp.controller;


import com.parasoft.demoapp.model.industry.LocationEntity;
import com.parasoft.demoapp.model.industry.RegionType;
import com.parasoft.demoapp.service.LocationService;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for LocationController
 *
 * @author jakubiak
 * @see LocationController
 */
public class LocationControllerTest {
    /**
     * Parasoft Jtest UTA: Test for getAllRegionTypesOfCurrentIndustry()
     *
     * @author jakubiak
     * @see LocationController#getAllRegionTypesOfCurrentIndustry()
     */
    @Test
    public void testGetAllRegionTypesOfCurrentIndustry() throws Throwable {
        // Given
        LocationController underTest = new LocationController();
        LocationService locationServiceValue = mockLocationService();
        ReflectionTestUtils.setField(underTest, "locationService", locationServiceValue);

        // When
        ResponseResult<List<RegionType>> result = underTest.getAllRegionTypesOfCurrentIndustry();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationService
     */
    private static LocationService mockLocationService() throws Throwable {
        LocationService locationServiceValue = mock(LocationService.class);
        List<RegionType> getRegionsOfCurrentIndustryResult = new ArrayList<RegionType>(); // UTA: default value
        RegionType item = RegionType.AUSTRALIA; // UTA: default value
        getRegionsOfCurrentIndustryResult.add(item);
        doReturn(getRegionsOfCurrentIndustryResult).when(locationServiceValue).getRegionsOfCurrentIndustry();
        return locationServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getLocation(RegionType)
     *
     * @author jakubiak
     * @see LocationController#getLocation(RegionType)
     */
    @Test
    public void testGetLocation() throws Throwable {
        // Given
        LocationController underTest = new LocationController();
        LocationService locationServiceValue = mockLocationService2();
        ReflectionTestUtils.setField(underTest, "locationService", locationServiceValue);

        // When
        RegionType region = RegionType.AUSTRALIA; // UTA: default value
        ResponseResult<LocationEntity> result = underTest.getLocation(region);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationService
     */
    private static LocationService mockLocationService2() throws Throwable {
        LocationService locationServiceValue = mock(LocationService.class);
        LocationEntity getLocationByRegionResult = mock(LocationEntity.class);
        when(locationServiceValue.getLocationByRegion(nullable(RegionType.class))).thenReturn(getLocationByRegionResult);
        return locationServiceValue;
    }
}