package com.parasoft.demoapp.defaultdata.industry;


import com.parasoft.demoapp.defaultdata.AbstractDataCreator;
import com.parasoft.demoapp.messages.DatabaseOperationMessages;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for AerospaceAssetsCreator
 *
 * @author jakubiak
 * @see AerospaceAssetsCreator
 */
public class AerospaceAssetsCreatorTest {
    /**
     * Parasoft Jtest UTA: Test for populateData()
     *
     * @author jakubiak
     * @see AerospaceAssetsCreator#populateData()
     */
    @Test
    public void testPopulateData() throws Throwable {
        // Given
        AerospaceAssetsCreator underTest = new AerospaceAssetsCreator();
        DatabaseOperationMessages messagesValue = mockDatabaseOperationMessages();
        ReflectionTestUtils.setField(underTest, "messages", messagesValue);

        // When
        underTest.populateData();

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of DatabaseOperationMessages
     */
    private static DatabaseOperationMessages mockDatabaseOperationMessages() throws Throwable {
        DatabaseOperationMessages messagesValue = mock(DatabaseOperationMessages.class);
        String getStringResult = ""; // UTA: default value
        when(messagesValue.getString(nullable(String.class))).thenReturn(getStringResult);
        return messagesValue;
    }

    /**
     * Parasoft Jtest UTA: Test for recreateData()
     *
     * @author jakubiak
     * @see AerospaceAssetsCreator#recreateData()
     */
    @Test
    public void testRecreateData() throws Throwable {
        // Given
        AerospaceAssetsCreator underTest = new AerospaceAssetsCreator();

        // When
        underTest.recreateData();

    }

    /**
     * Parasoft Jtest UTA: Test for switchIndustry()
     *
     * @author jakubiak
     * @see AerospaceAssetsCreator#switchIndustry()
     */
    @Test
    public void testSwitchIndustry() throws Throwable {
        // Given
        AerospaceAssetsCreator underTest = new AerospaceAssetsCreator();
        DatabaseOperationMessages messagesValue = mockDatabaseOperationMessages2();
        ReflectionTestUtils.setField(underTest, "messages", messagesValue);

        // When
        underTest.switchIndustry();

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of DatabaseOperationMessages
     */
    private static DatabaseOperationMessages mockDatabaseOperationMessages2() throws Throwable {
        DatabaseOperationMessages messagesValue = mock(DatabaseOperationMessages.class);
        String getStringResult = ""; // UTA: default value
        when(messagesValue.getString(nullable(String.class))).thenReturn(getStringResult);
        return messagesValue;
    }

    /**
     * Parasoft Jtest UTA: Test for create()
     *
     * @author jakubiak
     * @see AbstractDataCreator#create()
     */
    @Test
    public void testCreate() throws Throwable {
        // Given
        AerospaceAssetsCreator underTest = new AerospaceAssetsCreator();

        // When
        underTest.create();

    }
}