package com.parasoft.demoapp.defaultdata.global;


import org.junit.Test;


/**
 * Parasoft Jtest UTA: Test class for DatabaseInitResultTableCreator
 *
 * @author jakubiak
 * @see DatabaseInitResultTableCreator
 */
public class DatabaseInitResultTableCreatorTest {
    /**
     * Parasoft Jtest UTA: Test for populateTables()
     *
     * @author jakubiak
     * @see DatabaseInitResultTableCreator#populateTables()
     */
    @Test
    public void testPopulateTables() throws Throwable {
        // Given
        DatabaseInitResultTableCreator underTest = new DatabaseInitResultTableCreator();

        // When
        underTest.populateTables();

    }

    /**
     * Parasoft Jtest UTA: Test for switchIndustry()
     *
     * @author jakubiak
     * @see DatabaseInitResultTableCreator#switchIndustry()
     */
    @Test
    public void testSwitchIndustry() throws Throwable {
        // Given
        DatabaseInitResultTableCreator underTest = new DatabaseInitResultTableCreator();

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
        DatabaseInitResultTableCreator underTest = new DatabaseInitResultTableCreator();

        // When
        underTest.create();

    }
}