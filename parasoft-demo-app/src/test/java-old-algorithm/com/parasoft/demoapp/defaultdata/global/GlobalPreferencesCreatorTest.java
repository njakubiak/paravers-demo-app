package com.parasoft.demoapp.defaultdata.global;


import org.junit.Test;


/**
 * Parasoft Jtest UTA: Test class for GlobalPreferencesCreator
 *
 * @see GlobalPreferencesCreator
 * @author jakubiak
 */
public class GlobalPreferencesCreatorTest
{
    /**
     * Parasoft Jtest UTA: Test for switchIndustry()
     *
     * @author jakubiak
     * @see GlobalPreferencesCreator#switchIndustry()
     */
    @Test
    public void testSwitchIndustry() throws Throwable {
        // Given
        GlobalPreferencesCreator underTest = new GlobalPreferencesCreator();

        // When
        underTest.switchIndustry();

    }

    /**
     * Parasoft Jtest UTA: Test for create()
     *
     * @author jakubiak
     * @see com.parasoft.demoapp.defaultdata.AbstractDataCreator#create()
     */
    @Test
    public void testCreate() throws Throwable {
        // Given
        GlobalPreferencesCreator underTest = new GlobalPreferencesCreator();

        // When
        underTest.create();

    }
}