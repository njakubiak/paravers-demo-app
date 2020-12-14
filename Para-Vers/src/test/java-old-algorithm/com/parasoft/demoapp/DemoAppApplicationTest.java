package com.parasoft.demoapp;


import org.junit.Test;


/**
 * Parasoft Jtest UTA: Test class for DemoAppApplication
 *
 * @author jakubiak
 * @see DemoAppApplication
 */
public class DemoAppApplicationTest {
    /**
     * Parasoft Jtest UTA: Test for main(String[])
     *
     * @author jakubiak
     * @see DemoAppApplication#main(String[])
     */
    @Test
    public void testMain() throws Throwable {
        // When
        String[] args = new java.lang.String[0]; // UTA: default value
        DemoAppApplication.main(args);

    }
}