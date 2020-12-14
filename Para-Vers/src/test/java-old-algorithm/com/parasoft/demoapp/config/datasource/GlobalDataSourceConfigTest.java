package com.parasoft.demoapp.config.datasource;


import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for GlobalDataSourceConfig
 *
 * @see GlobalDataSourceConfig
 * @author jakubiak
 */
public class GlobalDataSourceConfigTest
{
    /**
     * Parasoft Jtest UTA: Test for globalTransactionManager(EntityManagerFactory)
     *
     * @author jakubiak
     * @see GlobalDataSourceConfig#globalTransactionManager(EntityManagerFactory)
     */
    @Test
    public void testGlobalTransactionManager() throws Throwable {
        // Given
        GlobalDataSourceConfig underTest = new GlobalDataSourceConfig();

        // When
        EntityManagerFactory entityManagerFactory = mockEntityManagerFactory();
        PlatformTransactionManager result = underTest.globalTransactionManager(entityManagerFactory);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of EntityManagerFactory
     */
    private static EntityManagerFactory mockEntityManagerFactory() throws Throwable {
        EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
        return entityManagerFactory;
    }
}