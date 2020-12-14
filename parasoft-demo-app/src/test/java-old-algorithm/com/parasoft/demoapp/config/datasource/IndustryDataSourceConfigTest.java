package com.parasoft.demoapp.config.datasource;


import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for IndustryDataSourceConfig
 *
 * @see IndustryDataSourceConfig
 * @author jakubiak
 */
public class IndustryDataSourceConfigTest
{
    /**
     * Parasoft Jtest UTA: Test for getIndustryDataSources()
     *
     * @author jakubiak
     * @see IndustryDataSourceConfig#getIndustryDataSources()
     */
    @Test
    public void testGetIndustryDataSources() throws Throwable {
        // Given
        IndustryDataSourceConfig underTest = new IndustryDataSourceConfig();

        // When
        Map<Object, Object> result = underTest.getIndustryDataSources();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.containsKey(null));
        // assertTrue(result.containsValue(null));
    }

    /**
     * Parasoft Jtest UTA: Test for industryTransactionManager(EntityManagerFactory)
     *
     * @author jakubiak
     * @see IndustryDataSourceConfig#industryTransactionManager(EntityManagerFactory)
     */
    @Test
    public void testIndustryTransactionManager() throws Throwable {
        // Given
        IndustryDataSourceConfig underTest = new IndustryDataSourceConfig();

        // When
        EntityManagerFactory entityManagerFactory = mockEntityManagerFactory();
        PlatformTransactionManager result = underTest.industryTransactionManager(entityManagerFactory);

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