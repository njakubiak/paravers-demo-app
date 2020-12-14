package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.industry.ItemEntity;
import com.parasoft.demoapp.model.industry.RegionType;
import com.parasoft.demoapp.repository.industry.ItemRepository;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ItemService
 *
 * @see ItemService
 * @author jakubiak
 */
public class ItemServiceTest
{
    /**
     * Parasoft Jtest UTA: Test for existsByItemId(Long)
     *
     * @author jakubiak
     * @see ItemService#existsByItemId(Long)
     */
    @Test
    public void testExistsByItemId() throws Throwable {
        // Given
        ItemService underTest = new ItemService();
        ItemRepository itemRepositoryValue = mockItemRepository();
        ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

        // When
        Long itemId = 0L; // UTA: default value
        boolean result = underTest.existsByItemId(itemId);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
     */
    private static ItemRepository mockItemRepository() throws Throwable {
        ItemRepository itemRepositoryValue = mock(ItemRepository.class);
        boolean existsByIdResult = false; // UTA: default value
        when(itemRepositoryValue.existsById(nullable(Long.class))).thenReturn(existsByIdResult);
        return itemRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getAllItems()
     *
     * @author jakubiak
     * @see ItemService#getAllItems()
     */
    @Test
    public void testGetAllItems() throws Throwable {
        // Given
        ItemService underTest = new ItemService();
        ItemRepository itemRepositoryValue = mockItemRepository2();
        ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

        // When
        List<ItemEntity> result = underTest.getAllItems();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.contains(null));
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
     */
    private static ItemRepository mockItemRepository2() throws Throwable {
        ItemRepository itemRepositoryValue = mock(ItemRepository.class);
        List<ItemEntity> findAllResult = new ArrayList<ItemEntity>(); // UTA: default value
        ItemEntity item = mock(ItemEntity.class);
        findAllResult.add(item);
        doReturn(findAllResult).when(itemRepositoryValue).findAll();
        return itemRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getInStockById(Long)
     *
     * @author jakubiak
     * @see ItemService#getInStockById(Long)
     */
    @Test
    public void testGetInStockById() throws Throwable {
        // Given
        ItemService underTest = new ItemService();
        ItemRepository itemRepositoryValue = mockItemRepository3();
        ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

        // When
        Long id = 0L; // UTA: default value
        Integer result = underTest.getInStockById(id);

        // Then
        // assertEquals(0, result.intValue());
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
     */
    private static ItemRepository mockItemRepository3() throws Throwable {
        ItemRepository itemRepositoryValue = mock(ItemRepository.class);
        Integer findInStockByIdResult = 0; // UTA: default value
        when(itemRepositoryValue.findInStockById(nullable(Long.class))).thenReturn(findInStockByIdResult);
        return itemRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getItemById(Long)
     *
     * @author jakubiak
     * @see ItemService#getItemById(Long)
     */
    @Test
    public void testGetItemById() throws Throwable {
        // Given
        ItemService underTest = new ItemService();
        ItemRepository itemRepositoryValue = mockItemRepository4();
        ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

        // When
        Long id = 0L; // UTA: default value
        ItemEntity result = underTest.getItemById(id);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
     */
    private static ItemRepository mockItemRepository4() throws Throwable {
        ItemRepository itemRepositoryValue = mock(ItemRepository.class);
        ItemEntity optionalValue = mock(ItemEntity.class);
        Optional<ItemEntity> findByIdResult = Optional.of(optionalValue);
        doReturn(findByIdResult).when(itemRepositoryValue).findById(nullable(Long.class));
        return itemRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getItemByName(String)
     *
     * @author jakubiak
     * @see ItemService#getItemByName(String)
     */
    @Test
    public void testGetItemByName() throws Throwable {
        // Given
        ItemService underTest = new ItemService();
        ItemRepository itemRepositoryValue = mockItemRepository5();
        ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

        // When
        String name = ""; // UTA: default value
        ItemEntity result = underTest.getItemByName(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
     */
    private static ItemRepository mockItemRepository5() throws Throwable {
        ItemRepository itemRepositoryValue = mock(ItemRepository.class);
        ItemEntity findByNameResult = mock(ItemEntity.class);
        when(itemRepositoryValue.findByName(nullable(String.class))).thenReturn(findByNameResult);
        return itemRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getItems(Long, RegionType[], String, Pageable)
     *
     * @author jakubiak
     * @see ItemService#getItems(Long, RegionType[], String, Pageable)
     */
    @Test
    public void testGetItems() throws Throwable {
        // Given
        ItemService underTest = new ItemService();
        ItemRepository itemRepositoryValue = mockItemRepository6();
        ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

        // When
        Long categoryId = 0L; // UTA: default value
        RegionType[] regions = new com.parasoft.demoapp.model.industry.RegionType[0]; // UTA: default value
        String searchString = ""; // UTA: default value
        Pageable pageable = mock(Pageable.class);
        Page<ItemEntity> result = underTest.getItems(categoryId, regions, searchString, pageable);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Page
     */
    private static Page<ItemEntity> mockPage() throws Throwable {
        Page<ItemEntity> findAllResult = mock(Page.class);
        int getSizeResult = 0; // UTA: default value
        when(findAllResult.getSize()).thenReturn(getSizeResult);
        return findAllResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
     */
    private static ItemRepository mockItemRepository6() throws Throwable {
        ItemRepository itemRepositoryValue = mock(ItemRepository.class);
        Page<ItemEntity> findAllResult = mockPage();
        doReturn(findAllResult).when(itemRepositoryValue).findAll((Specification) any(), nullable(Pageable.class));
        return itemRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for numberOfImageUsedInItems(String)
     *
     * @author jakubiak
     * @see ItemService#numberOfImageUsedInItems(String)
     */
    @Test
    public void testNumberOfImageUsedInItems() throws Throwable {
        // Given
        ItemService underTest = new ItemService();
        ItemRepository itemRepositoryValue = mockItemRepository7();
        ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

        // When
        String imagePathOfItem = ""; // UTA: default value
        long result = underTest.numberOfImageUsedInItems(imagePathOfItem);

        // Then
        // assertEquals(0L, result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
     */
    private static ItemRepository mockItemRepository7() throws Throwable {
        ItemRepository itemRepositoryValue = mock(ItemRepository.class);
        long countByImageResult = 0L; // UTA: default value
        when(itemRepositoryValue.countByImage(nullable(String.class))).thenReturn(countByImageResult);
        return itemRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for searchItemsByNameOrDescription(String, Pageable)
     *
     * @author jakubiak
     * @see ItemService#searchItemsByNameOrDescription(String, Pageable)
     */
    @Test
    public void testSearchItemsByNameOrDescription() throws Throwable {
        // Given
        ItemService underTest = new ItemService();
        ItemRepository itemRepositoryValue = mockItemRepository8();
        ReflectionTestUtils.setField(underTest, "itemRepository", itemRepositoryValue);

        // When
        String key = ""; // UTA: default value
        Pageable pageable = mock(Pageable.class);
        Page<ItemEntity> result = underTest.searchItemsByNameOrDescription(key, pageable);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemRepository
     */
    private static ItemRepository mockItemRepository8() throws Throwable {
        ItemRepository itemRepositoryValue = mock(ItemRepository.class);
        Page<ItemEntity> findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseResult = mock(Page.class);
        doReturn(findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseResult).when(itemRepositoryValue).findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(nullable(String.class), nullable(String.class), nullable(Pageable.class));
        return itemRepositoryValue;
    }
}