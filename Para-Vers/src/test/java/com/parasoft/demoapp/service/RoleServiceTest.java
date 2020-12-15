/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.parasoft.demoapp.exception.RoleNameExistsAlreadyException;
import com.parasoft.demoapp.exception.RoleNotFoundException;
import com.parasoft.demoapp.model.global.RoleEntity;
import com.parasoft.demoapp.repository.global.RoleRepository;

/**
 * Parasoft Jtest UTA: Test class for RoleService
 *
 * @see com.parasoft.demoapp.service.RoleService
 * @author jakubiak
 */
public class RoleServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for addNewRole(String)
	 *
	 * @see com.parasoft.demoapp.service.RoleService#addNewRole(String)
	 * @author jakubiak
	 */
	@Test
	public void testAddNewRole() throws Throwable {
		// Given
		RoleService underTest = new RoleService();
		RoleRepository roleRepositoryValue = TestFactory.createRoleRepository();
		ReflectionTestUtils.setField(underTest, "roleRepository", roleRepositoryValue);

		// When
		String roleName = "admin"; // UTA: default value
		RoleEntity result = underTest.addNewRole(roleName);

		// Then
		assertNotNull(result);
		assertEquals("admin", result.getName());
	}

	/**
	 * Parasoft Jtest UTA: Test for getRoleByRoleName(String)
	 *
	 * @see com.parasoft.demoapp.service.RoleService#getRoleByRoleName(String)
	 * @author jakubiak
	 */
	@Test
	public void testGetRoleByRoleName() throws Throwable {
		// Given
		String roleName = "admin";
		RoleService underTest = new RoleService();
		RoleRepository roleRepositoryValue = TestFactory.createRoleRepository();
		roleRepositoryValue.save(new RoleEntity(roleName));
		ReflectionTestUtils.setField(underTest, "roleRepository", roleRepositoryValue);

		// When
		RoleEntity result = underTest.getRoleByRoleName(roleName);

		// Then
		assertNotNull(result);
		assertEquals(roleName, result.getName());
	}

	/**
	 * Parasoft Jtest UTA: Test for roleExists(String)
	 *
	 * @see com.parasoft.demoapp.service.RoleService#roleExists(String)
	 * @author jakubiak
	 */
	@Test
	public void testRoleExists() throws Throwable {
		// Given
		String roleName = "admin";
		RoleService underTest = new RoleService();
		RoleRepository roleRepositoryValue = TestFactory.createRoleRepository();
		roleRepositoryValue.save(new RoleEntity(roleName));
		ReflectionTestUtils.setField(underTest, "roleRepository", roleRepositoryValue);

		// When
		boolean result = underTest.roleExists(roleName);

		// Then - assertions for result of method roleExists(String)
		assertTrue(result);
	}

	/**
	 * Parasoft Jtest UTA: Test for addNewRole(String)
	 *
	 * @see com.parasoft.demoapp.service.RoleService#addNewRole(String)
	 * @author jakubiak
	 */
	@Test(expected = RoleNameExistsAlreadyException.class)
	public void testAddNewRole2() throws Throwable {
		// Given
		String roleName = "admin";
		RoleService underTest = new RoleService();
		RoleRepository roleRepositoryValue = TestFactory.createRoleRepository();
		roleRepositoryValue.save(new RoleEntity(roleName));
		ReflectionTestUtils.setField(underTest, "roleRepository", roleRepositoryValue);

		// When
		underTest.addNewRole(roleName);
	}

	/**
	 * Parasoft Jtest UTA: Test for getRoleByRoleName(String)
	 *
	 * @see com.parasoft.demoapp.service.RoleService#getRoleByRoleName(String)
	 * @author jakubiak
	 */
	@Test(expected = RoleNotFoundException.class)
	public void testGetRoleByRoleName2() throws Throwable {
		// UTA: One or more of the required values have not been automatically set.
		// Review the information about the required modifications below and manually update the missing value(s).
		// 
		// To cover the code, the 'this.roleRepository.findByName(java.lang.String)' method must return 'null'.

		// Given
		RoleService underTest = new RoleService();
		RoleRepository roleRepositoryValue = TestFactory.createRoleRepository();
		ReflectionTestUtils.setField(underTest, "roleRepository", roleRepositoryValue);

		// When
		String name = ""; // UTA: default value
		RoleEntity result = underTest.getRoleByRoleName(name);

		// Then
		// assertNotNull(result);
	}
}