package com.parasoft.demoapp.util;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for SqlStringEscapeUtil
 *
 * @author jakubiak
 * @see SqlStringEscapeUtil
 */
public class SqlStringEscapeUtilTest {
    /**
     * Parasoft Jtest UTA: Test for escapeLikeString(String)
     *
     * @author jakubiak
     * @see SqlStringEscapeUtil#escapeLikeString(String)
     */
    @Test
    public void testEscapeLikeString() throws Throwable {
        // When
        String str = ""; // UTA: default value
        String result = SqlStringEscapeUtil.escapeLikeString(str);

        // Then
        // assertEquals("", result);
    }
}