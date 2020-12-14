package com.parasoft.demoapp.service;


import com.parasoft.demoapp.dto.IndustryChangeMQMessageDTO;
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
 * Parasoft Jtest UTA: Test class for GlobalPreferencesMQService
 *
 * @author jakubiak
 * @see GlobalPreferencesMQService
 */
public class GlobalPreferencesMQServiceTest {
    /**
     * Parasoft Jtest UTA: Test for sendToIndustryChangeTopic(IndustryChangeMQMessageDTO)
     *
     * @author jakubiak
     * @see GlobalPreferencesMQService#sendToIndustryChangeTopic(IndustryChangeMQMessageDTO)
     */
    @Test
    public void testSendToIndustryChangeTopic() throws Throwable {
        // Given
        GlobalPreferencesMQService underTest = new GlobalPreferencesMQService();
        JmsMessagingTemplate jmsMessagingTemplateValue = mockJmsMessagingTemplate();
        ReflectionTestUtils.setField(underTest, "jmsMessagingTemplate", jmsMessagingTemplateValue);

        // When
        IndustryChangeMQMessageDTO messageDto = mockIndustryChangeMQMessageDTO();
        underTest.sendToIndustryChangeTopic(messageDto);

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
     * Parasoft Jtest UTA: Helper method to generate and configure mock of IndustryChangeMQMessageDTO
     */
    private static IndustryChangeMQMessageDTO mockIndustryChangeMQMessageDTO() throws Throwable {
        IndustryChangeMQMessageDTO messageDto = mock(IndustryChangeMQMessageDTO.class);
        return messageDto;
    }
}