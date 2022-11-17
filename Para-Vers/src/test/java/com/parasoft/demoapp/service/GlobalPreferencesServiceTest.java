/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.defaultdata.ClearEntrance;
import com.parasoft.demoapp.defaultdata.ResetEntrance;
import com.parasoft.demoapp.dto.GlobalPreferencesDTO;
import com.parasoft.demoapp.exception.GlobalPreferencesMoreThanOneException;
import com.parasoft.demoapp.exception.GlobalPreferencesNotFoundException;
import com.parasoft.demoapp.model.global.preferences.DataAccessMode;
import com.parasoft.demoapp.model.global.preferences.DemoBugEntity;
import com.parasoft.demoapp.model.global.preferences.DemoBugsType;
import com.parasoft.demoapp.model.global.preferences.GlobalPreferencesEntity;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import com.parasoft.demoapp.model.global.preferences.RestEndpointEntity;
import com.parasoft.demoapp.repository.global.GlobalPreferencesRepository;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for GlobalPreferencesService
 *
 * @see com.parasoft.demoapp.service.GlobalPreferencesService
 * @author jakubiak
 */
public class GlobalPreferencesServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for addNewGlobalPreferences(DataAccessMode, String, Set, Boolean, Boolean, String, String, String)
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#addNewGlobalPreferences(DataAccessMode, String, Set, Boolean, Boolean, String, String, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testAddNewGlobalPreferences() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
		ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

		// When
		DataAccessMode dataAccessMode = DataAccessMode.JDBC; // UTA: default value
		String soapEndPoint = "soapEndPoint"; // UTA: default value
		Set<RestEndpointEntity> restEndpoints = new HashSet<RestEndpointEntity>(); // UTA: default value
		RestEndpointEntity item = mock(RestEndpointEntity.class);
		restEndpoints.add(item);
		IndustryType industryType = IndustryType.DEFENSE; // UTA: default value
		Set<DemoBugEntity> demoBugs = new HashSet<DemoBugEntity>(); // UTA: default value
		Boolean advertisingEnabled = false; // UTA: default value
		Boolean useParasoftJDBCProxy = false; // UTA: default value
		String parasoftVirtualizeServerUrl = "parasoftVirtualizeServerUrl"; // UTA: default value
		String parasoftVirtualizeServerPath = "parasoftVirtualizeServerPath"; // UTA: default value
		String parasoftVirtualizeGroupId = "parasoftVirtualizeGroupId"; // UTA: default value
		GlobalPreferencesEntity result = underTest.addNewGlobalPreferences(dataAccessMode, soapEndPoint, restEndpoints,
				industryType, demoBugs, advertisingEnabled, useParasoftJDBCProxy, parasoftVirtualizeServerUrl,
				parasoftVirtualizeServerPath, parasoftVirtualizeGroupId);

		// Then - assertions for result of method addNewGlobalPreferences(DataAccessMode, String, Set, IndustryType, Set, Boolean, Boolean, String, String, String)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for addNewGlobalPreferences(DataAccessMode, String, Set, Boolean, Boolean, String, String, String)
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#addNewGlobalPreferences(DataAccessMode, String, Set, Boolean, Boolean, String, String, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testAddNewGlobalPreferences2() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
		ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

		// When
		DataAccessMode dataAccessMode = DataAccessMode.JDBC; // UTA: default value
		String soapEndPoint = "soapEndPoint"; // UTA: default value
		Set<RestEndpointEntity> restEndpoints = new HashSet<RestEndpointEntity>(); // UTA: default value
		RestEndpointEntity item = mock(RestEndpointEntity.class);
		restEndpoints.add(item);
		IndustryType industryType = IndustryType.DEFENSE; // UTA: default value
		Set<DemoBugEntity> demoBugs = new HashSet<DemoBugEntity>(); // UTA: default value
		DemoBugEntity item2 = mock(DemoBugEntity.class);
		demoBugs.add(item2);
		Boolean advertisingEnabled = false; // UTA: default value
		Boolean useParasoftJDBCProxy = false; // UTA: default value
		String parasoftVirtualizeServerUrl = "parasoftVirtualizeServerUrl"; // UTA: default value
		String parasoftVirtualizeServerPath = "parasoftVirtualizeServerPath"; // UTA: default value
		String parasoftVirtualizeGroupId = "parasoftVirtualizeGroupId"; // UTA: default value
		GlobalPreferencesEntity result = underTest.addNewGlobalPreferences(dataAccessMode, soapEndPoint, restEndpoints,
				industryType, demoBugs, advertisingEnabled, useParasoftJDBCProxy, parasoftVirtualizeServerUrl,
				parasoftVirtualizeServerPath, parasoftVirtualizeGroupId);

		// Then - assertions for result of method addNewGlobalPreferences(DataAccessMode, String, Set, IndustryType, Set, Boolean, Boolean, String, String, String)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for addNewGlobalPreferences(DataAccessMode, String, Set, Boolean, Boolean, String, String, String)
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#addNewGlobalPreferences(DataAccessMode, String, Set, Boolean, Boolean, String, String, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testAddNewGlobalPreferences3() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
		ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

		// When
		DataAccessMode dataAccessMode = DataAccessMode.JDBC; // UTA: default value
		String soapEndPoint = "soapEndPoint"; // UTA: default value
		Set<RestEndpointEntity> restEndpoints = new HashSet<RestEndpointEntity>(); // UTA: default value
		RestEndpointEntity item = mock(RestEndpointEntity.class);
		restEndpoints.add(item);
		IndustryType industryType = IndustryType.DEFENSE; // UTA: default value
		Set<DemoBugEntity> demoBugs = null; // UTA: provided value
		Boolean advertisingEnabled = false; // UTA: default value
		Boolean useParasoftJDBCProxy = false; // UTA: default value
		String parasoftVirtualizeServerUrl = "parasoftVirtualizeServerUrl"; // UTA: default value
		String parasoftVirtualizeServerPath = "parasoftVirtualizeServerPath"; // UTA: default value
		String parasoftVirtualizeGroupId = "parasoftVirtualizeGroupId"; // UTA: default value
		GlobalPreferencesEntity result = underTest.addNewGlobalPreferences(dataAccessMode, soapEndPoint, restEndpoints,
				industryType, demoBugs, advertisingEnabled, useParasoftJDBCProxy, parasoftVirtualizeServerUrl,
				parasoftVirtualizeServerPath, parasoftVirtualizeGroupId);

		// Then - assertions for result of method addNewGlobalPreferences(DataAccessMode, String, Set, IndustryType, Set, Boolean, Boolean, String, String, String)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for clearCurrentIndustryDatabase()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#clearCurrentIndustryDatabase()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testClearCurrentIndustryDatabase() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		ClearEntrance clearEntranceValue = mock(ClearEntrance.class);
		ReflectionTestUtils.setField(underTest, "clearEntrance", clearEntranceValue);
		ImageService imageServiceValue = mock(ImageService.class);
		ReflectionTestUtils.setField(underTest, "imageService", imageServiceValue);

		// When
		underTest.clearCurrentIndustryDatabase();

	}

	/**
	 * Parasoft Jtest UTA: Test for getCurrentGlobalPreferences()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#getCurrentGlobalPreferences()
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = GlobalPreferencesNotFoundException.class)
	public void testGetCurrentGlobalPreferences() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mockGlobalPreferencesRepository();
		ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

		// When
		underTest.getCurrentGlobalPreferences();

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesRepository
	 */
	private static GlobalPreferencesRepository mockGlobalPreferencesRepository() throws Throwable {
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
		List<GlobalPreferencesEntity> findAllResult = new ArrayList<GlobalPreferencesEntity>(); // UTA: default value
		doReturn(findAllResult).when(globalPreferencesRepositoryValue).findAll();
		return globalPreferencesRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getCurrentGlobalPreferences()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#getCurrentGlobalPreferences()
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = GlobalPreferencesMoreThanOneException.class)
	public void testGetCurrentGlobalPreferences2() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mockGlobalPreferencesRepository2();
		ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

		// When
		underTest.getCurrentGlobalPreferences();

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesRepository
	 */
	private static GlobalPreferencesRepository mockGlobalPreferencesRepository2() throws Throwable {
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
		List<GlobalPreferencesEntity> findAllResult = new ArrayList<GlobalPreferencesEntity>(); // UTA: default value
		GlobalPreferencesEntity item = mock(GlobalPreferencesEntity.class);
		findAllResult.add(item);
		GlobalPreferencesEntity item2 = mock(GlobalPreferencesEntity.class);
		findAllResult.add(item2);
		GlobalPreferencesEntity item3 = mock(GlobalPreferencesEntity.class);
		findAllResult.add(item3);
		doReturn(findAllResult).when(globalPreferencesRepositoryValue).findAll();
		return globalPreferencesRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getCurrentIndustry()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#getCurrentIndustry()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetCurrentIndustry() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mockGlobalPreferencesRepository3();
		ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

		// When
		IndustryType result = underTest.getCurrentIndustry();

		// Then - assertions for result of method getCurrentIndustry()
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesRepository
	 */
	private static GlobalPreferencesRepository mockGlobalPreferencesRepository3() throws Throwable {
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
		List<GlobalPreferencesEntity> findAllResult = new ArrayList<GlobalPreferencesEntity>(); // UTA: default value
		GlobalPreferencesEntity item = mock(GlobalPreferencesEntity.class);
		findAllResult.add(item);
		doReturn(findAllResult).when(globalPreferencesRepositoryValue).findAll();
		return globalPreferencesRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getCurrentIndustry()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#getCurrentIndustry()
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = GlobalPreferencesNotFoundException.class)
	public void testGetCurrentIndustry2() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mockGlobalPreferencesRepository4();
		ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

		// When
		underTest.getCurrentIndustry();

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesRepository
	 */
	private static GlobalPreferencesRepository mockGlobalPreferencesRepository4() throws Throwable {
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
		List<GlobalPreferencesEntity> findAllResult = new ArrayList<GlobalPreferencesEntity>(); // UTA: default value
		doReturn(findAllResult).when(globalPreferencesRepositoryValue).findAll();
		return globalPreferencesRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getCurrentIndustry()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#getCurrentIndustry()
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = GlobalPreferencesMoreThanOneException.class)
	public void testGetCurrentIndustry3() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mockGlobalPreferencesRepository5();
		ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

		// When
		underTest.getCurrentIndustry();

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesRepository
	 */
	private static GlobalPreferencesRepository mockGlobalPreferencesRepository5() throws Throwable {
		GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
		List<GlobalPreferencesEntity> findAllResult = new ArrayList<GlobalPreferencesEntity>(); // UTA: default value
		GlobalPreferencesEntity item = mock(GlobalPreferencesEntity.class);
		findAllResult.add(item);
		GlobalPreferencesEntity item2 = mock(GlobalPreferencesEntity.class);
		findAllResult.add(item2);
		GlobalPreferencesEntity item3 = mock(GlobalPreferencesEntity.class);
		findAllResult.add(item3);
		doReturn(findAllResult).when(globalPreferencesRepositoryValue).findAll();
		return globalPreferencesRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getDefaultIndustry()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#getDefaultIndustry()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetDefaultIndustry() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		GlobalPreferencesDefaultSettingsService defaultGlobalPreferencesSettingsServiceValue = mock(
				GlobalPreferencesDefaultSettingsService.class);
		ReflectionTestUtils.setField(underTest, "defaultGlobalPreferencesSettingsService",
				defaultGlobalPreferencesSettingsServiceValue);

		// When
		IndustryType result = underTest.getDefaultIndustry();

		// Then - assertions for result of method getDefaultIndustry()
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for initializeDatabase()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#initializeDatabase()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testInitializeDatabase() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();

		// When
		underTest.initializeDatabase();

	}

	/**
	 * Parasoft Jtest UTA: Test for resetAllIndustriesDatabase()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#resetAllIndustriesDatabase()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testResetAllIndustriesDatabase() throws Throwable {
		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();
		ImageService imageServiceValue = mock(ImageService.class);
		ReflectionTestUtils.setField(underTest, "imageService", imageServiceValue);
		ResetEntrance resetEntranceValue = mock(ResetEntrance.class);
		ReflectionTestUtils.setField(underTest, "resetEntrance", resetEntranceValue);

		// When
		underTest.resetAllIndustriesDatabase();

	}

	/**
	 * Parasoft Jtest UTA: Test for shutdownJMSService()
	 *
	 * @see com.parasoft.demoapp.service.GlobalPreferencesService#shutdownJMSService()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testShutdownJMSService() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		GlobalPreferencesService underTest = new GlobalPreferencesService();

		// When
		underTest.shutdownJMSService();

	}

}