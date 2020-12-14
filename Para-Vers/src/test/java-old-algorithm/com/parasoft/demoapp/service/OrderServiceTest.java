package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.industry.OrderEntity;
import com.parasoft.demoapp.repository.industry.OrderRepository;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for OrderService
 *
 * @see OrderService
 * @author jakubiak
 */
public class OrderServiceTest
{
    /**
     * Parasoft Jtest UTA: Test for getAllOrders(Long, String)
     *
     * @author jakubiak
     * @see OrderService#getAllOrders(Long, String)
     */
    @Test
    public void testGetAllOrders() throws Throwable {
        // Given
        OrderService underTest = new OrderService();
        OrderRepository orderRepositoryValue = mockOrderRepository();
        ReflectionTestUtils.setField(underTest, "orderRepository", orderRepositoryValue);

        // When
        Long userId = 0L; // UTA: default value
        String userRoleName = ""; // UTA: default value
        List<OrderEntity> result = underTest.getAllOrders(userId, userRoleName);

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.contains(null));
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderRepository
     */
    private static OrderRepository mockOrderRepository() throws Throwable {
        OrderRepository orderRepositoryValue = mock(OrderRepository.class);
        List<OrderEntity> findAllResult = new ArrayList<OrderEntity>(); // UTA: default value
        OrderEntity item = mock(OrderEntity.class);
        findAllResult.add(item);
        doReturn(findAllResult).when(orderRepositoryValue).findAll();

        List<OrderEntity> findAllByUserIdResult = new ArrayList<OrderEntity>(); // UTA: default value
        OrderEntity item2 = mock(OrderEntity.class);
        findAllByUserIdResult.add(item2);
        doReturn(findAllByUserIdResult).when(orderRepositoryValue).findAllByUserId(nullable(Long.class));
        return orderRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getAllOrders(Long, String, Pageable)
     *
     * @author jakubiak
     * @see OrderService#getAllOrders(Long, String, Pageable)
     */
    @Test
    public void testGetAllOrders2() throws Throwable {
        // Given
        OrderService underTest = new OrderService();
        OrderRepository orderRepositoryValue = mockOrderRepository2();
        ReflectionTestUtils.setField(underTest, "orderRepository", orderRepositoryValue);

        // When
        Long userId = 0L; // UTA: default value
        String userRoleName = ""; // UTA: default value
        Pageable pageable = mockPageable();
        Page<OrderEntity> result = underTest.getAllOrders(userId, userRoleName, pageable);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Page
     */
    private static Page<OrderEntity> mockPage() throws Throwable {
        Page<OrderEntity> findAllResult = mock(Page.class);
        return findAllResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Page
     */
    private static Page<OrderEntity> mockPage2() throws Throwable {
        Page<OrderEntity> findAllByUserIdResult = mock(Page.class);
        return findAllByUserIdResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderRepository
     */
    private static OrderRepository mockOrderRepository2() throws Throwable {
        OrderRepository orderRepositoryValue = mock(OrderRepository.class);
        Page<OrderEntity> findAllResult = mockPage();
        doReturn(findAllResult).when(orderRepositoryValue).findAll(nullable(Pageable.class));

        Page<OrderEntity> findAllByUserIdResult = mockPage2();
        doReturn(findAllByUserIdResult).when(orderRepositoryValue).findAllByUserId(nullable(Long.class), nullable(Pageable.class));
        return orderRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Pageable
     */
    private static Pageable mockPageable() throws Throwable {
        Pageable pageable = mock(Pageable.class);
        Pageable optionalValue = mock(Pageable.class);
        Optional<Pageable> toOptionalResult = Optional.of(optionalValue);
        doReturn(toOptionalResult).when(pageable).toOptional();
        return pageable;
    }

    /**
     * Parasoft Jtest UTA: Test for getOrderByOrderNumber(String)
     *
     * @author jakubiak
     * @see OrderService#getOrderByOrderNumber(String)
     */
    @Test
    public void testGetOrderByOrderNumber() throws Throwable {
        // Given
        OrderService underTest = new OrderService();
        OrderRepository orderRepositoryValue = mockOrderRepository3();
        ReflectionTestUtils.setField(underTest, "orderRepository", orderRepositoryValue);

        // When
        String orderNumber = ""; // UTA: default value
        OrderEntity result = underTest.getOrderByOrderNumber(orderNumber);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderRepository
     */
    private static OrderRepository mockOrderRepository3() throws Throwable {
        OrderRepository orderRepositoryValue = mock(OrderRepository.class);
        OrderEntity findOrderByOrderNumberResult = mock(OrderEntity.class);
        when(orderRepositoryValue.findOrderByOrderNumber(nullable(String.class))).thenReturn(findOrderByOrderNumberResult);
        return orderRepositoryValue;
    }
}