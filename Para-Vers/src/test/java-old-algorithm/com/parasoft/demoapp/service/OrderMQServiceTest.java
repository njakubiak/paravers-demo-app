package com.parasoft.demoapp.service;


import com.parasoft.demoapp.dto.OrderMQMessageDTO;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for OrderMQService
 *
 * @author jakubiak
 * @see OrderMQService
 */
public class OrderMQServiceTest {
    /**
     * Parasoft Jtest UTA: Test for sendToApprover(OrderMQMessageDTO)
     *
     * @author jakubiak
     * @see OrderMQService#sendToApprover(OrderMQMessageDTO)
     */
    @Test
    public void testSendToApprover() throws Throwable {
        // Given
        OrderMQService underTest = new OrderMQService();
        JmsMessagingTemplate jmsMessagingTemplateValue = mockJmsMessagingTemplate();
        ReflectionTestUtils.setField(underTest, "jmsMessagingTemplate", jmsMessagingTemplateValue);

        // When
        OrderMQMessageDTO messageDto = mockOrderMQMessageDTO();
        underTest.sendToApprover(messageDto);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of JmsMessagingTemplate
     */
    private static JmsMessagingTemplate mockJmsMessagingTemplate() throws Throwable {
        JmsMessagingTemplate jmsMessagingTemplateValue = mock(JmsMessagingTemplate.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                String destinationName = (String) invocation.getArguments()[0];
                Object payload = (Object) invocation.getArguments()[1];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(jmsMessagingTemplateValue).convertAndSend(nullable(String.class), nullable(Object.class));
        return jmsMessagingTemplateValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderMQMessageDTO
     */
    private static OrderMQMessageDTO mockOrderMQMessageDTO() throws Throwable {
        OrderMQMessageDTO messageDto = mock(OrderMQMessageDTO.class);
        return messageDto;
    }

    /**
     * Parasoft Jtest UTA: Test for sendToPurchaser(OrderMQMessageDTO)
     *
     * @author jakubiak
     * @see OrderMQService#sendToPurchaser(OrderMQMessageDTO)
     */
    @Test
    public void testSendToPurchaser() throws Throwable {
        // Given
        OrderMQService underTest = new OrderMQService();
        JmsMessagingTemplate jmsMessagingTemplateValue = mockJmsMessagingTemplate2();
        ReflectionTestUtils.setField(underTest, "jmsMessagingTemplate", jmsMessagingTemplateValue);

        // When
        OrderMQMessageDTO messageDto = mockOrderMQMessageDTO2();
        underTest.sendToPurchaser(messageDto);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of JmsMessagingTemplate
     */
    private static JmsMessagingTemplate mockJmsMessagingTemplate2() throws Throwable {
        JmsMessagingTemplate jmsMessagingTemplateValue = mock(JmsMessagingTemplate.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                String destinationName = (String) invocation.getArguments()[0];
                Object payload = (Object) invocation.getArguments()[1];
                // UTA: Auto-generated answer method
                return null;
            }
        }).when(jmsMessagingTemplateValue).convertAndSend(nullable(String.class), nullable(Object.class));
        return jmsMessagingTemplateValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of OrderMQMessageDTO
     */
    private static OrderMQMessageDTO mockOrderMQMessageDTO2() throws Throwable {
        OrderMQMessageDTO messageDto = mock(OrderMQMessageDTO.class);
        return messageDto;
    }
}