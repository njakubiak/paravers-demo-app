/**
 * 
 */
package com.parasoft.demoapp.defaultdata.global;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.parasoft.demoapp.model.global.UserEntity;
import com.parasoft.demoapp.repository.global.RoleRepository;
import com.parasoft.demoapp.service.RoleService;
import com.parasoft.demoapp.service.TestFactory;
import com.parasoft.demoapp.service.UserService;

/**
 * Parasoft Jtest UTA: Test class for GlobalUsersCreator
 *
 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator
 * @author jakubiak
 */
public class GlobalUsersCreatorTest {

	/**
	 * Parasoft Jtest UTA: Test for populateData()
	 *
	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#populateData()
	 * @author jakubiak
	 */
	@Test
	public void testPopulateData() throws Throwable {
		// Given
		GlobalUsersCreator underTest = new GlobalUsersCreator();
		RoleService roleService = new RoleService();
		RoleRepository roleRepositoryValue = TestFactory.createRoleRepository();
		ReflectionTestUtils.setField(roleService, "roleRepository", roleRepositoryValue);
		ReflectionTestUtils.setField(underTest, "roleService", roleService);
		UserService userServiceValue = mockUserService();
		ReflectionTestUtils.setField(underTest, "userService", userServiceValue);

		// When
		underTest.populateData();
		
		assertTrue(roleService.roleExists("ROLE_PURCHASER"));

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of UserService
	 */
	private static UserService mockUserService() throws Throwable {
		UserService userServiceValue = mock(UserService.class);
		UserEntity addNewUserResult = mock(UserEntity.class);
		when(userServiceValue.addNewUser(nullable(String.class), nullable(String.class))).thenReturn(addNewUserResult);
		return userServiceValue;
	}
}