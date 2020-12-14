package com.parasoft.demoapp.exception;


import com.parasoft.demoapp.controller.ResponseResult;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ExceptionHandlers
 *
 * @author jakubiak
 * @see ExceptionHandlers
 */
public class ExceptionHandlersTest {
    /**
     * Parasoft Jtest UTA: Test for categoryHasAtLeastOneItemExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#categoryHasAtLeastOneItemExceptionHandler(Exception)
     */
    @Test
    public void testCategoryHasAtLeastOneItemExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException();
        ResponseResult<Void> result = underTest.categoryHasAtLeastOneItemExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for endpointInvalidExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#endpointInvalidExceptionHandler(Exception)
     */
    @Test
    public void testEndpointInvalidExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException2();
        ResponseResult<Void> result = underTest.endpointInvalidExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException2() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for exceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#exceptionHandler(Exception)
     */
    @Test
    public void testExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException3();
        ResponseResult<Void> result = underTest.exceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException3() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for incorrectOperationExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#incorrectOperationExceptionHandler(Exception)
     */
    @Test
    public void testIncorrectOperationExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException4();
        ResponseResult<Void> result = underTest.incorrectOperationExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException4() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for noPermissionExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#noPermissionExceptionHandler(Exception)
     */
    @Test
    public void testNoPermissionExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException5();
        ResponseResult<Void> result = underTest.noPermissionExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException5() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for parameterExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#parameterExceptionHandler(Exception)
     */
    @Test
    public void testParameterExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException6();
        ResponseResult<Void> result = underTest.parameterExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException6() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for resourceExistsAlreadyExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#resourceExistsAlreadyExceptionHandler(Exception)
     */
    @Test
    public void testResourceExistsAlreadyExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException7();
        ResponseResult<Void> result = underTest.resourceExistsAlreadyExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException7() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for resourceNotFoundExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#resourceNotFoundExceptionHandler(Exception)
     */
    @Test
    public void testResourceNotFoundExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException8();
        ResponseResult<Void> result = underTest.resourceNotFoundExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException8() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for unsupportedOperationInCurrentIndustryExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#unsupportedOperationInCurrentIndustryExceptionHandler(Exception)
     */
    @Test
    public void testUnsupportedOperationInCurrentIndustryExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException9();
        ResponseResult<Void> result = underTest.unsupportedOperationInCurrentIndustryExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException9() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }

    /**
     * Parasoft Jtest UTA: Test for virtualizeServerUrlExceptionHandler(Exception)
     *
     * @author jakubiak
     * @see ExceptionHandlers#virtualizeServerUrlExceptionHandler(Exception)
     */
    @Test
    public void testVirtualizeServerUrlExceptionHandler() throws Throwable {
        // Given
        ExceptionHandlers underTest = new ExceptionHandlers();

        // When
        Exception e = mockException10();
        ResponseResult<Void> result = underTest.virtualizeServerUrlExceptionHandler(e);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Exception
     */
    private static Exception mockException10() throws Throwable {
        Exception e = mock(Exception.class);
        String getMessageResult = ""; // UTA: default value
        when(e.getMessage()).thenReturn(getMessageResult);
        return e;
    }
}