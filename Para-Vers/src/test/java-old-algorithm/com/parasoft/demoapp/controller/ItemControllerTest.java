package com.parasoft.demoapp.controller;


import com.parasoft.demoapp.model.industry.ItemEntity;
import com.parasoft.demoapp.service.ItemService;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ItemController
 *
 * @see ItemController
 * @author jakubiak
 */
public class ItemControllerTest
{
    /**
     * Parasoft Jtest UTA: Test for getItemById(Long)
     *
     * @author jakubiak
     * @see ItemController#getItemById(Long)
     */
    @Test
    public void testGetItemById() throws Throwable {
        // Given
        ItemController underTest = new ItemController();
        ItemService itemServiceValue = mockItemService();
        ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);

        // When
        Long itemId = 0L; // UTA: default value
        ResponseResult<ItemEntity> result = underTest.getItemById(itemId);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemService
     */
    private static ItemService mockItemService() throws Throwable {
        ItemService itemServiceValue = mock(ItemService.class);
        ItemEntity getItemByIdResult = mock(ItemEntity.class);
        when(itemServiceValue.getItemById(nullable(Long.class))).thenReturn(getItemByIdResult);
        return itemServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getItemByName(String)
     *
     * @author jakubiak
     * @see ItemController#getItemByName(String)
     */
    @Test
    public void testGetItemByName() throws Throwable {
        // Given
        ItemController underTest = new ItemController();
        ItemService itemServiceValue = mockItemService2();
        ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);

        // When
        String itemName = ""; // UTA: default value
        ResponseResult<ItemEntity> result = underTest.getItemByName(itemName);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemService
     */
    private static ItemService mockItemService2() throws Throwable {
        ItemService itemServiceValue = mock(ItemService.class);
        ItemEntity getItemByNameResult = mock(ItemEntity.class);
        when(itemServiceValue.getItemByName(nullable(String.class))).thenReturn(getItemByNameResult);
        return itemServiceValue;
    }
}