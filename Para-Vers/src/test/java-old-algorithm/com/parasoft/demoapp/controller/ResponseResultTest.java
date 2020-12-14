package com.parasoft.demoapp.controller;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ResponseResult
 *
 * @author jakubiak
 * @see ResponseResult
 */
public class ResponseResultTest {
    /**
     * Parasoft Jtest UTA: Test for getData()
     *
     * @author jakubiak
     * @see ResponseResult#getData()
     */
    @Test
    public void testGetData() throws Throwable {
        // Given
        ResponseResult underTest = new ResponseResult();

        // When
        Object result = underTest.getData();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for getInstance(Integer)
     *
     * @author jakubiak
     * @see ResponseResult#getInstance(Integer)
     */
    @Test
    public void testGetInstance() throws Throwable {
        // When
        Integer status = 0; // UTA: default value
        ResponseResult<Object> result = ResponseResult.getInstance(status);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for getInstance(Integer, String)
     *
     * @author jakubiak
     * @see ResponseResult#getInstance(Integer, String)
     */
    @Test
    public void testGetInstance2() throws Throwable {
        // When
        Integer status = 0; // UTA: default value
        String message = ""; // UTA: default value
        ResponseResult<Object> result = ResponseResult.getInstance(status, message);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for getInstance(Integer, String, T)
     *
     * @author jakubiak
     * @see ResponseResult#getInstance(Integer, String, T)
     */
    @Test
    public void testGetInstance3() throws Throwable {
        // When
        Integer status = 0; // UTA: default value
        String message = ""; // UTA: default value
        Object data = new Object(); // UTA: default value
        ResponseResult<Object> result = ResponseResult.getInstance(status, message, data);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for getInstance(Throwable)
     *
     * @author jakubiak
     * @see ResponseResult#getInstance(Throwable)
     */
    @Test
    public void testGetInstance4() throws Throwable {
        // When
        Throwable throwable = mockThrowable();
        ResponseResult<Object> result = ResponseResult.getInstance(throwable);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Throwable
     */
    private static Throwable mockThrowable() throws Throwable {
        Throwable throwable = mock(Throwable.class);
        String getMessageResult = ""; // UTA: default value
        when(throwable.getMessage()).thenReturn(getMessageResult);
        return throwable;
    }

    /**
     * Parasoft Jtest UTA: Test for getMessage()
     *
     * @author jakubiak
     * @see ResponseResult#getMessage()
     */
    @Test
    public void testGetMessage() throws Throwable {
        // Given
        ResponseResult underTest = new ResponseResult();

        // When
        String result = underTest.getMessage();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getStatus()
     *
     * @author jakubiak
     * @see ResponseResult#getStatus()
     */
    @Test
    public void testGetStatus() throws Throwable {
        // Given
        ResponseResult underTest = new ResponseResult();

        // When
        Integer result = underTest.getStatus();

        // Then
        // assertEquals(0, result.intValue());
    }

    /**
     * Parasoft Jtest UTA: Test for setData(T)
     *
     * @author jakubiak
     * @see ResponseResult#setData(T)
     */
    @Test
    public void testSetData() throws Throwable {
        // Given
        ResponseResult underTest = new ResponseResult();

        // When
        Object data = new Object(); // UTA: default value
        underTest.setData(data);

    }

    /**
     * Parasoft Jtest UTA: Test for setMessage(String)
     *
     * @author jakubiak
     * @see ResponseResult#setMessage(String)
     */
    @Test
    public void testSetMessage() throws Throwable {
        // Given
        ResponseResult underTest = new ResponseResult();

        // When
        String message = ""; // UTA: default value
        underTest.setMessage(message);

    }

    /**
     * Parasoft Jtest UTA: Test for setStatus(Integer)
     *
     * @author jakubiak
     * @see ResponseResult#setStatus(Integer)
     */
    @Test
    public void testSetStatus() throws Throwable {
        // Given
        ResponseResult underTest = new ResponseResult();

        // When
        Integer status = 0; // UTA: default value
        underTest.setStatus(status);

    }
}