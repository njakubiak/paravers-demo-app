/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.model.global.preferences.RestEndpointEntity;
import com.parasoft.demoapp.repository.global.RestEndpointRepository;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.Test;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for RestEndpointService
 *
 * @see com.parasoft.demoapp.service.RestEndpointService
 * @author jakubiak
 */
public class RestEndpointServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for getAllEndpoints()
	 *
	 * @see com.parasoft.demoapp.service.RestEndpointService#getAllEndpoints()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetAllEndpoints() throws Throwable {
		// Given
		RestEndpointService underTest = new RestEndpointService();
		RestEndpointRepository restEndPointRepositoryValue = mock(RestEndpointRepository.class);
		ReflectionTestUtils.setField(underTest, "restEndPointRepository", restEndPointRepositoryValue);

		// When
		List<RestEndpointEntity> result = underTest.getAllEndpoints();

		// Then - assertions for result of method getAllEndpoints()
		assertNotNull(result);
		assertEquals(0, result.size());

	}

	/**
	 * Parasoft Jtest UTA: Test for refreshEndpoint()
	 *
	 * @see com.parasoft.demoapp.service.RestEndpointService#refreshEndpoint()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRefreshEndpoint() throws Throwable {
		// Given
		RestEndpointService underTest = new RestEndpointService();
		ApplicationEventPublisher publisherValue = mock(ApplicationEventPublisher.class);
		ReflectionTestUtils.setField(underTest, "publisher", publisherValue);
		RouteLocator routeLocatorValue = mock(RouteLocator.class);
		ReflectionTestUtils.setField(underTest, "routeLocator", routeLocatorValue);

		// When
		underTest.refreshEndpoint();

	}

	/**
	 * Parasoft Jtest UTA: Test for removeAllEndpoints()
	 *
	 * @see com.parasoft.demoapp.service.RestEndpointService#removeAllEndpoints()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRemoveAllEndpoints() throws Throwable {
		// Given
		RestEndpointService underTest = new RestEndpointService();
		RestEndpointRepository restEndPointRepositoryValue = mock(RestEndpointRepository.class);
		ReflectionTestUtils.setField(underTest, "restEndPointRepository", restEndPointRepositoryValue);

		// When
		underTest.removeAllEndpoints();

	}

	/**
	 * Parasoft Jtest UTA: Test for updateEndpoint(RestEndpointEntity)
	 *
	 * @see com.parasoft.demoapp.service.RestEndpointService#updateEndpoint(RestEndpointEntity)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testUpdateEndpoint() throws Throwable {
		// Given
		RestEndpointService underTest = new RestEndpointService();

		// When
		RestEndpointEntity restEndpointEntity = null; // UTA: provided value
		RestEndpointEntity result = underTest.updateEndpoint(restEndpointEntity);

		// Then - assertions for result of method updateEndpoint(RestEndpointEntity)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for updateEndpoint(RestEndpointEntity)
	 *
	 * @see com.parasoft.demoapp.service.RestEndpointService#updateEndpoint(RestEndpointEntity)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testUpdateEndpoint3() throws Throwable {
		// Given
		RestEndpointService underTest = new RestEndpointService();

		// When
		RestEndpointEntity restEndpointEntity = mockRestEndpointEntity2();
		underTest.updateEndpoint(restEndpointEntity);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of RestEndpointEntity
	 */
	private static RestEndpointEntity mockRestEndpointEntity2() throws Throwable {
		RestEndpointEntity restEndpointEntity = mock(RestEndpointEntity.class);
		Long getIdResult = null; // UTA: provided value
		when(restEndpointEntity.getId()).thenReturn(getIdResult);
		return restEndpointEntity;
	}

}