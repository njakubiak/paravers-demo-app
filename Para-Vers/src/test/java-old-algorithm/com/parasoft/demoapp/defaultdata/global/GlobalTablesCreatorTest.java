package com.parasoft.demoapp.defaultdata.global;


import org.junit.Test;


/**
 * Parasoft Jtest UTA: Test class for GlobalTablesCreator
 *
 * @author jakubiak
 * @see GlobalTablesCreator
 */
public class GlobalTablesCreatorTest {
    /**
     * Parasoft Jtest UTA: Test for populateTables()
     *
     * @author jakubiak
     * @see GlobalTablesCreator#populateTables()
     */
    @Test
    public void testPopulateTables() throws Throwable {
        // Given
        GlobalTablesCreator underTest = new GlobalTablesCreator();

        // When
        underTest.populateTables();

    }

    /**
     * Parasoft Jtest UTA: Test for switchIndustry()
     *
     * @author jakubiak
     * @see GlobalTablesCreator#switchIndustry()
     */
    @Test
    public void testSwitchIndustry() throws Throwable {
        // Given
        GlobalTablesCreator underTest = new GlobalTablesCreator();

        // When
        underTest.switchIndustry();

    }

    /**
     * Parasoft Jtest UTA: Test for create()
     *
     * @author jakubiak
     * @see com.parasoft.demoapp.defaultdata.AbstractTablesCreator#create()
     */
    @Test
    public void testCreate() throws Throwable {
        // Given
        GlobalTablesCreator underTest = new GlobalTablesCreator();

        // When
        underTest.create();

    }
}