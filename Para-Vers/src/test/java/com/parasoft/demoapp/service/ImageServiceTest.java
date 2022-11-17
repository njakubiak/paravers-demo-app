/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.config.WebConfig;
import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import java.lang.reflect.Field;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Parasoft Jtest UTA: Test class for ImageService
 *
 * @see com.parasoft.demoapp.service.ImageService
 * @author jakubiak
 */
public class ImageServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for deleteUploadedImageByPath(String)
	 *
	 * @see com.parasoft.demoapp.service.ImageService#deleteUploadedImageByPath(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testDeleteUploadedImageByPath2() throws Throwable {
		// Given
		ImageService underTest = new ImageService();

		// When
		String imagePath = null; // UTA: provided value
		underTest.deleteUploadedImageByPath(imagePath);

	}

	/**
	 * Parasoft Jtest UTA: Test for deleteUploadedImageByPath(String)
	 *
	 * @see com.parasoft.demoapp.service.ImageService#deleteUploadedImageByPath(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testDeleteUploadedImageByPath3() throws Throwable {
		// Given
		ImageService underTest = new ImageService();

		// When
		String imagePath = ""; // UTA: provided value
		underTest.deleteUploadedImageByPath(imagePath);

	}

	/**
	 * Parasoft Jtest UTA: Test for getDefaultImage()
	 *
	 * @see com.parasoft.demoapp.service.ImageService#getDefaultImage()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetDefaultImage() throws Throwable {
		// Given
		ImageService underTest = new ImageService();

		// When
		String result = underTest.getDefaultImage();

		// Then - assertions for result of method getDefaultImage()
		assertEquals("/defense/images/defaultImage.png", result);

	}

	/**
	 * Parasoft Jtest UTA: Test for handleImageAndReturnStaticLocation(MultipartFile)
	 *
	 * @see com.parasoft.demoapp.service.ImageService#handleImageAndReturnStaticLocation(MultipartFile)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testHandleImageAndReturnStaticLocation() throws Throwable {
		// Given
		ImageService underTest = new ImageService();

		// When
		MultipartFile image = null; // UTA: provided value
		underTest.handleImageAndReturnStaticLocation(image);

	}

	/**
	 * Parasoft Jtest UTA: Test for handleImageAndReturnStaticLocation(MultipartFile)
	 *
	 * @see com.parasoft.demoapp.service.ImageService#handleImageAndReturnStaticLocation(MultipartFile)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testHandleImageAndReturnStaticLocation2() throws Throwable {
		// Given
		ImageService underTest = new ImageService();

		// When
		MultipartFile image = mockMultipartFile();
		underTest.handleImageAndReturnStaticLocation(image);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of MultipartFile
	 */
	private static MultipartFile mockMultipartFile() throws Throwable {
		MultipartFile image = mock(MultipartFile.class);
		boolean isEmptyResult = true; // UTA: provided value
		when(image.isEmpty()).thenReturn(isEmptyResult);
		return image;
	}

	/**
	 * Parasoft Jtest UTA: Test for numberOfImageUsed(String)
	 *
	 * @see com.parasoft.demoapp.service.ImageService#numberOfImageUsed(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testNumberOfImageUsed() throws Throwable {
		// Given
		ImageService underTest = new ImageService();

		// When
		String imagePath = null; // UTA: provided value
		long result = underTest.numberOfImageUsed(imagePath);

		// Then - assertions for result of method numberOfImageUsed(String)
		assertEquals(0L, result);

	}

	/**
	 * Parasoft Jtest UTA: Test for numberOfImageUsed(String)
	 *
	 * @see com.parasoft.demoapp.service.ImageService#numberOfImageUsed(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testNumberOfImageUsed2() throws Throwable {
		// Given
		ImageService underTest = new ImageService();
		CategoryService categoryServiceValue = mock(CategoryService.class);
		ReflectionTestUtils.setField(underTest, "categoryService", categoryServiceValue);
		ItemService itemServiceValue = mock(ItemService.class);
		ReflectionTestUtils.setField(underTest, "itemService", itemServiceValue);

		// When
		String imagePath = "imagePath"; // UTA: default value
		long result = underTest.numberOfImageUsed(imagePath);

		// Then - assertions for result of method numberOfImageUsed(String)
		assertEquals(0L, result);

	}

	/**
	 * Parasoft Jtest UTA: Test for removeAllIndustriesUploadedImages()
	 *
	 * @see com.parasoft.demoapp.service.ImageService#removeAllIndustriesUploadedImages()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRemoveAllIndustriesUploadedImages() throws Throwable {
		// Given
		ImageService underTest = new ImageService();
		WebConfig webConfigValue = mockWebConfig();
		ReflectionTestUtils.setField(underTest, "webConfig", webConfigValue);

		// When
		boolean result = underTest.removeAllIndustriesUploadedImages();

		// Then - assertions for result of method removeAllIndustriesUploadedImages()
		assertTrue(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of WebConfig
	 */
	private static WebConfig mockWebConfig() throws Throwable {
		WebConfig webConfigValue = mock(WebConfig.class);
		String getUploadedImagesStorePathResult = "getUploadedImagesStorePathResult"; // UTA: default value
		when(webConfigValue.getUploadedImagesStorePath()).thenReturn(getUploadedImagesStorePathResult);
		return webConfigValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for removeSpecificIndustryUploadedImages(IndustryType)
	 *
	 * @see com.parasoft.demoapp.service.ImageService#removeSpecificIndustryUploadedImages(IndustryType)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRemoveSpecificIndustryUploadedImages() throws Throwable {
		// Given
		ImageService underTest = new ImageService();
		WebConfig webConfigValue = mockWebConfig2();
		ReflectionTestUtils.setField(underTest, "webConfig", webConfigValue);

		// When
		IndustryType industry = IndustryType.DEFENSE; // UTA: default value
		boolean result = underTest.removeSpecificIndustryUploadedImages(industry);

		// Then - assertions for result of method removeSpecificIndustryUploadedImages(IndustryType)
		assertTrue(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of WebConfig
	 */
	private static WebConfig mockWebConfig2() throws Throwable {
		WebConfig webConfigValue = mock(WebConfig.class);
		String getUploadedImagesStorePathResult = "getUploadedImagesStorePathResult"; // UTA: default value
		when(webConfigValue.getUploadedImagesStorePath()).thenReturn(getUploadedImagesStorePathResult);
		return webConfigValue;
	}
}