package com.parasoft.demoapp.model.industry;


import com.parasoft.demoapp.model.global.preferences.IndustryType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Parasoft Jtest UTA: Test class for RegionType
 *
 * @author jakubiak
 * @see RegionType
 */
public class RegionTypeTest {
    /**
     * Parasoft Jtest UTA: Test for getDisplayName()
     *
     * @author jakubiak
     * @see RegionType#getDisplayName()
     */
    @Test
    public void testGetDisplayName() throws Throwable {
        // Given
        RegionType underTest = RegionType.AUSTRALIA; // UTA: default value

        // When
        String result = underTest.getDisplayName();

        // Then
        // assertEquals("", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getIndustryType()
     *
     * @author jakubiak
     * @see RegionType#getIndustryType()
     */
    @Test
    public void testGetIndustryType() throws Throwable {
        // Given
        RegionType underTest = RegionType.AUSTRALIA; // UTA: default value

        // When
        IndustryType result = underTest.getIndustryType();

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for getRegionByIndustryType(IndustryType)
     *
     * @author jakubiak
     * @see RegionType#getRegionByIndustryType(IndustryType)
     */
    @Test
    public void testGetRegionByIndustryType() throws Throwable {
        // When
        IndustryType industryType = IndustryType.AEROSPACE; // UTA: default value
        List<RegionType> result = RegionType.getRegionByIndustryType(industryType);

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.size());
        // assertTrue(result.contains(null));
    }

    /**
     * Parasoft Jtest UTA: Test for isIndustry(IndustryType)
     *
     * @author jakubiak
     * @see RegionType#isIndustry(IndustryType)
     */
    @Test
    public void testIsIndustry() throws Throwable {
        // Given
        RegionType underTest = RegionType.AUSTRALIA; // UTA: default value

        // When
        IndustryType industryType = IndustryType.AEROSPACE; // UTA: default value
        boolean result = underTest.isIndustry(industryType);

        // Then
        // assertFalse(result);
    }

    /**
     * Parasoft Jtest UTA: Test for setDisplayName(String)
     *
     * @author jakubiak
     * @see RegionType#setDisplayName(String)
     */
    @Test
    public void testSetDisplayName() throws Throwable {
        // Given
        RegionType underTest = RegionType.AUSTRALIA; // UTA: default value

        // When
        String displayName = ""; // UTA: default value
        underTest.setDisplayName(displayName);

    }

    /**
     * Parasoft Jtest UTA: Test for setIndustryType(IndustryType)
     *
     * @author jakubiak
     * @see RegionType#setIndustryType(IndustryType)
     */
    @Test
    public void testSetIndustryType() throws Throwable {
        // Given
        RegionType underTest = RegionType.AUSTRALIA; // UTA: default value

        // When
        IndustryType industryType = IndustryType.AEROSPACE; // UTA: default value
        underTest.setIndustryType(industryType);

    }

    /**
     * Parasoft Jtest UTA: Test for valueOf(String)
     *
     * @author jakubiak
     * @see RegionType#valueOf(String)
     */
    @Test
    public void testValueOf() throws Throwable {
        // When
        String name = ""; // UTA: default value
        RegionType result = RegionType.valueOf(name);

        // Then
        // assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for values()
     *
     * @author jakubiak
     * @see RegionType#values()
     */
    @Test
    public void testValues() throws Throwable {
        // When
        RegionType[] result = RegionType.values();

        // Then
        // assertNotNull(result);
        // assertEquals(0, result.length);
    }
}