package com.parasoft.demoapp.service;


import com.parasoft.demoapp.defaultdata.ClearEntrance;
import com.parasoft.demoapp.model.global.preferences.GlobalPreferencesEntity;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import com.parasoft.demoapp.repository.global.GlobalPreferencesRepository;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for GlobalPreferencesService
 *
 * @see GlobalPreferencesService
 * @author jakubiak
 */
public class GlobalPreferencesServiceTest
{
    /**
     * Parasoft Jtest UTA: Test for clearCurrentIndustryDatabase()
     *
     * @author jakubiak
     * @see GlobalPreferencesService#clearCurrentIndustryDatabase()
     */
    @Test
    public void testClearCurrentIndustryDatabase() throws Throwable {
        // Given
        GlobalPreferencesService underTest = new GlobalPreferencesService();
        ClearEntrance clearEntranceValue = mockClearEntrance();
        ReflectionTestUtils.setField(underTest, "clearEntrance", clearEntranceValue);
        ImageService imageServiceValue = mockImageService();
        ReflectionTestUtils.setField(underTest, "imageService", imageServiceValue);

        // When
        underTest.clearCurrentIndustryDatabase();

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ClearEntrance
     */
    private static ClearEntrance mockClearEntrance() throws Throwable {
        ClearEntrance clearEntranceValue = mock(ClearEntrance.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(clearEntranceValue).run();
        return clearEntranceValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ImageService
     */
    private static ImageService mockImageService() throws Throwable {
        ImageService imageServiceValue = mock(ImageService.class);
        boolean removeSpecificIndustryUploadedImagesResult = false; // UTA: default value
        when(imageServiceValue.removeSpecificIndustryUploadedImages(nullable(IndustryType.class))).thenReturn(removeSpecificIndustryUploadedImagesResult);
        return imageServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getCurrentGlobalPreferences()
     *
     * @author jakubiak
     * @see GlobalPreferencesService#getCurrentGlobalPreferences()
     */
    @Test
    public void testGetCurrentGlobalPreferences() throws Throwable {
        // Given
        GlobalPreferencesService underTest = new GlobalPreferencesService();
        GlobalPreferencesRepository globalPreferencesRepositoryValue = mockGlobalPreferencesRepository();
        ReflectionTestUtils.setField(underTest, "globalPreferencesRepository", globalPreferencesRepositoryValue);

        // When
        GlobalPreferencesEntity result = underTest.getCurrentGlobalPreferences();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesRepository
     */
    private static GlobalPreferencesRepository mockGlobalPreferencesRepository() throws Throwable {
        GlobalPreferencesRepository globalPreferencesRepositoryValue = mock(GlobalPreferencesRepository.class);
        List<GlobalPreferencesEntity> findAllResult = new ArrayList<GlobalPreferencesEntity>(); // UTA: default value
        GlobalPreferencesEntity item = mock(GlobalPreferencesEntity.class);
        findAllResult.add(item);
        doReturn(findAllResult).when(globalPreferencesRepositoryValue).findAll();
        return globalPreferencesRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getDefaultIndustry()
     *
     * @author jakubiak
     * @see GlobalPreferencesService#getDefaultIndustry()
     */
    @Test
    public void testGetDefaultIndustry() throws Throwable {
        // Given
        GlobalPreferencesService underTest = new GlobalPreferencesService();
        GlobalPreferencesDefaultSettingsService defaultGlobalPreferencesSettingsServiceValue = mockGlobalPreferencesDefaultSettingsService();
        ReflectionTestUtils.setField(underTest, "defaultGlobalPreferencesSettingsService", defaultGlobalPreferencesSettingsServiceValue);

        // When
        IndustryType result = underTest.getDefaultIndustry();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesDefaultSettingsService
     */
    private static GlobalPreferencesDefaultSettingsService mockGlobalPreferencesDefaultSettingsService() throws Throwable {
        GlobalPreferencesDefaultSettingsService defaultGlobalPreferencesSettingsServiceValue = mock(GlobalPreferencesDefaultSettingsService.class);
        IndustryType defaultIndustryResult = IndustryType.AEROSPACE; // UTA: default value
        when(defaultGlobalPreferencesSettingsServiceValue.defaultIndustry()).thenReturn(defaultIndustryResult);
        return defaultGlobalPreferencesSettingsServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for initializeDatabase()
     *
     * @author jakubiak
     * @see GlobalPreferencesService#initializeDatabase()
     */
    @Test
    public void testInitializeDatabase() throws Throwable {
        // Given
        GlobalPreferencesService underTest = new GlobalPreferencesService();

        // When
        underTest.initializeDatabase();

    }

    /**
     * Parasoft Jtest UTA: Test for shutdownJMSService()
     *
     * @author jakubiak
     * @see GlobalPreferencesService#shutdownJMSService()
     */
    @Test
    public void testShutdownJMSService() throws Throwable {
        // Given
        GlobalPreferencesService underTest = new GlobalPreferencesService();

        // When
        underTest.shutdownJMSService();

    }
}