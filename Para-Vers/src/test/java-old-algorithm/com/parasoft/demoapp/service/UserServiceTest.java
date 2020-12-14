package com.parasoft.demoapp.service;


import com.parasoft.demoapp.model.global.UserEntity;
import com.parasoft.demoapp.repository.global.UserRepository;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for UserService
 *
 * @see UserService
 * @author jakubiak
 */
public class UserServiceTest
{
    /**
     * Parasoft Jtest UTA: Test for getUserByUsername(String)
     *
     * @author jakubiak
     * @see UserService#getUserByUsername(String)
     */
    @Test
    public void testGetUserByUsername() throws Throwable {
        // Given
        UserService underTest = new UserService();
        UserRepository userRepositoryValue = mockUserRepository();
        ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

        // When
        String username = ""; // UTA: default value
        UserEntity result = underTest.getUserByUsername(username);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
     */
    private static UserRepository mockUserRepository() throws Throwable {
        UserRepository userRepositoryValue = mock(UserRepository.class);
        UserEntity findByUsernameResult = mock(UserEntity.class);
        when(userRepositoryValue.findByUsername(nullable(String.class))).thenReturn(findByUsernameResult);
        return userRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for removeUser(Long)
     *
     * @author jakubiak
     * @see UserService#removeUser(Long)
     */
    @Test
    public void testRemoveUser() throws Throwable {
        // Given
        UserService underTest = new UserService();
        UserRepository userRepositoryValue = mockUserRepository2();
        ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

        // When
        Long id = 0L; // UTA: default value
        underTest.removeUser(id);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
     */
    private static UserRepository mockUserRepository2() throws Throwable {
        UserRepository userRepositoryValue = mock(UserRepository.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Long id = (Long) invocation.getArguments()[0];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(userRepositoryValue).deleteById(nullable(Long.class));

        boolean existsByIdResult = false; // UTA: default value
        when(userRepositoryValue.existsById(nullable(Long.class))).thenReturn(existsByIdResult);
        return userRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for userExist(String)
     *
     * @author jakubiak
     * @see UserService#userExist(String)
     */
    @Test
    public void testUserExist() throws Throwable {
        // Given
        UserService underTest = new UserService();
        UserRepository userRepositoryValue = mockUserRepository3();
        ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

        // When
        String username = ""; // UTA: default value
        boolean result = underTest.userExist(username);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
     */
    private static UserRepository mockUserRepository3() throws Throwable {
        UserRepository userRepositoryValue = mock(UserRepository.class);
        boolean existsByUsernameResult = false; // UTA: default value
        when(userRepositoryValue.existsByUsername(nullable(String.class))).thenReturn(existsByUsernameResult);
        return userRepositoryValue;
    }
}