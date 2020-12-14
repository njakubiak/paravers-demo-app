package com.parasoft.demoapp.controller;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for PageController
 *
 * @see PageController
 * @author jakubiak
 */
public class PageControllerTest
{
    /**
     * Parasoft Jtest UTA: Test for showSwaggerUIPage()
     *
     * @author jakubiak
     * @see PageController#showSwaggerUIPage()
     */
    @Test
    public void testShowSwaggerUIPage() throws Throwable {
        // Given
        PageController underTest = new PageController();

        // When
        String result = underTest.showSwaggerUIPage();

        // Then
        // assertEquals("", result);
    }
}