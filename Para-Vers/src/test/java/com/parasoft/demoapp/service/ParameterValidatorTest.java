/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.parasoft.demoapp.exception.ParameterException;
import org.junit.Test;

/**
 * Parasoft Jtest UTA: Test class for ParameterValidator
 *
 * @see com.parasoft.demoapp.service.ParameterValidator
 * @author jakubiak
 */
public class ParameterValidatorTest {

	/**
	 * Parasoft Jtest UTA: Test for requireNonBlank(CharSequence, String)
	 *
	 * @see com.parasoft.demoapp.service.ParameterValidator#requireNonBlank(CharSequence, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRequireNonBlank() throws Throwable {
		// When
		CharSequence cs = "cs"; // UTA: default value
		String message = "message"; // UTA: default value
		ParameterValidator.requireNonBlank(cs, message);

	}

	/**
	 * Parasoft Jtest UTA: Test for requireNonNegative(int, String)
	 *
	 * @see com.parasoft.demoapp.service.ParameterValidator#requireNonNegative(int, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRequireNonNegative() throws Throwable {
		// When
		int number = 1; // UTA: provided value
		String message = "message"; // UTA: default value
		int result = ParameterValidator.requireNonNegative(number, message);

		// Then - assertions for result of method requireNonNegative(int, String)
		assertEquals(1, result);

	}

	/**
	 * Parasoft Jtest UTA: Test for requireNonNegative(int, String)
	 *
	 * @see com.parasoft.demoapp.service.ParameterValidator#requireNonNegative(int, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testRequireNonNegative2() throws Throwable {
		// When
		int number = -1; // UTA: provided value
		String message = "message"; // UTA: default value
		ParameterValidator.requireNonNegative(number, message);

	}

	/**
	 * Parasoft Jtest UTA: Test for requireNonNull(T, String)
	 *
	 * @see com.parasoft.demoapp.service.ParameterValidator#requireNonNull(T, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRequireNonNull() throws Throwable {
		// When
		Object obj = new Object(); // UTA: default value
		String message = "message"; // UTA: default value
		Object result = ParameterValidator.requireNonNull(obj, message);

		// Then - assertions for result of method requireNonNull(Object, String)
		assertNotNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Test for requireNonNull(T, String)
	 *
	 * @see com.parasoft.demoapp.service.ParameterValidator#requireNonNull(T, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testRequireNonNull2() throws Throwable {
		// When
		Object obj = null; // UTA: provided value
		String message = "message"; // UTA: default value
		ParameterValidator.requireNonNull(obj, message);

	}

	/**
	 * Parasoft Jtest UTA: Test for requireNonZero(int, String)
	 *
	 * @see com.parasoft.demoapp.service.ParameterValidator#requireNonZero(int, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRequireNonZero() throws Throwable {
		// When
		int number = 1; // UTA: provided value
		String message = "message"; // UTA: default value
		int result = ParameterValidator.requireNonZero(number, message);

		// Then - assertions for result of method requireNonZero(int, String)
		assertEquals(1, result);

	}

	/**
	 * Parasoft Jtest UTA: Test for requireNonZero(int, String)
	 *
	 * @see com.parasoft.demoapp.service.ParameterValidator#requireNonZero(int, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testRequireNonZero2() throws Throwable {
		// When
		int number = 0; // UTA: provided value
		String message = "message"; // UTA: default value
		ParameterValidator.requireNonZero(number, message);

	}
}