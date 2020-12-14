package com.parasoft.demoapp.controller;


import com.parasoft.demoapp.model.global.preferences.GlobalPreferencesEntity;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import com.parasoft.demoapp.service.GlobalPreferencesService;
import com.parasoft.demoapp.service.ParasoftJDBCProxyService;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for GlobalPreferencesController
 *
 * @author jakubiak
 * @see GlobalPreferencesController
 */
public class GlobalPreferencesControllerTest {
    /**
     * Parasoft Jtest UTA: Test for clearCurrentIndustryDatabase()
     *
     * @author jakubiak
     * @see GlobalPreferencesController#clearCurrentIndustryDatabase()
     */
    @Test
    public void testClearCurrentIndustryDatabase() throws Throwable {
        // Given
        GlobalPreferencesController underTest = new GlobalPreferencesController();
        GlobalPreferencesService globalPreferencesServiceValue = mockGlobalPreferencesService();
        ReflectionTestUtils.setField(underTest, "globalPreferencesService", globalPreferencesServiceValue);

        // When
        ResponseResult<Void> result = underTest.clearCurrentIndustryDatabase();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesService
     */
    private static GlobalPreferencesService mockGlobalPreferencesService() throws Throwable {
        GlobalPreferencesService globalPreferencesServiceValue = mock(GlobalPreferencesService.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(globalPreferencesServiceValue).clearCurrentIndustryDatabase();
        return globalPreferencesServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getCurrentPreferences()
     *
     * @author jakubiak
     * @see GlobalPreferencesController#getCurrentPreferences()
     */
    @Test
    public void testGetCurrentPreferences() throws Throwable {
        // Given
        GlobalPreferencesController underTest = new GlobalPreferencesController();
        GlobalPreferencesService globalPreferencesServiceValue = mockGlobalPreferencesService2();
        ReflectionTestUtils.setField(underTest, "globalPreferencesService", globalPreferencesServiceValue);

        // When
        ResponseResult<GlobalPreferencesEntity> result = underTest.getCurrentPreferences();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesService
     */
    private static GlobalPreferencesService mockGlobalPreferencesService2() throws Throwable {
        GlobalPreferencesService globalPreferencesServiceValue = mock(GlobalPreferencesService.class);
        GlobalPreferencesEntity getCurrentGlobalPreferencesResult = mock(GlobalPreferencesEntity.class);
        when(globalPreferencesServiceValue.getCurrentGlobalPreferences()).thenReturn(getCurrentGlobalPreferencesResult);
        return globalPreferencesServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for resetAllIndustriesDatabase()
     *
     * @author jakubiak
     * @see GlobalPreferencesController#resetAllIndustriesDatabase()
     */
    @Test
    public void testResetAllIndustriesDatabase() throws Throwable {
        // Given
        GlobalPreferencesController underTest = new GlobalPreferencesController();
        GlobalPreferencesService globalPreferencesServiceValue = mockGlobalPreferencesService3();
        ReflectionTestUtils.setField(underTest, "globalPreferencesService", globalPreferencesServiceValue);

        // When
        ResponseResult<Void> result = underTest.resetAllIndustriesDatabase();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of GlobalPreferencesService
     */
    private static GlobalPreferencesService mockGlobalPreferencesService3() throws Throwable {
        GlobalPreferencesService globalPreferencesServiceValue = mock(GlobalPreferencesService.class);
        IndustryType getCurrentIndustryResult = IndustryType.AEROSPACE; // UTA: default value
        when(globalPreferencesServiceValue.getCurrentIndustry()).thenReturn(getCurrentIndustryResult);

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(globalPreferencesServiceValue).resetAllIndustriesDatabase();
        return globalPreferencesServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for validateParasoftVirtualizeServerUrl(String)
     *
     * @author jakubiak
     * @see GlobalPreferencesController#validateParasoftVirtualizeServerUrl(String)
     */
    @Test
    public void testValidateParasoftVirtualizeServerUrl() throws Throwable {
        // Given
        GlobalPreferencesController underTest = new GlobalPreferencesController();
        ParasoftJDBCProxyService parasoftJDBCProxyServiceValue = mockParasoftJDBCProxyService();
        ReflectionTestUtils.setField(underTest, "parasoftJDBCProxyService", parasoftJDBCProxyServiceValue);

        // When
        String url = ""; // UTA: default value
        ResponseResult<Void> result = underTest.validateParasoftVirtualizeServerUrl(url);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ParasoftJDBCProxyService
     */
    private static ParasoftJDBCProxyService mockParasoftJDBCProxyService() throws Throwable {
        ParasoftJDBCProxyService parasoftJDBCProxyServiceValue = mock(ParasoftJDBCProxyService.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                String virtualizeServerUrl = (String) invocation.getArguments()[0];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(parasoftJDBCProxyServiceValue).validateVirtualizeServerUrl(nullable(String.class));
        return parasoftJDBCProxyServiceValue;
    }
}