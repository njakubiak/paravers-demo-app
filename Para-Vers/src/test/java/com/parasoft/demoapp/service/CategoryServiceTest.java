/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.exception.CategoryHasAtLeastOneItemException;
import com.parasoft.demoapp.exception.CategoryNameExistsAlreadyException;
import com.parasoft.demoapp.exception.CategoryNotFoundException;
import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.model.industry.CategoryEntity;
import com.parasoft.demoapp.repository.industry.CategoryRepository;
import com.parasoft.demoapp.repository.industry.ItemRepository;
import java.lang.reflect.Field;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for CategoryService
 *
 * @see com.parasoft.demoapp.service.CategoryService
 * @author jakubiak
 */
public class CategoryServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for addNewCategory(String, String, String)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#addNewCategory(String, String, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testAddNewCategory() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mockCategoryRepository();
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		CategoryEntity result = underTest.addNewCategory(name, description, imagePath);

		// Then - assertions for result of method addNewCategory(String, String, String)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
	 */
	private static CategoryRepository mockCategoryRepository() throws Throwable {
		CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
		boolean existsByNameResult = false; // UTA: provided value
		when(categoryRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);
		return categoryRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for addNewCategory(String, String, String)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#addNewCategory(String, String, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = CategoryNameExistsAlreadyException.class)
	public void testAddNewCategory2() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mockCategoryRepository2();
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		String name = "name"; // UTA: default value
		String description = "description"; // UTA: default value
		String imagePath = "imagePath"; // UTA: default value
		underTest.addNewCategory(name, description, imagePath);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
	 */
	private static CategoryRepository mockCategoryRepository2() throws Throwable {
		CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
		boolean existsByNameResult = true; // UTA: provided value
		when(categoryRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);
		return categoryRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for existsByCategoryId(Long)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#existsByCategoryId(Long)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testExistsByCategoryId() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		Long categoryId = 0L; // UTA: default value
		boolean result = underTest.existsByCategoryId(categoryId);

		// Then - assertions for result of method existsByCategoryId(Long)
		assertFalse(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for getByCategoryName(String)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#getByCategoryName(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetByCategoryName() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mockCategoryRepository3();
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		String name = "name"; // UTA: default value
		CategoryEntity result = underTest.getByCategoryName(name);

		// Then - assertions for result of method getByCategoryName(String)
		assertNotNull(result);

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
	 * Parasoft Jtest UTA: Test for getByCategoryName(String)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#getByCategoryName(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = CategoryNotFoundException.class)
	public void testGetByCategoryName2() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mockCategoryRepository4();
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		String name = "name"; // UTA: default value
		underTest.getByCategoryName(name);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryRepository
	 */
	private static CategoryRepository mockCategoryRepository4() throws Throwable {
		CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
		CategoryEntity findByNameResult = null; // UTA: provided value
		when(categoryRepositoryValue.findByName(nullable(String.class))).thenReturn(findByNameResult);
		return categoryRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getCategories(String, Pageable)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#getCategories(String, Pageable)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetCategories() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		String searchString = "searchString"; // UTA: default value
		Pageable pageable = mock(Pageable.class);
		Page<CategoryEntity> result = underTest.getCategories(searchString, pageable);

		// Then - assertions for result of method getCategories(String, Pageable)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for numberOfImageUsedInCategories(String)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#numberOfImageUsedInCategories(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testNumberOfImageUsedInCategories() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();

		// When
		String imagePathOfCategory = null; // UTA: provided value
		long result = underTest.numberOfImageUsedInCategories(imagePathOfCategory);

		// Then - assertions for result of method numberOfImageUsedInCategories(String)
		assertEquals(0L, result);

	}

	/**
	 * Parasoft Jtest UTA: Test for numberOfImageUsedInCategories(String)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#numberOfImageUsedInCategories(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testNumberOfImageUsedInCategories2() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		String imagePathOfCategory = "imagePathOfCategory"; // UTA: default value
		long result = underTest.numberOfImageUsedInCategories(imagePathOfCategory);

		// Then - assertions for result of method numberOfImageUsedInCategories(String)
		assertEquals(0L, result);

	}

	/**
	 * Parasoft Jtest UTA: Test for removeCategory(Long)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#removeCategory(Long)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = CategoryNotFoundException.class)
	public void testRemoveCategory() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		Long categoryId = 0L; // UTA: default value
		underTest.removeCategory(categoryId);

	}

	/**
	 * Parasoft Jtest UTA: Test for searchCategoriesByNameOrDescription(String, Pageable)
	 *
	 * @see com.parasoft.demoapp.service.CategoryService#searchCategoriesByNameOrDescription(String, Pageable)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testSearchCategoriesByNameOrDescription() throws Throwable {
		// Given
		CategoryService underTest = new CategoryService();
		CategoryRepository categoryRepositoryValue = mock(CategoryRepository.class);
		ReflectionTestUtils.setField(underTest, "categoryRepository", categoryRepositoryValue);

		// When
		String key = "key"; // UTA: default value
		Pageable pageable = mock(Pageable.class);
		Page<CategoryEntity> result = underTest.searchCategoriesByNameOrDescription(key, pageable);

		// Then - assertions for result of method searchCategoriesByNameOrDescription(String, Pageable)
		assertNull(result);

	}

}