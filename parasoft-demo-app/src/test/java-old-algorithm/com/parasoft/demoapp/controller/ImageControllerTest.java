package com.parasoft.demoapp.controller;


import com.parasoft.demoapp.service.ImageService;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ImageController
 *
 * @author jakubiak
 * @see ImageController
 */
public class ImageControllerTest {
    /**
     * Parasoft Jtest UTA: Test for imageDelete(String)
     *
     * @author jakubiak
     * @see ImageController#imageDelete(String)
     */
    @Test
    public void testImageDelete() throws Throwable {
        // Given
        ImageController underTest = new ImageController();
        ImageService imageServiceValue = mockImageService();
        ReflectionTestUtils.setField(underTest, "imageService", imageServiceValue);

        // When
        String imagePath = ""; // UTA: default value
        ResponseResult<String> result = underTest.imageDelete(imagePath);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ImageService
     */
    private static ImageService mockImageService() throws Throwable {
        ImageService imageServiceValue = mock(ImageService.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                String imagePath = (String) invocation.getArguments()[0];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(imageServiceValue).deleteUploadedImageByPath(nullable(String.class));
        return imageServiceValue;
    }

    /**
     * Parasoft Jtest UTA: Test for imageUpload(MultipartFile)
     *
     * @author jakubiak
     * @see ImageController#imageUpload(MultipartFile)
     */
    @Test
    public void testImageUpload() throws Throwable {
        // Given
        ImageController underTest = new ImageController();
        ImageService imageServiceValue = mockImageService2();
        ReflectionTestUtils.setField(underTest, "imageService", imageServiceValue);

        // When
        MultipartFile image = mockMultipartFile();
        ResponseResult<String> result = underTest.imageUpload(image);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of ImageService
     */
    private static ImageService mockImageService2() throws Throwable {
        ImageService imageServiceValue = mock(ImageService.class);
        String handleImageAndReturnStaticLocationResult = ""; // UTA: default value
        when(imageServiceValue.handleImageAndReturnStaticLocation(nullable(MultipartFile.class))).thenReturn(handleImageAndReturnStaticLocationResult);
        return imageServiceValue;
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
}