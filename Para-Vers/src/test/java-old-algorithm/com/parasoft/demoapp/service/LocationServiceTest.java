package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.industry.LocationEntity;
import com.parasoft.demoapp.model.industry.RegionType;
import com.parasoft.demoapp.repository.industry.LocationRepository;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for LocationService
 *
 * @author jakubiak
 * @see LocationService
 */
public class LocationServiceTest {
    /**
     * Parasoft Jtest UTA: Test for getAllLocations()
     *
     * @author jakubiak
     * @see LocationService#getAllLocations()
     */
    @Test
    public void testGetAllLocations() throws Throwable {
        // Given
        LocationService underTest = new LocationService();
        LocationRepository locationRepositoryValue = mockLocationRepository();
        ReflectionTestUtils.setField(underTest, "locationRepository", locationRepositoryValue);

        // When
        List<LocationEntity> result = underTest.getAllLocations();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.contains(null));
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationRepository
     */
    private static LocationRepository mockLocationRepository() throws Throwable {
        LocationRepository locationRepositoryValue = mock(LocationRepository.class);
        List<LocationEntity> findAllResult = new ArrayList<LocationEntity>(); // UTA: default value
        LocationEntity item = mock(LocationEntity.class);
        findAllResult.add(item);
        doReturn(findAllResult).when(locationRepositoryValue).findAll();
        return locationRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getLocationByRegion(RegionType)
     *
     * @author jakubiak
     * @see LocationService#getLocationByRegion(RegionType)
     */
    @Test
    public void testGetLocationByRegion() throws Throwable {
        // Given
        LocationService underTest = new LocationService();
        LocationRepository locationRepositoryValue = mockLocationRepository2();
        ReflectionTestUtils.setField(underTest, "locationRepository", locationRepositoryValue);

        // When
        RegionType region = RegionType.AUSTRALIA; // UTA: default value
        LocationEntity result = underTest.getLocationByRegion(region);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationRepository
     */
    private static LocationRepository mockLocationRepository2() throws Throwable {
        LocationRepository locationRepositoryValue = mock(LocationRepository.class);
        LocationEntity findByRegionResult = mock(LocationEntity.class);
        when(locationRepositoryValue.findByRegion(nullable(RegionType.class))).thenReturn(findByRegionResult);
        return locationRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getRegionsOfCurrentIndustry()
     *
     * @author jakubiak
     * @see LocationService#getRegionsOfCurrentIndustry()
     */
    @Test
    public void testGetRegionsOfCurrentIndustry() throws Throwable {
        // Given
        LocationService underTest = new LocationService();

        // When
        List<RegionType> result = underTest.getRegionsOfCurrentIndustry();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.contains(null));
    }

    /**
     * Parasoft Jtest UTA: Test for isCorrectRegionInCurrentIndustry(RegionType)
     *
     * @author jakubiak
     * @see LocationService#isCorrectRegionInCurrentIndustry(RegionType)
     */
    @Test
    public void testIsCorrectRegionInCurrentIndustry() throws Throwable {
        // Given
        LocationService underTest = new LocationService();

        // When
        RegionType region = RegionType.AUSTRALIA; // UTA: default value
        boolean result = underTest.isCorrectRegionInCurrentIndustry(region);

        // Then
        // assertFalse(result);
    }
}