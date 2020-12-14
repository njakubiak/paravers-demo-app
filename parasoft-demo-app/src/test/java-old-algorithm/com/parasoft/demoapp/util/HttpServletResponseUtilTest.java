package com.parasoft.demoapp.util;


import org.junit.Test;

import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for HttpServletResponseUtil
 *
 * @author jakubiak
 * @see HttpServletResponseUtil
 */
public class HttpServletResponseUtilTest {
    /**
     * Parasoft Jtest UTA: Test for generateResponseResultJsonString(int, String, T)
     *
     * @author jakubiak
     * @see HttpServletResponseUtil#generateResponseResultJsonString(int, String, T)
     */
    @Test
    public void testGenerateResponseResultJsonString() throws Throwable {
        // When
        int code = 0; // UTA: default value
        String message = ""; // UTA: default value
        Object data = new Object(); // UTA: default value
        String result = HttpServletResponseUtil.generateResponseResultJsonString(code, message, data);

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for returnJsonErrorResponse(HttpServletResponse, int, int, String, T)
     *
     * @author jakubiak
     * @see HttpServletResponseUtil#returnJsonErrorResponse(HttpServletResponse, int, int, String, T)
     */
    @Test
    public void testReturnJsonErrorResponse() throws Throwable {
        // When
        HttpServletResponse resp = mockHttpServletResponse();
        int status = 0; // UTA: default value
        int code = 0; // UTA: default value
        String message = ""; // UTA: default value
        Object data = new Object(); // UTA: default value
        HttpServletResponseUtil.returnJsonErrorResponse(resp, status, code, message, data);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of PrintWriter
     */
    private static PrintWriter mockPrintWriter() throws Throwable {
        PrintWriter getWriterResult = mock(PrintWriter.class);
        return getWriterResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of HttpServletResponse
     */
    private static HttpServletResponse mockHttpServletResponse() throws Throwable {
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter getWriterResult = mockPrintWriter();
        when(resp.getWriter()).thenReturn(getWriterResult);
        return resp;
    }
}