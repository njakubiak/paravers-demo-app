/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.exception.CategoryNotFoundException;
import com.parasoft.demoapp.exception.ItemNameExistsAlreadyException;
import com.parasoft.demoapp.exception.ItemNotFoundException;
import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.exception.UnsupportedOperationInCurrentIndustryException;
import com.parasoft.demoapp.model.industry.ItemEntity;
import com.parasoft.demoapp.model.industry.RegionType;
import com.parasoft.demoapp.repository.industry.ItemRepository;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for ItemService
 *
 * @see com.parasoft.demoapp.service.ItemService
 * @author jakubiak
 */
public class ItemServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for addNewItem(String, String, Long, Integer, String, RegionType)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#addNewItem(String, String, Long, Integer, String, RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testAddNewItem() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		CategoryService categoryServiceValue = mockCategoryService();
		ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);
		ItemRepository itemRepositoryValue = mockItemRepository();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);
		LocationService locationServiceValue = mockLocationService();
		ReflectionTestUtils.setField(underTest, "locationService", locationServiceValue);

		// When
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		Long categoryId = 0L; // UTA: default value
		Integer inStock = 0; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		ItemEntity result = underTest.addNewItem(name, description, categoryId, inStock, imagePath, region);

		// Then - assertions for result of method addNewItem(String, String, Long, Integer, String, RegionType)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
	 */
	private static CategoryService mockCategoryService() throws Throwable {
		CategoryService categoryServiceValue = mock(CategoryService.class);
		boolean existsByCategoryIdResult = true; // UTA: provided value
		when(categoryServiceValue.existsByCategoryId(nullable(Long.class))).thenReturn(existsByCategoryIdResult);
		return categoryServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		boolean existsByNameResult = false; // UTA: provided value
		when(itemRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationService
	 */
	private static LocationService mockLocationService() throws Throwable {
		LocationService locationServiceValue = mock(LocationService.class);
		boolean isCorrectRegionInCurrentIndustryResult = true; // UTA: provided value
		when(locationServiceValue.isCorrectRegionInCurrentIndustry(nullable(RegionType.class)))
				.thenReturn(isCorrectRegionInCurrentIndustryResult);
		return locationServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for addNewItem(String, String, Long, Integer, String, RegionType)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#addNewItem(String, String, Long, Integer, String, RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = CategoryNotFoundException.class)
	public void testAddNewItem2() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		CategoryService categoryServiceValue = mockCategoryService2();
		ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);

		// When
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		Long categoryId = 0L; // UTA: default value
		Integer inStock = 0; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		underTest.addNewItem(name, description, categoryId, inStock, imagePath, region);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
	 */
	private static CategoryService mockCategoryService2() throws Throwable {
		CategoryService categoryServiceValue = mock(CategoryService.class);
		boolean existsByCategoryIdResult = false; // UTA: provided value
		when(categoryServiceValue.existsByCategoryId(nullable(Long.class))).thenReturn(existsByCategoryIdResult);
		return categoryServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for addNewItem(String, String, Long, Integer, String, RegionType)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#addNewItem(String, String, Long, Integer, String, RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ItemNameExistsAlreadyException.class)
	public void testAddNewItem3() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		CategoryService categoryServiceValue = mockCategoryService3();
		ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);
		ItemRepository itemRepositoryValue = mockItemRepository2();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		Long categoryId = 0L; // UTA: default value
		Integer inStock = 0; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		underTest.addNewItem(name, description, categoryId, inStock, imagePath, region);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
	 */
	private static CategoryService mockCategoryService3() throws Throwable {
		CategoryService categoryServiceValue = mock(CategoryService.class);
		boolean existsByCategoryIdResult = true; // UTA: provided value
		when(categoryServiceValue.existsByCategoryId(nullable(Long.class))).thenReturn(existsByCategoryIdResult);
		return categoryServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository2() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		boolean existsByNameResult = true; // UTA: provided value
		when(itemRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for addNewItem(String, String, Long, Integer, String, RegionType)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#addNewItem(String, String, Long, Integer, String, RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = UnsupportedOperationInCurrentIndustryException.class)
	public void testAddNewItem4() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		CategoryService categoryServiceValue = mockCategoryService4();
		ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);
		ItemRepository itemRepositoryValue = mockItemRepository3();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);
		LocationService locationServiceValue = mockLocationService2();
		ReflectionTestUtils.setField(underTest, "locationService", locationServiceValue);

		// When
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		Long categoryId = 0L; // UTA: default value
		Integer inStock = 0; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		underTest.addNewItem(name, description, categoryId, inStock, imagePath, region);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
	 */
	private static CategoryService mockCategoryService4() throws Throwable {
		CategoryService categoryServiceValue = mock(CategoryService.class);
		boolean existsByCategoryIdResult = true; // UTA: provided value
		when(categoryServiceValue.existsByCategoryId(nullable(Long.class))).thenReturn(existsByCategoryIdResult);
		return categoryServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository3() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		boolean existsByNameResult = false; // UTA: provided value
		when(itemRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationService
	 */
	private static LocationService mockLocationService2() throws Throwable {
		LocationService locationServiceValue = mock(LocationService.class);
		boolean isCorrectRegionInCurrentIndustryResult = false; // UTA: provided value
		when(locationServiceValue.isCorrectRegionInCurrentIndustry(nullable(RegionType.class)))
				.thenReturn(isCorrectRegionInCurrentIndustryResult);
		return locationServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for addNewItem(String, String, Long, Integer, String, RegionType)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#addNewItem(String, String, Long, Integer, String, RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = UnsupportedOperationInCurrentIndustryException.class)
	public void testAddNewItem5() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		CategoryService categoryServiceValue = mockCategoryService5();
		ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);
		ImageService imageServiceValue = mock(ImageService.class);
		ReflectionTestUtils.setField(underTest, "imageService", imageServiceValue);
		ItemRepository itemRepositoryValue = mockItemRepository4();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);
		LocationService locationServiceValue = mockLocationService3();
		ReflectionTestUtils.setField(underTest, "locationService", locationServiceValue);

		// When
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		Long categoryId = 0L; // UTA: default value
		Integer inStock = 0; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		underTest.addNewItem(name, description, categoryId, inStock, imagePath, region);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
	 */
	private static CategoryService mockCategoryService5() throws Throwable {
		CategoryService categoryServiceValue = mock(CategoryService.class);
		boolean existsByCategoryIdResult = true; // UTA: provided value
		when(categoryServiceValue.existsByCategoryId(nullable(Long.class))).thenReturn(existsByCategoryIdResult);
		return categoryServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository4() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		boolean existsByNameResult = false; // UTA: provided value
		when(itemRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of LocationService
	 */
	private static LocationService mockLocationService3() throws Throwable {
		LocationService locationServiceValue = mock(LocationService.class);
		boolean isCorrectRegionInCurrentIndustryResult = false; // UTA: provided value
		when(locationServiceValue.isCorrectRegionInCurrentIndustry(nullable(RegionType.class)))
				.thenReturn(isCorrectRegionInCurrentIndustryResult);
		return locationServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for existsByItemId(Long)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#existsByItemId(Long)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testExistsByItemId() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		Long itemId = 0L; // UTA: default value
		boolean result = underTest.existsByItemId(itemId);

		// Then - assertions for result of method existsByItemId(Long)
		assertFalse(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for getAllItems()
	 *
	 * @see com.parasoft.demoapp.service.ItemService#getAllItems()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetAllItems() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mockItemRepository5();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		List<ItemEntity> result = underTest.getAllItems();

		// Then - assertions for result of method getAllItems()
		assertNotNull(result);
		assertEquals(1, result.size());

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository5() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		List<ItemEntity> findAllResult = new ArrayList<ItemEntity>(); // UTA: default value
		ItemEntity item = mock(ItemEntity.class);
		findAllResult.add(item);
		doReturn(findAllResult).when(itemRepositoryValue).findAll();
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getAllItems()
	 *
	 * @see com.parasoft.demoapp.service.ItemService#getAllItems()
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ItemNotFoundException.class)
	public void testGetAllItems2() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mockItemRepository6();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		underTest.getAllItems();

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository6() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		List<ItemEntity> findAllResult = new ArrayList<ItemEntity>(); // UTA: default value
		doReturn(findAllResult).when(itemRepositoryValue).findAll();
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getInStockById(Long)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#getInStockById(Long)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetInStockById() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		Long id = 0L; // UTA: default value
		Integer result = underTest.getInStockById(id);

		// Then - assertions for result of method getInStockById(Long)
		assertNotNull(result);
		assertEquals(0, result.intValue());

	}

	/**
	 * Parasoft Jtest UTA: Test for getItemByName(String)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#getItemByName(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ItemNotFoundException.class)
	public void testGetItemByName() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mockItemRepository7();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		String name = "name"; // UTA: default value
		underTest.getItemByName(name);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository7() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		ItemEntity findByNameResult = null; // UTA: provided value
		when(itemRepositoryValue.findByName(nullable(String.class))).thenReturn(findByNameResult);
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getItems(Long, RegionType[], String, Pageable)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#getItems(Long, RegionType[], String, Pageable)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetItems() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mockItemRepository8();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		Long categoryId = 0L; // UTA: default value
		RegionType[] regions = new com.parasoft.demoapp.model.industry.RegionType[0]; // UTA: default value
		String searchString = "searchString"; // UTA: default value
		Pageable pageable = mock(Pageable.class);
		Page<ItemEntity> result = underTest.getItems(categoryId, regions, searchString, pageable);

		// Then - assertions for result of method getItems(Long, RegionType[], String, Pageable)
		assertNotNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of Page
	 */
	private static Page<ItemEntity> mockPage() throws Throwable {
		Page<ItemEntity> findAllResult = mock(Page.class);
		int getSizeResult = 1; // UTA: provided value
		when(findAllResult.getSize()).thenReturn(getSizeResult);
		return findAllResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository8() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		Page<ItemEntity> findAllResult = mockPage();
		doReturn(findAllResult).when(itemRepositoryValue).findAll((Specification) any(), nullable(Pageable.class));
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getItems(Long, RegionType[], String, Pageable)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#getItems(Long, RegionType[], String, Pageable)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ItemNotFoundException.class)
	public void testGetItems2() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mockItemRepository9();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		Long categoryId = 0L; // UTA: default value
		RegionType[] regions = new com.parasoft.demoapp.model.industry.RegionType[0]; // UTA: default value
		String searchString = "searchString"; // UTA: default value
		Pageable pageable = mock(Pageable.class);
		underTest.getItems(categoryId, regions, searchString, pageable);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of Page
	 */
	private static Page<ItemEntity> mockPage2() throws Throwable {
		Page<ItemEntity> findAllResult = mock(Page.class);
		int getSizeResult = 0; // UTA: provided value
		when(findAllResult.getSize()).thenReturn(getSizeResult);
		return findAllResult;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository9() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		Page<ItemEntity> findAllResult = mockPage2();
		doReturn(findAllResult).when(itemRepositoryValue).findAll((Specification) any(), nullable(Pageable.class));
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for numberOfImageUsedInItems(String)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#numberOfImageUsedInItems(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testNumberOfImageUsedInItems() throws Throwable {
		// Given
		ItemService underTest = new ItemService();

		// When
		String imagePathOfItem = null; // UTA: provided value
		long result = underTest.numberOfImageUsedInItems(imagePathOfItem);

		// Then - assertions for result of method numberOfImageUsedInItems(String)
		assertEquals(0L, result);

	}

	/**
	 * Parasoft Jtest UTA: Test for numberOfImageUsedInItems(String)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#numberOfImageUsedInItems(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testNumberOfImageUsedInItems2() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		String imagePathOfItem = "imagePathOfItem"; // UTA: default value
		long result = underTest.numberOfImageUsedInItems(imagePathOfItem);

		// Then - assertions for result of method numberOfImageUsedInItems(String)
		assertEquals(0L, result);

	}

	/**
	 * Parasoft Jtest UTA: Test for removeItemByName(String)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#removeItemByName(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ItemNotFoundException.class)
	public void testRemoveItemByName() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mockItemRepository10();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		String itemName = "itemName"; // UTA: default value
		underTest.removeItemByName(itemName);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository10() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		boolean existsByNameResult = false; // UTA: provided value
		when(itemRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for removeItemByName(String)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#removeItemByName(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ItemNotFoundException.class)
	public void testRemoveItemByName2() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mockItemRepository11();
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		String itemName = "itemName"; // UTA: default value
		underTest.removeItemByName(itemName);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
	 */
	private static ItemRepository mockItemRepository11() throws Throwable {
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		boolean existsByNameResult = true; // UTA: provided value
		when(itemRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);

		ItemEntity findByNameResult = null; // UTA: provided value
		when(itemRepositoryValue.findByName(nullable(String.class))).thenReturn(findByNameResult);
		return itemRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for searchItemsByNameOrDescription(String, Pageable)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#searchItemsByNameOrDescription(String, Pageable)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testSearchItemsByNameOrDescription() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		String key = "key"; // UTA: default value
		Pageable pageable = mock(Pageable.class);
		Page<ItemEntity> result = underTest.searchItemsByNameOrDescription(key, pageable);

		// Then - assertions for result of method searchItemsByNameOrDescription(String, Pageable)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for updateItem(Long, String, String, Long, Integer, String, RegionType)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#updateItem(Long, String, String, Long, Integer, String, RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = CategoryNotFoundException.class)
	public void testUpdateItem2() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		CategoryService categoryServiceValue = mockCategoryService7();
		ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);

		// When
		Long itemId = 0L; // UTA: default value
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		Long categoryId = 0L; // UTA: default value
		Integer inStock = 0; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		underTest.updateItem(itemId, name, description, categoryId, inStock, imagePath, region);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
	 */
	private static CategoryService mockCategoryService7() throws Throwable {
		CategoryService categoryServiceValue = mock(CategoryService.class);
		boolean existsByCategoryIdResult = false; // UTA: provided value
		when(categoryServiceValue.existsByCategoryId(nullable(Long.class))).thenReturn(existsByCategoryIdResult);
		return categoryServiceValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for updateItem(Long, String, String, Long, Integer, String, RegionType)
	 *
	 * @see com.parasoft.demoapp.service.ItemService#updateItem(Long, String, String, Long, Integer, String, RegionType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ItemNotFoundException.class)
	public void testUpdateItem3() throws Throwable {
		// Given
		ItemService underTest = new ItemService();
		CategoryService categoryServiceValue = mockCategoryService8();
		ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);
		ItemRepository itemRepositoryValue = mock(ItemRepository.class);
		ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

		// When
		Long itemId = 0L; // UTA: default value
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		Long categoryId = 0L; // UTA: default value
		Integer inStock = 0; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		RegionType region = RegionType.UNITED_STATES; // UTA: default value
		underTest.updateItem(itemId, name, description, categoryId, inStock, imagePath, region);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
	 */
	private static CategoryService mockCategoryService8() throws Throwable {
		CategoryService categoryServiceValue = mock(CategoryService.class);
		boolean existsByCategoryIdResult = true; // UTA: provided value
		when(categoryServiceValue.existsByCategoryId(nullable(Long.class))).thenReturn(existsByCategoryIdResult);
		return categoryServiceValue;
	}

}