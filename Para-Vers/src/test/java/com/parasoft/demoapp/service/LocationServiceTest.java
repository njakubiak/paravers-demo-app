/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.exception.LocationNotFoundException;
import com.parasoft.demoapp.model.industry.LocationEntity;
import com.parasoft.demoapp.model.industry.RegionType;
import com.parasoft.demoapp.repository.industry.LocationRepository;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for LocationService
 *
 * @see com.parasoft.demoapp.service.LocationService
 * @author jakubiak
 */
public class LocationServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for getAllLocations()
	 *
	 * @see com.parasoft.demoapp.service.LocationService#getAllLocations()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetAllLocations() throws Throwable {
		// Given
		LocationService underTest = new LocationService();
		LocationRepository locationRepositoryValue = mock(LocationRepository.class);
		ReflectionTestUtils.setField(underTest, "locationRepository", locationRepositoryValue);

		// When
		List<LocationEntity> result = underTest.getAllLocations();

		// Then - assertions for result of method getAllLocations()
		assertNotNull(result);
		assertEquals(0, result.size());

	}

	/**
	 * Parasoft Jtest UTA: Test for getLocationByRegion(RegionType)
	 *
	 * @see com.parasoft.demoapp.service.LocationService#getLocationByRegion(RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetLocationByRegion() throws Throwable {
		// Given
		LocationService underTest = new LocationService();
		LocationRepository locationRepositoryValue = mockLocationRepository();
		ReflectionTestUtils.setField(underTest, "locationRepository", locationRepositoryValue);

		// When
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		LocationEntity result = underTest.getLocationByRegion(region);

		// Then - assertions for result of method getLocationByRegion(RegionType)
		assertNotNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationRepository
	 */
	private static LocationRepository mockLocationRepository() throws Throwable {
		LocationRepository locationRepositoryValue = mock(LocationRepository.class);
		LocationEntity findByRegionResult = mock(LocationEntity.class);
		when(locationRepositoryValue.findByRegion(nullable(RegionType.class))).thenReturn(findByRegionResult);
		return locationRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getLocationByRegion(RegionType)
	 *
	 * @see com.parasoft.demoapp.service.LocationService#getLocationByRegion(RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = LocationNotFoundException.class)
	public void testGetLocationByRegion2() throws Throwable {
		// Given
		LocationService underTest = new LocationService();
		LocationRepository locationRepositoryValue = mockLocationRepository2();
		ReflectionTestUtils.setField(underTest, "locationRepository", locationRepositoryValue);

		// When
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		underTest.getLocationByRegion(region);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationRepository
	 */
	private static LocationRepository mockLocationRepository2() throws Throwable {
		LocationRepository locationRepositoryValue = mock(LocationRepository.class);
		LocationEntity findByRegionResult = null; // UTA: provided value
		when(locationRepositoryValue.findByRegion(nullable(RegionType.class))).thenReturn(findByRegionResult);
		return locationRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for isCorrectRegionInCurrentIndustry(RegionType)
	 *
	 * @see com.parasoft.demoapp.service.LocationService#isCorrectRegionInCurrentIndustry(RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testIsCorrectRegionInCurrentIndustry() throws Throwable {
		// Given
		LocationService underTest = new LocationService();

		// When
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		boolean result = underTest.isCorrectRegionInCurrentIndustry(region);

		// Then - assertions for result of method isCorrectRegionInCurrentIndustry(RegionType)
		assertTrue(result);

	}
}