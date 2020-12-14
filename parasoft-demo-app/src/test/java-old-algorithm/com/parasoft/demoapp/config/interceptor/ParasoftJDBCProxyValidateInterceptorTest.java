package com.parasoft.demoapp.config.interceptor;


import com.parasoft.demoapp.config.datasource.IndustryDataSourceConfig;
import com.parasoft.demoapp.service.ParasoftJDBCProxyService;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ParasoftJDBCProxyValidateInterceptor
 *
 * @author jakubiak
 * @see ParasoftJDBCProxyValidateInterceptor
 */
public class ParasoftJDBCProxyValidateInterceptorTest {
    /**
     * Parasoft Jtest UTA: Test for preHandle(HttpServletRequest, HttpServletResponse, Object)
     *
     * @author jakubiak
     * @see ParasoftJDBCProxyValidateInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)
     */
    @Test
    public void testPreHandle() throws Throwable {
        // Given
        ParasoftJDBCProxyValidateInterceptor underTest = new ParasoftJDBCProxyValidateInterceptor();
        IndustryDataSourceConfig industryDataSourceConfigValue = mockIndustryDataSourceConfig();
        ReflectionTestUtils.setField(underTest, "industryDataSourceConfig", industryDataSourceConfigValue);
        ParasoftJDBCProxyService parasoftJDBCProxyServiceValue = mockParasoftJDBCProxyService();
        ReflectionTestUtils.setField(underTest, "parasoftJDBCProxyService", parasoftJDBCProxyServiceValue);

        // When
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mockHttpServletResponse();
        Object handler = new Object(); // UTA: default value
        boolean result = underTest.preHandle(request, response, handler);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of IndustryDataSourceConfig
     */
    private static IndustryDataSourceConfig mockIndustryDataSourceConfig() throws Throwable {
        IndustryDataSourceConfig industryDataSourceConfigValue = mock(IndustryDataSourceConfig.class);
        Map<Object, Object> getIndustryDataSourcesResult = new HashMap<Object, Object>(); // UTA: default value
        doReturn(getIndustryDataSourcesResult).when(industryDataSourceConfigValue).getIndustryDataSources();
        return industryDataSourceConfigValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ParasoftJDBCProxyService
     */
    private static ParasoftJDBCProxyService mockParasoftJDBCProxyService() throws Throwable {
        ParasoftJDBCProxyService parasoftJDBCProxyServiceValue = mock(ParasoftJDBCProxyService.class);
        String getProxyKeyOfCurrentIndustryResult = ""; // UTA: default value
        when(parasoftJDBCProxyServiceValue.getProxyKeyOfCurrentIndustry()).thenReturn(getProxyKeyOfCurrentIndustryResult);

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(parasoftJDBCProxyServiceValue).refreshParasoftJDBCProxyDataSource();

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                String virtualizeServerUrl = (String) invocation.getArguments()[0];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(parasoftJDBCProxyServiceValue).validateVirtualizeServerUrl(nullable(String.class));
        return parasoftJDBCProxyServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of HttpServletResponse
     */
    private static HttpServletResponse mockHttpServletResponse() throws Throwable {
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter getWriterResult = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(getWriterResult);
        return response;
    }

    /**
     * Parasoft Jtest UTA: Test for refreshParasoftJDBCProxyDataSourceSynchronized()
     *
     * @author jakubiak
     * @see ParasoftJDBCProxyValidateInterceptor#refreshParasoftJDBCProxyDataSourceSynchronized()
     */
    @Test
    public void testRefreshParasoftJDBCProxyDataSourceSynchronized() throws Throwable {
        // Given
        ParasoftJDBCProxyValidateInterceptor underTest = new ParasoftJDBCProxyValidateInterceptor();
        IndustryDataSourceConfig industryDataSourceConfigValue = mockIndustryDataSourceConfig2();
        ReflectionTestUtils.setField(underTest, "industryDataSourceConfig", industryDataSourceConfigValue);
        ParasoftJDBCProxyService parasoftJDBCProxyServiceValue = mockParasoftJDBCProxyService2();
        ReflectionTestUtils.setField(underTest, "parasoftJDBCProxyService", parasoftJDBCProxyServiceValue);

        // When
        underTest.refreshParasoftJDBCProxyDataSourceSynchronized();

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of IndustryDataSourceConfig
     */
    private static IndustryDataSourceConfig mockIndustryDataSourceConfig2() throws Throwable {
        IndustryDataSourceConfig industryDataSourceConfigValue = mock(IndustryDataSourceConfig.class);
        Map<Object, Object> getIndustryDataSourcesResult = new HashMap<Object, Object>(); // UTA: default value
        doReturn(getIndustryDataSourcesResult).when(industryDataSourceConfigValue).getIndustryDataSources();
        return industryDataSourceConfigValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ParasoftJDBCProxyService
     */
    private static ParasoftJDBCProxyService mockParasoftJDBCProxyService2() throws Throwable {
        ParasoftJDBCProxyService parasoftJDBCProxyServiceValue = mock(ParasoftJDBCProxyService.class);
        String getProxyKeyOfCurrentIndustryResult = ""; // UTA: default value
        when(parasoftJDBCProxyServiceValue.getProxyKeyOfCurrentIndustry()).thenReturn(getProxyKeyOfCurrentIndustryResult);

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(parasoftJDBCProxyServiceValue).refreshParasoftJDBCProxyDataSource();
        return parasoftJDBCProxyServiceValue;
    }
}