package com.parasoft.demoapp.defaultdata;


import org.junit.Test;


/**
 * Parasoft Jtest UTA: Test class for ClearEntrance
 *
 * @author jakubiak
 * @see ClearEntrance
 */
public class ClearEntranceTest {
    /**
     * Parasoft Jtest UTA: Test for run()
     *
     * @author jakubiak
     * @see ClearEntrance#run()
     */
    @Test
    public void testRun() throws Throwable {
        // Given
        ClearEntrance underTest = new ClearEntrance();

        // When
        underTest.run();

    }
}