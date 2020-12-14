package com.parasoft.demoapp.defaultdata.global;


import org.junit.Test;


/**
 * Parasoft Jtest UTA: Test class for GlobalUsersCreator
 *
 * @see GlobalUsersCreator
 * @author jakubiak
 */
public class GlobalUsersCreatorTest
{
    /**
     * Parasoft Jtest UTA: Test for switchIndustry()
     *
     * @author jakubiak
     * @see GlobalUsersCreator#switchIndustry()
     */
    @Test
    public void testSwitchIndustry() throws Throwable {
        // Given
        GlobalUsersCreator underTest = new GlobalUsersCreator();

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
        GlobalUsersCreator underTest = new GlobalUsersCreator();

        // When
        underTest.create();

    }
}