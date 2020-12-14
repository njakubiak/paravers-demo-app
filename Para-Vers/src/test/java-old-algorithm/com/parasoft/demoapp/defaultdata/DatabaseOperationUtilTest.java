package com.parasoft.demoapp.defaultdata;


import org.junit.Test;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for DatabaseOperationUtil
 *
 * @author jakubiak
 * @see DatabaseOperationUtil
 */
public class DatabaseOperationUtilTest {
    /**
     * Parasoft Jtest UTA: Test for executeSqlScript(DataSource, Resource)
     *
     * @author jakubiak
     * @see DatabaseOperationUtil#executeSqlScript(DataSource, Resource)
     */
    @Test
    public void testExecuteSqlScript() throws Throwable {
        // When
        DataSource dataSource = mock(DataSource.class);
        Resource script = mock(Resource.class);
        DatabaseOperationUtil.executeSqlScript(dataSource, script);

    }
}