package com.parasoft.demoapp.dto;


import com.parasoft.demoapp.model.global.preferences.IndustryType;
import org.junit.Test;

import static org.junit.Assert.assertFalse;


/**
 * Parasoft Jtest UTA: Test class for IndustryChangeMQMessageDTO
 *
 * @see IndustryChangeMQMessageDTO
 * @author jakubiak
 */
public class IndustryChangeMQMessageDTOTest
{
    /**
     * Parasoft Jtest UTA: Test for isIndustryChanged()
     *
     * @author jakubiak
     * @see IndustryChangeMQMessageDTO#isIndustryChanged()
     */
    @Test
    public void testIsIndustryChanged() throws Throwable {
        // Given
        IndustryType previousIndustry = IndustryType.AEROSPACE; // UTA: default value
        IndustryType currentIndustry = IndustryType.AEROSPACE; // UTA: default value
        IndustryChangeMQMessageDTO underTest = new IndustryChangeMQMessageDTO(previousIndustry, currentIndustry);

        // When
        boolean result = underTest.isIndustryChanged();

        // Then
        // assertFalse(result);
    }
}