/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.model.industry.CartItemEntity;
import com.parasoft.demoapp.model.industry.ItemEntity;
import com.parasoft.demoapp.repository.industry.ShoppingCartRepository;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for ShoppingCartService
 *
 * @see com.parasoft.demoapp.service.ShoppingCartService
 * @author jakubiak
 */
public class ShoppingCartServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for addCartItemInShoppingCart(Long, Long, Integer)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#addCartItemInShoppingCart(Long, Long, Integer)
	 * @author jakubiak
	 */
	@Test
	public void testAddCartItemInShoppingCart() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ItemService itemServiceValue = mockItemService();
		ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L;
		Long itemId = 0L;
		Integer quantity = 1;
		CartItemEntity result = underTest.addCartItemInShoppingCart(userId, itemId, quantity);

		// Then - assertions for result of method addCartItemInShoppingCart(Long, Long, Integer)
		assertEquals(0, result.getRealInStock().intValue());
		assertEquals(1, result.getQuantity().intValue());

		// Then
		// assertNotNull(result);
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemEntity
	 */
	private static ItemEntity mockItemEntity() throws Throwable {
		ItemEntity getItemByIdResult = mock(ItemEntity.class);
		Integer getInStockResult = 1; // UTA: provided value
		when(getItemByIdResult.getInStock()).thenReturn(getInStockResult);
		return getItemByIdResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemService
	 */
	private static ItemService mockItemService() throws Throwable {
		ItemService itemServiceValue = mock(ItemService.class);
		ItemEntity getItemByIdResult = mockItemEntity();
		when(itemServiceValue.getItemById(nullable(Long.class))).thenReturn(getItemByIdResult);
		return itemServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		boolean existsByItemIdAndUserIdResult = false; // UTA: provided value
		when(shoppingCartRepositoryValue.existsByItemIdAndUserId(nullable(Long.class), nullable(Long.class)))
				.thenReturn(existsByItemIdAndUserIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for addCartItemInShoppingCart(Long, Long, Integer)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#addCartItemInShoppingCart(Long, Long, Integer)
	 * @author jakubiak
	 */
	@Test
	public void testAddCartItemInShoppingCart2() throws Throwable {
		// UTA: One or more of the required values have not been automatically set.
		// Review the information about the required modifications below and manually update the missing value(s).
		// 
		// To cover the code, make the following modifications:
		//  - the return value of the 'quantity.intValue()' method must be changed (for example, to '1')
		//  - the return value of the first call on the 'this.itemService.getItemById(java.lang.Long).getInStock().intValue()' method must be changed (for example, to '1')
		//  - the return value of the 'this.shoppingCartRepository.existsByItemIdAndUserId(java.lang.Long,java.lang.Long)' method must be changed (for example, to 'true')
		//  - the return value of the 'this.shoppingCartRepository.findByUserIdAndItemId(java.lang.Long,java.lang.Long).getQuantity().intValue()' method must be changed (for example, to '-1000')
		//  - the return value of the second call on the 'this.itemService.getItemById(java.lang.Long).getInStock().intValue()' method must be changed (for example, to '-1000')

		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ItemService itemServiceValue = mockItemService2();
		ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository2();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		Long itemId = 0L; // UTA: default value
		Integer quantity = 1; // UTA: provided value
		CartItemEntity result = underTest.addCartItemInShoppingCart(userId, itemId, quantity);

		// Then
		// assertNotNull(result);
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemEntity
	 */
	private static ItemEntity mockItemEntity2() throws Throwable {
		ItemEntity getItemByIdResult = mock(ItemEntity.class);
		Integer getInStockResult = 1; // UTA: provided value
		when(getItemByIdResult.getInStock()).thenReturn(getInStockResult);
		return getItemByIdResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemService
	 */
	private static ItemService mockItemService2() throws Throwable {
		ItemService itemServiceValue = mock(ItemService.class);
		ItemEntity getItemByIdResult = mockItemEntity2();
		when(itemServiceValue.getItemById(nullable(Long.class))).thenReturn(getItemByIdResult);
		return itemServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CartItemEntity
	 */
	private static CartItemEntity mockCartItemEntity() throws Throwable {
		CartItemEntity findByUserIdAndItemIdResult = mock(CartItemEntity.class);
		Integer getQuantityResult = -1000; // UTA: provided value
		when(findByUserIdAndItemIdResult.getQuantity()).thenReturn(getQuantityResult);
		return findByUserIdAndItemIdResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository2() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		boolean existsByItemIdAndUserIdResult = true; // UTA: provided value
		when(shoppingCartRepositoryValue.existsByItemIdAndUserId(nullable(Long.class), nullable(Long.class)))
				.thenReturn(existsByItemIdAndUserIdResult);

		CartItemEntity findByUserIdAndItemIdResult = mockCartItemEntity();
		when(shoppingCartRepositoryValue.findByUserIdAndItemId(nullable(Long.class), nullable(Long.class)))
				.thenReturn(findByUserIdAndItemIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for addCartItemInShoppingCart(Long, Long, Integer)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#addCartItemInShoppingCart(Long, Long, Integer)
	 * @author jakubiak
	 */
	@Test(expected = ParameterException.class)
	public void testAddCartItemInShoppingCart3() throws Throwable {
		// UTA: The code that follows the covered line throws an exception "com.parasoft.demoapp.exception.ParameterException".

		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ItemService itemServiceValue = mockItemService3();
		ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);

		// When
		Long userId = 0L; // UTA: default value
		Long itemId = 0L; // UTA: default value
		Integer quantity = 1; // UTA: provided value
		CartItemEntity result = underTest.addCartItemInShoppingCart(userId, itemId, quantity);

		// Then
		// assertNotNull(result);
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemEntity
	 */
	private static ItemEntity mockItemEntity3() throws Throwable {
		ItemEntity getItemByIdResult = mock(ItemEntity.class);
		Integer getInStockResult = -1000; // UTA: provided value
		when(getItemByIdResult.getInStock()).thenReturn(getInStockResult);
		return getItemByIdResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemService
	 */
	private static ItemService mockItemService3() throws Throwable {
		ItemService itemServiceValue = mock(ItemService.class);
		ItemEntity getItemByIdResult = mockItemEntity3();
		when(itemServiceValue.getItemById(nullable(Long.class))).thenReturn(getItemByIdResult);
		return itemServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for clearShoppingCart(Long)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#clearShoppingCart(Long)
	 * @author jakubiak
	 */
	@Test
	public void testClearShoppingCart() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository3();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		underTest.clearShoppingCart(userId);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository3() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		boolean existsByUserIdResult = true; // UTA: provided value
		when(shoppingCartRepositoryValue.existsByUserId(nullable(Long.class))).thenReturn(existsByUserIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for clearShoppingCart(Long)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#clearShoppingCart(Long)
	 * @author jakubiak
	 */
	@Test
	public void testClearShoppingCart2() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository4();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		underTest.clearShoppingCart(userId);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository4() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		boolean existsByUserIdResult = false; // UTA: provided value
		when(shoppingCartRepositoryValue.existsByUserId(nullable(Long.class))).thenReturn(existsByUserIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getCartItemByUserIdAndItemId(Long, Long)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#getCartItemByUserIdAndItemId(Long, Long)
	 * @author jakubiak
	 */
	@Test
	public void testGetCartItemByUserIdAndItemId() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ItemService itemServiceValue = mock(ItemService.class);
		ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository5();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		Long itemId = 0L; // UTA: default value
		CartItemEntity result = underTest.getCartItemByUserIdAndItemId(userId, itemId);

		// Then
		// assertNotNull(result);
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository5() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		CartItemEntity findByUserIdAndItemIdResult = null; // UTA: provided value
		when(shoppingCartRepositoryValue.findByUserIdAndItemId(nullable(Long.class), nullable(Long.class)))
				.thenReturn(findByUserIdAndItemIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getCartItemsByUserId(Long)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#getCartItemsByUserId(Long)
	 * @author jakubiak
	 */
	@Test
	public void testGetCartItemsByUserId() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository6();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		List<CartItemEntity> result = underTest.getCartItemsByUserId(userId);

		// Then
		// assertNotNull(result);
		// assertEquals(0, result.size());
		// assertTrue(result.contains(null));
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of Iterator
	 */
	private static Iterator<CartItemEntity> mockIterator() throws Throwable {
		Iterator<CartItemEntity> iteratorResult = mock(Iterator.class);
		boolean hasNextResult = false; // UTA: provided value
		when(iteratorResult.hasNext()).thenReturn(hasNextResult);
		return iteratorResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of List
	 */
	private static List<CartItemEntity> mockList() throws Throwable {
		List<CartItemEntity> findAllByUserIdResult = mock(List.class);
		Iterator<CartItemEntity> iteratorResult = mockIterator();
		doReturn(iteratorResult).when(findAllByUserIdResult).iterator();
		return findAllByUserIdResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository6() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		List<CartItemEntity> findAllByUserIdResult = mockList();
		doReturn(findAllByUserIdResult).when(shoppingCartRepositoryValue).findAllByUserId(nullable(Long.class));
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for removeCartItemByUserIdAndItemId(Long, Long)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#removeCartItemByUserIdAndItemId(Long, Long)
	 * @author jakubiak
	 */
	@Test
	public void testRemoveCartItemByUserIdAndItemId() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository7();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		Long itemId = 0L; // UTA: default value
		underTest.removeCartItemByUserIdAndItemId(userId, itemId);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository7() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		boolean existsByItemIdResult = true; // UTA: provided value
		when(shoppingCartRepositoryValue.existsByItemId(nullable(Long.class))).thenReturn(existsByItemIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for removeCartItemByUserIdAndItemId(Long, Long)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#removeCartItemByUserIdAndItemId(Long, Long)
	 * @author jakubiak
	 */
	@Test
	public void testRemoveCartItemByUserIdAndItemId2() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository8();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		Long itemId = 0L; // UTA: default value
		underTest.removeCartItemByUserIdAndItemId(userId, itemId);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository8() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		boolean existsByItemIdResult = false; // UTA: provided value
		when(shoppingCartRepositoryValue.existsByItemId(nullable(Long.class))).thenReturn(existsByItemIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for updateCartItemQuantity(Long, Long, Integer)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#updateCartItemQuantity(Long, Long, Integer)
	 * @author jakubiak
	 */
	@Test
	public void testUpdateCartItemQuantity() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ItemService itemServiceValue = mockItemService4();
		ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository9();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		Long itemId = 0L; // UTA: default value
		Integer newQuantity = -1000; // UTA: provided value
		CartItemEntity result = underTest.updateCartItemQuantity(userId, itemId, newQuantity);

		// Then
		// assertNotNull(result);
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemEntity
	 */
	private static ItemEntity mockItemEntity4() throws Throwable {
		ItemEntity getItemByIdResult = mock(ItemEntity.class);
		Integer getInStockResult = -1; // UTA: provided value
		when(getItemByIdResult.getInStock()).thenReturn(getInStockResult);
		return getItemByIdResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemService
	 */
	private static ItemService mockItemService4() throws Throwable {
		ItemService itemServiceValue = mock(ItemService.class);
		ItemEntity getItemByIdResult = mockItemEntity4();
		when(itemServiceValue.getItemById(nullable(Long.class))).thenReturn(getItemByIdResult);
		return itemServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository9() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		CartItemEntity findByUserIdAndItemIdResult = mock(CartItemEntity.class);
		when(shoppingCartRepositoryValue.findByUserIdAndItemId(nullable(Long.class), nullable(Long.class)))
				.thenReturn(findByUserIdAndItemIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for updateCartItemQuantity(Long, Long, Integer)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#updateCartItemQuantity(Long, Long, Integer)
	 * @author jakubiak
	 */
	@Test
	public void testUpdateCartItemQuantity2() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ItemService itemServiceValue = mockItemService5();
		ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository10();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		Long itemId = 0L; // UTA: default value
		Integer newQuantity = 1; // UTA: provided value
		CartItemEntity result = underTest.updateCartItemQuantity(userId, itemId, newQuantity);

		// Then
		// assertNotNull(result);
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemEntity
	 */
	private static ItemEntity mockItemEntity5() throws Throwable {
		ItemEntity getItemByIdResult = mock(ItemEntity.class);
		Integer getInStockResult = 0; // UTA: provided value
		when(getItemByIdResult.getInStock()).thenReturn(getInStockResult);
		return getItemByIdResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemService
	 */
	private static ItemService mockItemService5() throws Throwable {
		ItemService itemServiceValue = mock(ItemService.class);
		ItemEntity getItemByIdResult = mockItemEntity5();
		when(itemServiceValue.getItemById(nullable(Long.class))).thenReturn(getItemByIdResult);
		return itemServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository10() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		CartItemEntity findByUserIdAndItemIdResult = mock(CartItemEntity.class);
		when(shoppingCartRepositoryValue.findByUserIdAndItemId(nullable(Long.class), nullable(Long.class)))
				.thenReturn(findByUserIdAndItemIdResult);
		return shoppingCartRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for updateCartItemQuantity(Long, Long, Integer)
	 *
	 * @see com.parasoft.demoapp.service.ShoppingCartService#updateCartItemQuantity(Long, Long, Integer)
	 * @author jakubiak
	 */
	@Test
	public void testUpdateCartItemQuantity3() throws Throwable {
		// Given
		ShoppingCartService underTest = new ShoppingCartService();
		ItemService itemServiceValue = mock(ItemService.class);
		ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);
		ShoppingCartRepository shoppingCartRepositoryValue = mockShoppingCartRepository11();
		ReflectionTestUtils.setField(underTest, "shoppingCartRepository", shoppingCartRepositoryValue);

		// When
		Long userId = 0L; // UTA: default value
		Long itemId = 0L; // UTA: default value
		Integer newQuantity = 0; // UTA: default value
		CartItemEntity result = underTest.updateCartItemQuantity(userId, itemId, newQuantity);

		// Then
		// assertNotNull(result);
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ShoppingCartRepository
	 */
	private static ShoppingCartRepository mockShoppingCartRepository11() throws Throwable {
		ShoppingCartRepository shoppingCartRepositoryValue = mock(ShoppingCartRepository.class);
		CartItemEntity findByUserIdAndItemIdResult = null; // UTA: provided value
		when(shoppingCartRepositoryValue.findByUserIdAndItemId(nullable(Long.class), nullable(Long.class)))
				.thenReturn(findByUserIdAndItemIdResult);
		return shoppingCartRepositoryValue;
	}
}