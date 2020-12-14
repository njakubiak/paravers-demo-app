package com.parasoft.demoapp.controller;


import com.parasoft.demoapp.model.industry.CategoryEntity;
import com.parasoft.demoapp.service.CategoryService;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for CategoryController
 *
 * @see CategoryController
 * @author jakubiak
 */
public class CategoryControllerTest
{
    /**
     * Parasoft Jtest UTA: Test for getCategoryById(Long)
     *
     * @author jakubiak
     * @see CategoryController#getCategoryById(Long)
     */
    @Test
    public void testGetCategoryById() throws Throwable {
        // Given
        CategoryController underTest = new CategoryController();
        CategoryService categoryServiceValue = mockCategoryService();
        ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);

        // When
        Long categoryId = 0L; // UTA: default value
        ResponseResult<CategoryEntity> result = underTest.getCategoryById(categoryId);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
     */
    private static CategoryService mockCategoryService() throws Throwable {
        CategoryService categoryServiceValue = mock(CategoryService.class);
        CategoryEntity getByCategoryIdResult = mock(CategoryEntity.class);
        when(categoryServiceValue.getByCategoryId(nullable(Long.class))).thenReturn(getByCategoryIdResult);
        return categoryServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getCategoryByName(String)
     *
     * @author jakubiak
     * @see CategoryController#getCategoryByName(String)
     */
    @Test
    public void testGetCategoryByName() throws Throwable {
        // Given
        CategoryController underTest = new CategoryController();
        CategoryService categoryServiceValue = mockCategoryService2();
        ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);

        // When
        String categoryName = ""; // UTA: default value
        ResponseResult<CategoryEntity> result = underTest.getCategoryByName(categoryName);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
     */
    private static CategoryService mockCategoryService2() throws Throwable {
        CategoryService categoryServiceValue = mock(CategoryService.class);
        CategoryEntity getByCategoryNameResult = mock(CategoryEntity.class);
        when(categoryServiceValue.getByCategoryName(nullable(String.class))).thenReturn(getByCategoryNameResult);
        return categoryServiceValue;
    }
}