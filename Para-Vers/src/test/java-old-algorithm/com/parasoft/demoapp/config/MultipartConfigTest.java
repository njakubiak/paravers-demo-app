package com.parasoft.demoapp.config;


import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for MultipartConfig
 *
 * @author jakubiak
 * @see MultipartConfig
 */
public class MultipartConfigTest {
    /**
     * Parasoft Jtest UTA: Test for multipartConfigElement()
     *
     * @author jakubiak
     * @see MultipartConfig#multipartConfigElement()
     */
    @Test
    public void testMultipartConfigElement() throws Throwable {
        // Given
        MultipartConfig underTest = new MultipartConfig();
        long bytes = 0L; // UTA: default value
        DataSize fileSizeThresholdValue = DataSize.ofBytes(bytes);
        ReflectionTestUtils.setField(underTest, "fileSizeThreshold", fileSizeThresholdValue);
        long bytes2 = 0L; // UTA: default value
        DataSize maxFileSizeValue = DataSize.ofBytes(bytes2);
        ReflectionTestUtils.setField(underTest, "maxFileSize", maxFileSizeValue);
        long bytes3 = 0L; // UTA: default value
        DataSize maxRequestSizeValue = DataSize.ofBytes(bytes3);
        ReflectionTestUtils.setField(underTest, "maxRequestSize", maxRequestSizeValue);

        // When
        MultipartConfigElement result = underTest.multipartConfigElement();

        // Then
        // assertNotNull(result);
    }
}