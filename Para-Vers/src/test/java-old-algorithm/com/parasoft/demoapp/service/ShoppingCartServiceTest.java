package com.parasoft.demoapp.service;


import com.parasoft.demoapp.repository.industry.ShoppingCartRepository;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ShoppingCartService
 *
 * @see ShoppingCartService
 * @author jakubiak
 */
public class ShoppingCartServiceTest
{
    /**
     * Parasoft Jtest UTA: Test for clearShoppingCart(Long)
     *
     * @author jakubiak
     * @see ShoppingCartService#clearShoppingCart(Long)
     */
    @Test
    public void testClearShoppingCart() throws Throwable {
        // Given
        ShoppingCartService underTest = new ShoppingCartService();
        ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository();
        ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

        // When
        Long userId = 0L; // UTA: default value
        underTest.clearShoppingCart(userId);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
     */
    private static ShoppingCartRepository mockShoppingCartRepository() throws Throwable {
        ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Long userId = (Long) invocation.getArguments()[0];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(shoppingCartRepositoryValue).deleteByUserId(nullable(Long.class));

        boolean existsByUserIdResult = false; // UTA: default value
        when(shoppingCartRepositoryValue.existsByUserId(nullable(Long.class))).thenReturn(existsByUserIdResult);
        return shoppingCartRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for removeCartItemByUserIdAndItemId(Long, Long)
     *
     * @author jakubiak
     * @see ShoppingCartService#removeCartItemByUserIdAndItemId(Long, Long)
     */
    @Test
    public void testRemoveCartItemByUserIdAndItemId() throws Throwable {
        // Given
        ShoppingCartService underTest = new ShoppingCartService();
        ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository2();
        ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

        // When
        Long userId = 0L; // UTA: default value
        Long itemId = 0L; // UTA: default value
        underTest.removeCartItemByUserIdAndItemId(userId, itemId);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
     */
    private static ShoppingCartRepository mockShoppingCartRepository2() throws Throwable {
        ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Long userId = (Long) invocation.getArguments()[0];
                Long itemId = (Long) invocation.getArguments()[1];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(shoppingCartRepositoryValue).deleteByUserIdAndItemId(nullable(Long.class), nullable(Long.class));

        boolean existsByItemIdResult = false; // UTA: default value
        when(shoppingCartRepositoryValue.existsByItemId(nullable(Long.class))).thenReturn(existsByItemIdResult);
        return shoppingCartRepositoryValue;
    }
}