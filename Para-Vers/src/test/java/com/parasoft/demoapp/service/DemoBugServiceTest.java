/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.model.global.preferences.DemoBugEntity;
import com.parasoft.demoapp.model.global.preferences.GlobalPreferencesEntity;
import com.parasoft.demoapp.model.industry.LocationEntity;
import com.parasoft.demoapp.model.industry.OrderEntity;
import com.parasoft.demoapp.model.industry.RegionType;
import com.parasoft.demoapp.repository.global.DemoBugRepository;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for DemoBugService
 *
 * @see com.parasoft.demoapp.service.DemoBugService
 * @author jakubiak
 */
public class DemoBugServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(Collection)
	 *
	 * @see com.parasoft.demoapp.service.DemoBugService#introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(Collection)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testIntroduceBugWithIncorrectLocationForApprovedOrdersIfNeeded2() throws Throwable {
		// Given
		DemoBugService underTest = new DemoBugService();

		// When
		Collection<OrderEntity> orders = null; // UTA: provided value
		underTest.introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(orders);

	}

	/**
	 * Parasoft Jtest UTA: Test for introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(Collection)
	 *
	 * @see com.parasoft.demoapp.service.DemoBugService#introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(Collection)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testIntroduceBugWithIncorrectLocationForApprovedOrdersIfNeeded3() throws Throwable {
		// Given
		DemoBugService underTest = new DemoBugService();

		// When
		Collection<OrderEntity> orders = new ArrayList<OrderEntity>(); // UTA: default value
		OrderEntity item = mock(OrderEntity.class);
		orders.add(item);
		OrderEntity item2 = mock(OrderEntity.class);
		orders.add(item2);
		underTest.introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(orders);

	}

	/**
	 * Parasoft Jtest UTA: Test for introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(Collection)
	 *
	 * @see com.parasoft.demoapp.service.DemoBugService#introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(Collection)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testIntroduceBugWithIncorrectLocationForApprovedOrdersIfNeeded4() throws Throwable {
		// Given
		DemoBugService underTest = new DemoBugService();
		GlobalPreferencesService globalPreferencesServiceValue = mockGlobalPreferencesService2();
		ReflectionTestUtils.setField(underTest, "globalPreferencesService", globalPreferencesServiceValue);
		LocationService locationServiceValue = mockLocationService();
		ReflectionTestUtils.setField(underTest, "locationService", locationServiceValue);

		// When
		Collection<OrderEntity> orders = new ArrayList<OrderEntity>(); // UTA: default value
		OrderEntity item2 = mock(OrderEntity.class);
		orders.add(item2);
		underTest.introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(orders);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesEntity
	 */
	private static GlobalPreferencesEntity mockGlobalPreferencesEntity2() throws Throwable {
		GlobalPreferencesEntity getCurrentGlobalPreferencesResult = mock(GlobalPreferencesEntity.class);
		Set<DemoBugEntity> getDemoBugsResult = new HashSet<DemoBugEntity>(); // UTA: default value
		DemoBugEntity item = mock(DemoBugEntity.class);
		getDemoBugsResult.add(item);
		doReturn(getDemoBugsResult).when(getCurrentGlobalPreferencesResult).getDemoBugs();
		return getCurrentGlobalPreferencesResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesService
	 */
	private static GlobalPreferencesService mockGlobalPreferencesService2() throws Throwable {
		GlobalPreferencesService globalPreferencesServiceValue = mock(GlobalPreferencesService.class);
		GlobalPreferencesEntity getCurrentGlobalPreferencesResult = mockGlobalPreferencesEntity2();
		when(globalPreferencesServiceValue.getCurrentGlobalPreferences()).thenReturn(getCurrentGlobalPreferencesResult);
		return globalPreferencesServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationEntity
	 */
	private static LocationEntity mockLocationEntity() throws Throwable {
		LocationEntity getLocationByRegionResult = mock(LocationEntity.class);
		String getLocationImageResult = "getLocationImageResult"; // UTA: default value
		when(getLocationByRegionResult.getLocationImage()).thenReturn(getLocationImageResult);

		String getLocationInfoResult = "getLocationInfoResult"; // UTA: default value
		when(getLocationByRegionResult.getLocationInfo()).thenReturn(getLocationInfoResult);

		RegionType getRegionResult = RegionType.UNITED_STATES; // UTA: default value
		when(getLocationByRegionResult.getRegion()).thenReturn(getRegionResult);
		return getLocationByRegionResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationService
	 */
	private static LocationService mockLocationService() throws Throwable {
		LocationService locationServiceValue = mock(LocationService.class);
		LocationEntity getLocationByRegionResult = mockLocationEntity();
		when(locationServiceValue.getLocationByRegion(nullable(RegionType.class)))
				.thenReturn(getLocationByRegionResult);
		return locationServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for removeByGlobalPreferencesId(Long)
	 *
	 * @see com.parasoft.demoapp.service.DemoBugService#removeByGlobalPreferencesId(Long)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRemoveByGlobalPreferencesId() throws Throwable {
		// Given
		DemoBugService underTest = new DemoBugService();
		DemoBugRepository demoBugRepositoryValue = mock(DemoBugRepository.class);
		ReflectionTestUtils.setField(underTest, "demoBugRepository", demoBugRepositoryValue);

		// When
		Long id = 0L; // UTA: default value
		underTest.removeByGlobalPreferencesId(id);

	}
}