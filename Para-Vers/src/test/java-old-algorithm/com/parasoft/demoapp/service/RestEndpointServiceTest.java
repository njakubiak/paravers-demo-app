package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.global.preferences.RestEndpointEntity;
import com.parasoft.demoapp.repository.global.RestEndpointRepository;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for RestEndpointService
 *
 * @author jakubiak
 * @see RestEndpointService
 */
public class RestEndpointServiceTest {
    /**
     * Parasoft Jtest UTA: Test for getAllEndpoints()
     *
     * @author jakubiak
     * @see RestEndpointService#getAllEndpoints()
     */
    @Test
    public void testGetAllEndpoints() throws Throwable {
        // Given
        RestEndpointService underTest = new RestEndpointService();
        RestEndpointRepository restEndPointRepositoryValue = mockRestEndpointRepository();
        ReflectionTestUtils.setField(underTest, "restEndPointRepository", restEndPointRepositoryValue);

        // When
        List<RestEndpointEntity> result = underTest.getAllEndpoints();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.contains(null));
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of RestEndpointRepository
     */
    private static RestEndpointRepository mockRestEndpointRepository() throws Throwable {
        RestEndpointRepository restEndPointRepositoryValue = mock(RestEndpointRepository.class);
        List<RestEndpointEntity> findAllResult = new ArrayList<RestEndpointEntity>(); // UTA: default value
        RestEndpointEntity item = mock(RestEndpointEntity.class);
        findAllResult.add(item);
        doReturn(findAllResult).when(restEndPointRepositoryValue).findAll();
        return restEndPointRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for refreshEndpoint()
     *
     * @author jakubiak
     * @see RestEndpointService#refreshEndpoint()
     */
    @Test
    public void testRefreshEndpoint() throws Throwable {
        // Given
        RestEndpointService underTest = new RestEndpointService();
        ApplicationEventPublisher publisherValue = mockApplicationEventPublisher();
        ReflectionTestUtils.setField(underTest, "publisher", publisherValue);

        // When
        underTest.refreshEndpoint();

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ApplicationEventPublisher
     */
    private static ApplicationEventPublisher mockApplicationEventPublisher() throws Throwable {
        ApplicationEventPublisher publisherValue = mock(ApplicationEventPublisher.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                ApplicationEvent event = (ApplicationEvent) invocation.getArguments()[0];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(publisherValue).publishEvent(nullable(ApplicationEvent.class));
        return publisherValue;
    }

    /**
     * Parasoft Jtest UTA: Test for removeAllEndpoints()
     *
     * @author jakubiak
     * @see RestEndpointService#removeAllEndpoints()
     */
    @Test
    public void testRemoveAllEndpoints() throws Throwable {
        // Given
        RestEndpointService underTest = new RestEndpointService();
        RestEndpointRepository restEndPointRepositoryValue = mockRestEndpointRepository2();
        ReflectionTestUtils.setField(underTest, "restEndPointRepository", restEndPointRepositoryValue);

        // When
        underTest.removeAllEndpoints();

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of RestEndpointRepository
     */
    private static RestEndpointRepository mockRestEndpointRepository2() throws Throwable {
        RestEndpointRepository restEndPointRepositoryValue = mock(RestEndpointRepository.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(restEndPointRepositoryValue).deleteAll();
        return restEndPointRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for validateUrl(String, String)
     *
     * @author jakubiak
     * @see RestEndpointService#validateUrl(String, String)
     */
    @Test
    public void testValidateUrl() throws Throwable {
        // Given
        RestEndpointService underTest = new RestEndpointService();

        // When
        String urlStr = ""; // UTA: default value
        String exceptionMessage = ""; // UTA: default value
        underTest.validateUrl(urlStr, exceptionMessage);

    }
}