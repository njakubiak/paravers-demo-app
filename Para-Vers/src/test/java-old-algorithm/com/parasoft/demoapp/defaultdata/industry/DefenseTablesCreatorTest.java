package com.parasoft.demoapp.defaultdata.industry;


import org.junit.Test;


/**
 * Parasoft Jtest UTA: Test class for DefenseTablesCreator
 *
 * @author jakubiak
 * @see DefenseTablesCreator
 */
public class DefenseTablesCreatorTest {
    /**
     * Parasoft Jtest UTA: Test for switchIndustry()
     *
     * @author jakubiak
     * @see DefenseTablesCreator#switchIndustry()
     */
    @Test
    public void testSwitchIndustry() throws Throwable {
        // Given
        DefenseTablesCreator underTest = new DefenseTablesCreator();

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
        DefenseTablesCreator underTest = new DefenseTablesCreator();

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
        DefenseTablesCreator underTest = new DefenseTablesCreator();

        // When
        underTest.create();

    }
}