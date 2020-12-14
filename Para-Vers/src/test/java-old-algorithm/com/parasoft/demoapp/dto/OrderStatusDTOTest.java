package com.parasoft.demoapp.dto;


import org.junit.Test;

import static org.junit.Assert.assertFalse;


/**
 * Parasoft Jtest UTA: Test class for OrderStatusDTO
 *
 * @see OrderStatusDTO
 * @author jakubiak
 */
public class OrderStatusDTOTest
{
    /**
     * Parasoft Jtest UTA: Test for isReviewedByAPV()
     *
     * @author jakubiak
     * @see OrderStatusDTO#isReviewedByAPV()
     */
    @Test
    public void testIsReviewedByAPV() throws Throwable {
        // Given
        OrderStatusDTO underTest = new OrderStatusDTO();

        // When
        boolean result = underTest.isReviewedByAPV();

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Test for isReviewedByPRCH()
     *
     * @author jakubiak
     * @see OrderStatusDTO#isReviewedByPRCH()
     */
    @Test
    public void testIsReviewedByPRCH() throws Throwable {
        // Given
        OrderStatusDTO underTest = new OrderStatusDTO();

        // When
        boolean result = underTest.isReviewedByPRCH();

        // Then
        // assertFalse(result);
    }
}