package com.parasoft.demoapp.service;


import com.parasoft.demoapp.config.WebConfig;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ImageService
 *
 * @author jakubiak
 * @see ImageService
 */
public class ImageServiceTest {
    /**
     * Parasoft Jtest UTA: Test for deleteUploadedImageByPath(String)
     *
     * @author jakubiak
     * @see ImageService#deleteUploadedImageByPath(String)
     */
    @Test
    public void testDeleteUploadedImageByPath() throws Throwable {
        // Given
        ImageService underTest = new ImageService();
        WebConfig webConfigValue = mockWebConfig();
        ReflectionTestUtils.setField(underTest, "webConfig", webConfigValue);

        // When
        String imagePath = ""; // UTA: default value
        underTest.deleteUploadedImageByPath(imagePath);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of WebConfig
     */
    private static WebConfig mockWebConfig() throws Throwable {
        WebConfig webConfigValue = mock(WebConfig.class);
        String getUploadedImagesStorePathResult = ""; // UTA: default value
        when(webConfigValue.getUploadedImagesStorePath()).thenReturn(getUploadedImagesStorePathResult);
        return webConfigValue;
    }

    /**
     * Parasoft Jtest UTA: Test for getDefaultImage()
     *
     * @author jakubiak
     * @see ImageService#getDefaultImage()
     */
    @Test
    public void testGetDefaultImage() throws Throwable {
        // Given
        ImageService underTest = new ImageService();

        // When
        String result = underTest.getDefaultImage();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for handleImageAndReturnStaticLocation(MultipartFile)
     *
     * @author jakubiak
     * @see ImageService#handleImageAndReturnStaticLocation(MultipartFile)
     */
    @Test
    public void testHandleImageAndReturnStaticLocation() throws Throwable {
        // Given
        ImageService underTest = new ImageService();
        WebConfig webConfigValue = mockWebConfig2();
        ReflectionTestUtils.setField(underTest, "webConfig", webConfigValue);

        // When
        MultipartFile image = mockMultipartFile();
        String result = underTest.handleImageAndReturnStaticLocation(image);

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of WebConfig
     */
    private static WebConfig mockWebConfig2() throws Throwable {
        WebConfig webConfigValue = mock(WebConfig.class);
        String getUploadedImagesStorePathResult = ""; // UTA: default value
        when(webConfigValue.getUploadedImagesStorePath()).thenReturn(getUploadedImagesStorePathResult);
        return webConfigValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of MultipartFile
     */
    private static MultipartFile mockMultipartFile() throws Throwable {
        MultipartFile image = mock(MultipartFile.class);
        String getOriginalFilenameResult = ""; // UTA: default value
        when(image.getOriginalFilename()).thenReturn(getOriginalFilenameResult);

        boolean isEmptyResult = false; // UTA: default value
        when(image.isEmpty()).thenReturn(isEmptyResult);
        return image;
    }

    /**
     * Parasoft Jtest UTA: Test for numberOfImageUsed(String)
     *
     * @author jakubiak
     * @see ImageService#numberOfImageUsed(String)
     */
    @Test
    public void testNumberOfImageUsed() throws Throwable {
        // Given
        ImageService underTest = new ImageService();
        CategoryService categoryServiceValue = mockCategoryService();
        ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);
        ItemService itemServiceValue = mockItemService();
        ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);

        // When
        String imagePath = ""; // UTA: default value
        long result = underTest.numberOfImageUsed(imagePath);

        // Then
        // assertEquals(0L, result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of CategoryService
     */
    private static CategoryService mockCategoryService() throws Throwable {
        CategoryService categoryServiceValue = mock(CategoryService.class);
        long numberOfImageUsedInCategoriesResult = 0L; // UTA: default value
        when(categoryServiceValue.numberOfImageUsedInCategories(nullable(String.class))).thenReturn(numberOfImageUsedInCategoriesResult);
        return categoryServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ItemService
     */
    private static ItemService mockItemService() throws Throwable {
        ItemService itemServiceValue = mock(ItemService.class);
        long numberOfImageUsedInItemsResult = 0L; // UTA: default value
        when(itemServiceValue.numberOfImageUsedInItems(nullable(String.class))).thenReturn(numberOfImageUsedInItemsResult);
        return itemServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for removeAllIndustriesUploadedImages()
     *
     * @author jakubiak
     * @see ImageService#removeAllIndustriesUploadedImages()
     */
    @Test
    public void testRemoveAllIndustriesUploadedImages() throws Throwable {
        // Given
        ImageService underTest = new ImageService();
        WebConfig webConfigValue = mockWebConfig3();
        ReflectionTestUtils.setField(underTest, "webConfig", webConfigValue);

        // When
        boolean result = underTest.removeAllIndustriesUploadedImages();

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of WebConfig
     */
    private static WebConfig mockWebConfig3() throws Throwable {
        WebConfig webConfigValue = mock(WebConfig.class);
        String getUploadedImagesStorePathResult = ""; // UTA: default value
        when(webConfigValue.getUploadedImagesStorePath()).thenReturn(getUploadedImagesStorePathResult);
        return webConfigValue;
    }

    /**
     * Parasoft Jtest UTA: Test for removeSpecificIndustryUploadedImages(IndustryType)
     *
     * @author jakubiak
     * @see ImageService#removeSpecificIndustryUploadedImages(IndustryType)
     */
    @Test
    public void testRemoveSpecificIndustryUploadedImages() throws Throwable {
        // Given
        ImageService underTest = new ImageService();
        WebConfig webConfigValue = mockWebConfig4();
        ReflectionTestUtils.setField(underTest, "webConfig", webConfigValue);

        // When
        IndustryType industry = IndustryType.AEROSPACE; // UTA: default value
        boolean result = underTest.removeSpecificIndustryUploadedImages(industry);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of WebConfig
     */
    private static WebConfig mockWebConfig4() throws Throwable {
        WebConfig webConfigValue = mock(WebConfig.class);
        String getUploadedImagesStorePathResult = ""; // UTA: default value
        when(webConfigValue.getUploadedImagesStorePath()).thenReturn(getUploadedImagesStorePathResult);
        return webConfigValue;
    }
}