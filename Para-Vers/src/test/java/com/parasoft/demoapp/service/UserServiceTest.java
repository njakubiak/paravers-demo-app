/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.exception.UserNotFoundException;
import com.parasoft.demoapp.exception.UsernameExistsAlreadyException;
import com.parasoft.demoapp.model.global.UserEntity;
import com.parasoft.demoapp.repository.global.UserRepository;
import java.lang.reflect.Field;
import org.junit.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for UserService
 *
 * @see com.parasoft.demoapp.service.UserService
 * @author jakubiak
 */
public class UserServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for addNewUser(String, String)
	 *
	 * @see com.parasoft.demoapp.service.UserService#addNewUser(String, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testAddNewUser() throws Throwable {
		// Given
		UserService underTest = new UserService();
		PasswordEncoder passwordEncoderValue = mockPasswordEncoder();
		ReflectionTestUtils.setField(underTest, "passwordEncoder", passwordEncoderValue);
		UserRepository userRepositoryValue = mockUserRepository();
		ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

		// When
		String username = "username"; // UTA: default value
		String password = "password"; // UTA: default value
		UserEntity result = underTest.addNewUser(username, password);

		// Then - assertions for result of method addNewUser(String, String)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of PasswordEncoder
	 */
	private static PasswordEncoder mockPasswordEncoder() throws Throwable {
		PasswordEncoder passwordEncoderValue = mock(PasswordEncoder.class);
		String encodeResult = "encodeResult"; // UTA: default value
		when(passwordEncoderValue.encode(nullable(CharSequence.class))).thenReturn(encodeResult);
		return passwordEncoderValue;
	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
	 */
	private static UserRepository mockUserRepository() throws Throwable {
		UserRepository userRepositoryValue = mock(UserRepository.class);
		boolean existsByUsernameResult = false; // UTA: provided value
		when(userRepositoryValue.existsByUsername(nullable(String.class))).thenReturn(existsByUsernameResult);
		return userRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for addNewUser(String, String)
	 *
	 * @see com.parasoft.demoapp.service.UserService#addNewUser(String, String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = UsernameExistsAlreadyException.class)
	public void testAddNewUser2() throws Throwable {
		// Given
		UserService underTest = new UserService();
		UserRepository userRepositoryValue = mockUserRepository2();
		ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

		// When
		String username = "username"; // UTA: default value
		String password = "password"; // UTA: default value
		underTest.addNewUser(username, password);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
	 */
	private static UserRepository mockUserRepository2() throws Throwable {
		UserRepository userRepositoryValue = mock(UserRepository.class);
		boolean existsByUsernameResult = true; // UTA: provided value
		when(userRepositoryValue.existsByUsername(nullable(String.class))).thenReturn(existsByUsernameResult);
		return userRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getUserByUsername(String)
	 *
	 * @see com.parasoft.demoapp.service.UserService#getUserByUsername(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetUserByUsername() throws Throwable {
		// Given
		UserService underTest = new UserService();
		UserRepository userRepositoryValue = mockUserRepository3();
		ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

		// When
		String username = "username"; // UTA: default value
		UserEntity result = underTest.getUserByUsername(username);

		// Then - assertions for result of method getUserByUsername(String)
		assertNotNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
	 */
	private static UserRepository mockUserRepository3() throws Throwable {
		UserRepository userRepositoryValue = mock(UserRepository.class);
		UserEntity findByUsernameResult = mock(UserEntity.class);
		when(userRepositoryValue.findByUsername(nullable(String.class))).thenReturn(findByUsernameResult);
		return userRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for getUserByUsername(String)
	 *
	 * @see com.parasoft.demoapp.service.UserService#getUserByUsername(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = UsernameNotFoundException.class)
	public void testGetUserByUsername2() throws Throwable {
		// Given
		UserService underTest = new UserService();
		UserRepository userRepositoryValue = mockUserRepository4();
		ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

		// When
		String username = "username"; // UTA: default value
		underTest.getUserByUsername(username);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
	 */
	private static UserRepository mockUserRepository4() throws Throwable {
		UserRepository userRepositoryValue = mock(UserRepository.class);
		UserEntity findByUsernameResult = null; // UTA: provided value
		when(userRepositoryValue.findByUsername(nullable(String.class))).thenReturn(findByUsernameResult);
		return userRepositoryValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for updateUser(UserEntity)
	 *
	 * @see com.parasoft.demoapp.service.UserService#updateUser(UserEntity)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = UserNotFoundException.class)
	public void testUpdateUser() throws Throwable {
		// Given
		UserService underTest = new UserService();

		// When
		UserEntity user = mockUserEntity();
		underTest.updateUser(user);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of UserEntity
	 */
	private static UserEntity mockUserEntity() throws Throwable {
		UserEntity user = mock(UserEntity.class);
		Long getIdResult = null; // UTA: provided value
		when(user.getId()).thenReturn(getIdResult);
		return user;
	}

}