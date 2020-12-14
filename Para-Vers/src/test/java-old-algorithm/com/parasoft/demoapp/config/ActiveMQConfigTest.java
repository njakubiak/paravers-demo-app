package com.parasoft.demoapp.config;


import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for ActiveMQConfig
 *
 * @author jakubiak
 * @see ActiveMQConfig
 */
public class ActiveMQConfigTest {
    /**
     * Parasoft Jtest UTA: Test for approverTopic()
     *
     * @author jakubiak
     * @see ActiveMQConfig#approverTopic()
     */
    @Test
    public void testApproverTopic() throws Throwable {
        // Given
        ActiveMQConfig underTest = new ActiveMQConfig();

        // When
        ActiveMQTopic result = underTest.approverTopic();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for brokerService()
     *
     * @author jakubiak
     * @see ActiveMQConfig#brokerService()
     */
    @Test
    public void testBrokerService() throws Throwable {
        // Given
        ActiveMQConfig underTest = new ActiveMQConfig();
        String embeddedBrokerNameValue = ""; // UTA: default value
        ReflectionTestUtils.setField(underTest, "embeddedBrokerName", embeddedBrokerNameValue);
        String embeddedBrokerUrlValue = ""; // UTA: default value
        ReflectionTestUtils.setField(underTest, "embeddedBrokerUrl", embeddedBrokerUrlValue);
        String stompUrlValue = ""; // UTA: default value
        ReflectionTestUtils.setField(underTest, "stompUrl", stompUrlValue);
        String wsUrlValue = ""; // UTA: default value
        ReflectionTestUtils.setField(underTest, "wsUrl", wsUrlValue);

        // When
        BrokerService result = underTest.brokerService();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for industryChangeTopic()
     *
     * @author jakubiak
     * @see ActiveMQConfig#industryChangeTopic()
     */
    @Test
    public void testIndustryChangeTopic() throws Throwable {
        // Given
        ActiveMQConfig underTest = new ActiveMQConfig();

        // When
        ActiveMQTopic result = underTest.industryChangeTopic();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for purchaserTopic()
     *
     * @author jakubiak
     * @see ActiveMQConfig#purchaserTopic()
     */
    @Test
    public void testPurchaserTopic() throws Throwable {
        // Given
        ActiveMQConfig underTest = new ActiveMQConfig();

        // When
        ActiveMQTopic result = underTest.purchaserTopic();

        // Then
        // assertNotNull(result);
    }
}