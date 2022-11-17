/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.exception.OrderNotFoundException;
import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.model.industry.CartItemEntity;
import com.parasoft.demoapp.model.industry.LocationEntity;
import com.parasoft.demoapp.model.industry.OrderEntity;
import com.parasoft.demoapp.model.industry.OrderItemEntity;
import com.parasoft.demoapp.model.industry.OrderStatus;
import com.parasoft.demoapp.model.industry.RegionType;
import com.parasoft.demoapp.repository.industry.OrderRepository;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for OrderService
 *
 * @see com.parasoft.demoapp.service.OrderService
 * @author jakubiak
 */
public class OrderServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for getAllOrders(Long, String)
	 *
	 * @see com.parasoft.demoapp.service.OrderService#getAllOrders(Long, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetAllOrders() throws Throwable {
		// Given
		OrderService underTest = new OrderService();
		OrderRepository orderRepositoryValue = mock(OrderRepository.class);
		ReflectionTestUtils.setField(underTest, "orderRepository", orderRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		String userRoleName = "userRoleName"; // UTA: default value
		List<OrderEntity> result = underTest.getAllOrders(userId, userRoleName);

		// Then - assertions for result of method getAllOrders(Long, String)
		assertNotNull(result);
		assertEquals(0, result.size());

	}

	/**
	 * Parasoft Jtest UTA: Test for getAllOrders(Long, String, Pageable)
	 *
	 * @see com.parasoft.demoapp.service.OrderService#getAllOrders(Long, String, Pageable)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetAllOrders2() throws Throwable {
		// Given
		OrderService underTest = new OrderService();
		OrderRepository orderRepositoryValue = mock(OrderRepository.class);
		ReflectionTestUtils.setField(underTest, "orderRepository", orderRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		String userRoleName = "userRoleName"; // UTA: default value
		Pageable pageable = mock(Pageable.class);
		Page<OrderEntity> result = underTest.getAllOrders(userId, userRoleName, pageable);

		// Then - assertions for result of method getAllOrders(Long, String, Pageable)
		assertNotNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for getOrderByOrderNumber(String)
	 *
	 * @see com.parasoft.demoapp.service.OrderService#getOrderByOrderNumber(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = OrderNotFoundException.class)
	public void testGetOrderByOrderNumber() throws Throwable {
		// Given
		OrderService underTest = new OrderService();
		OrderRepository orderRepositoryValue = mockOrderRepository();
		ReflectionTestUtils.setField(underTest, "orderRepository", orderRepositoryValue);

		// When
		String orderNumber = "orderNumber"; // UTA: default value
		underTest.getOrderByOrderNumber(orderNumber);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderRepository
	 */
	private static OrderRepository mockOrderRepository() throws Throwable {
		OrderRepository orderRepositoryValue = mock(OrderRepository.class);
		OrderEntity findOrderByOrderNumberResult = null; // UTA: provided value
		when(orderRepositoryValue.findOrderByOrderNumber(nullable(String.class)))
				.thenReturn(findOrderByOrderNumberResult);
		return orderRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for updateOrderByOrderNumber(String, String, OrderStatus, Boolean, Boolean, String, boolean)
	 *
	 * @see com.parasoft.demoapp.service.OrderService#updateOrderByOrderNumber(String, String, OrderStatus, Boolean, Boolean, String, boolean)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testUpdateOrderByOrderNumber() throws Throwable {
		// Given
		OrderService underTest = new OrderService();
		OrderRepository orderRepositoryValue = mockOrderRepository2();
		ReflectionTestUtils.setField(underTest, "orderRepository", orderRepositoryValue);

		// When
		String orderNumber = "orderNumber"; // UTA: default value
		String userRoleName = "userRoleName"; // UTA: default value
		OrderStatus newStatus = OrderStatus.SUBMITTED; // UTA: default value
		Boolean reviewedByPRCH = false; // UTA: default value
		Boolean reviewedByAPV = false; // UTA: default value
		String comments = "comments"; // UTA: default value
		boolean publicToMQ = false; // UTA: provided value
		OrderEntity result = underTest.updateOrderByOrderNumber(orderNumber, userRoleName, newStatus, reviewedByPRCH,
				reviewedByAPV, comments, publicToMQ);

		// Then - assertions for result of method updateOrderByOrderNumber(String, String, OrderStatus, Boolean, Boolean, String, boolean)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderEntity
	 */
	private static OrderEntity mockOrderEntity() throws Throwable {
		OrderEntity findOrderByOrderNumberResult = mock(OrderEntity.class);
		OrderEntity cloneResult = mock(OrderEntity.class);
		when(findOrderByOrderNumberResult.clone()).thenReturn(cloneResult);

		OrderStatus getStatusResult = OrderStatus.SUBMITTED; // UTA: default value
		when(findOrderByOrderNumberResult.getStatus()).thenReturn(getStatusResult);
		return findOrderByOrderNumberResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderRepository
	 */
	private static OrderRepository mockOrderRepository2() throws Throwable {
		OrderRepository orderRepositoryValue = mock(OrderRepository.class);
		OrderEntity findOrderByOrderNumberResult = mockOrderEntity();
		when(orderRepositoryValue.findOrderByOrderNumber(nullable(String.class)))
				.thenReturn(findOrderByOrderNumberResult);
		return orderRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for updateOrderByOrderNumberSynchronized(String, String, OrderStatus, Boolean, Boolean, String, boolean)
	 *
	 * @see com.parasoft.demoapp.service.OrderService#updateOrderByOrderNumberSynchronized(String, String, OrderStatus, Boolean, Boolean, String, boolean)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testUpdateOrderByOrderNumberSynchronized() throws Throwable {
		// Given
		OrderService underTest = new OrderService();
		OrderRepository orderRepositoryValue = mockOrderRepository4();
		ReflectionTestUtils.setField(underTest, "orderRepository", orderRepositoryValue);

		// When
		String orderNumber = "orderNumber"; // UTA: default value
		String userRoleName = "userRoleName"; // UTA: default value
		OrderStatus newStatus = OrderStatus.SUBMITTED; // UTA: default value
		Boolean reviewedByPRCH = false; // UTA: default value
		Boolean reviewedByAPV = false; // UTA: default value
		String comments = "comments"; // UTA: default value
		boolean publicToMQ = false; // UTA: provided value
		OrderEntity result = underTest.updateOrderByOrderNumberSynchronized(orderNumber, userRoleName, newStatus,
				reviewedByPRCH, reviewedByAPV, comments, publicToMQ);

		// Then - assertions for result of method updateOrderByOrderNumberSynchronized(String, String, OrderStatus, Boolean, Boolean, String, boolean)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderEntity
	 */
	private static OrderEntity mockOrderEntity3() throws Throwable {
		OrderEntity findOrderByOrderNumberResult = mock(OrderEntity.class);
		OrderEntity cloneResult = mock(OrderEntity.class);
		when(findOrderByOrderNumberResult.clone()).thenReturn(cloneResult);

		OrderStatus getStatusResult = OrderStatus.SUBMITTED; // UTA: default value
		when(findOrderByOrderNumberResult.getStatus()).thenReturn(getStatusResult);
		return findOrderByOrderNumberResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderRepository
	 */
	private static OrderRepository mockOrderRepository4() throws Throwable {
		OrderRepository orderRepositoryValue = mock(OrderRepository.class);
		OrderEntity findOrderByOrderNumberResult = mockOrderEntity3();
		when(orderRepositoryValue.findOrderByOrderNumber(nullable(String.class)))
				.thenReturn(findOrderByOrderNumberResult);
		return orderRepositoryValue;
	}

}