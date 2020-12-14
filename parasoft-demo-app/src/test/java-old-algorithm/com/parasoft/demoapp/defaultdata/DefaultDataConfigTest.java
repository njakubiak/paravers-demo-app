package com.parasoft.demoapp.defaultdata;


import com.parasoft.demoapp.repository.global.DatabaseInitResultRepository;
import com.parasoft.demoapp.service.GlobalPreferencesService;
import com.parasoft.demoapp.service.ParasoftJDBCProxyService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for DefaultDataConfig
 *
 * @author jakubiak
 * @see DefaultDataConfig
 */
public class DefaultDataConfigTest {
    /**
     * Parasoft Jtest UTA: Test for defaultDataInitialization(DatabaseInitResultRepository, List, GlobalPreferencesService, ParasoftJDBCProxyService)
     *
     * @author jakubiak
     * @see DefaultDataConfig#defaultDataInitialization(DatabaseInitResultRepository, List, GlobalPreferencesService, ParasoftJDBCProxyService)
     */
    @Test
    public void testDefaultDataInitialization() throws Throwable {
        // Given
        DefaultDataConfig underTest = new DefaultDataConfig();

        // When
        DatabaseInitResultRepository databaseInitResultRepository = mock(DatabaseInitResultRepository.class);
        List<AbstractTablesCreator> tablesCreators = new ArrayList<AbstractTablesCreator>(); // UTA: default value
        AbstractTablesCreator item = mock(AbstractTablesCreator.class);
        tablesCreators.add(item);
        List<AbstractDataCreator> dataCreators = new ArrayList<AbstractDataCreator>(); // UTA: default value
        AbstractDataCreator item2 = mock(AbstractDataCreator.class);
        dataCreators.add(item2);
        GlobalPreferencesService globalPreferencesService = mock(GlobalPreferencesService.class);
        ParasoftJDBCProxyService parasoftJDBCProxyService = mock(ParasoftJDBCProxyService.class);
        InitializationEntrance result = underTest.defaultDataInitialization(databaseInitResultRepository, tablesCreators, dataCreators, globalPreferencesService, parasoftJDBCProxyService);

        // Then
        // assertNotNull(result);
    }
}