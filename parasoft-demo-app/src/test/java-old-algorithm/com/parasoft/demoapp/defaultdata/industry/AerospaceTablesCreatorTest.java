package com.parasoft.demoapp.defaultdata.industry;


import org.junit.Test;


/**
 * Parasoft Jtest UTA: Test class for AerospaceTablesCreator
 *
 * @author jakubiak
 * @see AerospaceTablesCreator
 */
public class AerospaceTablesCreatorTest {
    /**
     * Parasoft Jtest UTA: Test for switchIndustry()
     *
     * @author jakubiak
     * @see AerospaceTablesCreator#switchIndustry()
     */
    @Test
    public void testSwitchIndustry() throws Throwable {
        // Given
        AerospaceTablesCreator underTest = new AerospaceTablesCreator();

        // When
        underTest.switchIndustry();

    }

    /**
     * Parasoft Jtest UTA: Test for populateTables()
     *
     * @author jakubiak
     * @see AbstractIndustryTablesCreator#populateTables()
     */
    @Test
    public void testPopulateTables() throws Throwable {
        // Given
        AerospaceTablesCreator underTest = new AerospaceTablesCreator();

        // When
        underTest.populateTables();

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
        AerospaceTablesCreator underTest = new AerospaceTablesCreator();

        // When
        underTest.create();

    }
}