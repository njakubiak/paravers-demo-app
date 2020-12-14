package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.global.RoleEntity;
import com.parasoft.demoapp.repository.global.RoleRepository;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for RoleService
 *
 * @see RoleService
 * @author jakubiak
 */
public class RoleServiceTest
{
    /**
     * Parasoft Jtest UTA: Test for getRoleByRoleName(String)
     *
     * @author jakubiak
     * @see RoleService#getRoleByRoleName(String)
     */
    @Test
    public void testGetRoleByRoleName() throws Throwable {
        // Given
        RoleService underTest = new RoleService();
        RoleRepository roleRepositoryValue = mockRoleRepository();
        ReflectionTestUtils.setField(underTest, "roleRepository", roleRepositoryValue);

        // When
        String name = ""; // UTA: default value
        RoleEntity result = underTest.getRoleByRoleName(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of RoleRepository
     */
    private static RoleRepository mockRoleRepository() throws Throwable {
        RoleRepository roleRepositoryValue = mock(RoleRepository.class);
        RoleEntity findByNameResult = mock(RoleEntity.class);
        when(roleRepositoryValue.findByName(nullable(String.class))).thenReturn(findByNameResult);
        return roleRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for roleExists(String)
     *
     * @author jakubiak
     * @see RoleService#roleExists(String)
     */
    @Test
    public void testRoleExists() throws Throwable {
        // Given
        RoleService underTest = new RoleService();
        RoleRepository roleRepositoryValue = mockRoleRepository2();
        ReflectionTestUtils.setField(underTest, "roleRepository", roleRepositoryValue);

        // When
        String roleName = ""; // UTA: default value
        boolean result = underTest.roleExists(roleName);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of RoleRepository
     */
    private static RoleRepository mockRoleRepository2() throws Throwable {
        RoleRepository roleRepositoryValue = mock(RoleRepository.class);
        boolean existsByNameResult = false; // UTA: default value
        when(roleRepositoryValue.existsByName(nullable(String.class))).thenReturn(existsByNameResult);
        return roleRepositoryValue;
    }
}