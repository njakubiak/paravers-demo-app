package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.industry.CategoryEntity;
import com.parasoft.demoapp.repository.industry.CategoryRepository;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for CategoryService
 *
 * @see CategoryService
 * @author jakubiak
 */
public class CategoryServiceTest
{
    /**
     * Parasoft Jtest UTA: Test for existsByCategoryId(Long)
     *
     * @author jakubiak
     * @see CategoryService#existsByCategoryId(Long)
     */
    @Test
    public void testExistsByCategoryId() throws Throwable {
        // Given
        CategoryService underTest = new CategoryService();
        CategoryRepository categoryRepositoryValue = mockCategoryRepository();
        ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

        // When
        Long categoryId = 0L; // UTA: default value
        boolean result = underTest.existsByCategoryId(categoryId);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
     */
    private static CategoryRepository mockCategoryRepository() throws Throwable {
        CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
        boolean existsByIdResult = false; // UTA: default value
        when(categoryRepositoryValue.existsById(nullable(Long.class))).thenReturn(existsByIdResult);
        return categoryRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getByCategoryId(Long)
     *
     * @author jakubiak
     * @see CategoryService#getByCategoryId(Long)
     */
    @Test
    public void testGetByCategoryId() throws Throwable {
        // Given
        CategoryService underTest = new CategoryService();
        CategoryRepository categoryRepositoryValue = mockCategoryRepository2();
        ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

        // When
        Long id = 0L; // UTA: default value
        CategoryEntity result = underTest.getByCategoryId(id);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
     */
    private static CategoryRepository mockCategoryRepository2() throws Throwable {
        CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
        CategoryEntity optionalValue = mock(CategoryEntity.class);
        Optional<CategoryEntity> findByIdResult = Optional.of(optionalValue);
        doReturn(findByIdResult).when(categoryRepositoryValue).findById(nullable(Long.class));
        return categoryRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getByCategoryName(String)
     *
     * @author jakubiak
     * @see CategoryService#getByCategoryName(String)
     */
    @Test
    public void testGetByCategoryName() throws Throwable {
        // Given
        CategoryService underTest = new CategoryService();
        CategoryRepository categoryRepositoryValue = mockCategoryRepository3();
        ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

        // When
        String name = ""; // UTA: default value
        CategoryEntity result = underTest.getByCategoryName(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
     */
    private static CategoryRepository mockCategoryRepository3() throws Throwable {
        CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
        CategoryEntity findByNameResult = mock(CategoryEntity.class);
        when(categoryRepositoryValue.findByName(nullable(String.class))).thenReturn(findByNameResult);
        return categoryRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getCategories(String, Pageable)
     *
     * @author jakubiak
     * @see CategoryService#getCategories(String, Pageable)
     */
    @Test
    public void testGetCategories() throws Throwable {
        // Given
        CategoryService underTest = new CategoryService();
        CategoryRepository categoryRepositoryValue = mockCategoryRepository4();
        ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

        // When
        String searchString = ""; // UTA: default value
        Pageable pageable = mock(Pageable.class);
        Page<CategoryEntity> result = underTest.getCategories(searchString, pageable);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
     */
    private static CategoryRepository mockCategoryRepository4() throws Throwable {
        CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
        Page<CategoryEntity> findAllResult = mock(Page.class);
        doReturn(findAllResult).when(categoryRepositoryValue).findAll((Specification) any(), nullable(Pageable.class));
        return categoryRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for numberOfImageUsedInCategories(String)
     *
     * @author jakubiak
     * @see CategoryService#numberOfImageUsedInCategories(String)
     */
    @Test
    public void testNumberOfImageUsedInCategories() throws Throwable {
        // Given
        CategoryService underTest = new CategoryService();
        CategoryRepository categoryRepositoryValue = mockCategoryRepository5();
        ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

        // When
        String imagePathOfCategory = ""; // UTA: default value
        long result = underTest.numberOfImageUsedInCategories(imagePathOfCategory);

        // Then
        // assertEquals(0L, result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
     */
    private static CategoryRepository mockCategoryRepository5() throws Throwable {
        CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
        long countByImageResult = 0L; // UTA: default value
        when(categoryRepositoryValue.countByImage(nullable(String.class))).thenReturn(countByImageResult);
        return categoryRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for searchCategoriesByNameOrDescription(String, Pageable)
     *
     * @author jakubiak
     * @see CategoryService#searchCategoriesByNameOrDescription(String, Pageable)
     */
    @Test
    public void testSearchCategoriesByNameOrDescription() throws Throwable {
        // Given
        CategoryService underTest = new CategoryService();
        CategoryRepository categoryRepositoryValue = mockCategoryRepository6();
        ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

        // When
        String key = ""; // UTA: default value
        Pageable pageable = mock(Pageable.class);
        Page<CategoryEntity> result = underTest.searchCategoriesByNameOrDescription(key, pageable);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
     */
    private static CategoryRepository mockCategoryRepository6() throws Throwable {
        CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
        Page<CategoryEntity> findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseResult = mock(Page.class);
        doReturn(findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseResult).when(categoryRepositoryValue).findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(nullable(String.class), nullable(String.class), nullable(Pageable.class));
        return categoryRepositoryValue;
    }
}