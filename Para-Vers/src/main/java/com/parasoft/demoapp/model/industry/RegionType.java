package com.parasoft.demoapp.model.industry;

import com.parasoft.demoapp.model.global.preferences.IndustryType;

import java.util.ArrayList;
import java.util.List;

public enum RegionType {
	
	UNITED_STATES("United States", IndustryType.DEFENSE),
	UNITED_KINGDOM("United Kingdom", IndustryType.DEFENSE),
    GERMANY("Germany", IndustryType.DEFENSE),
    FRANCE("France", IndustryType.DEFENSE),
    JAPAN("Japan", IndustryType.DEFENSE),
    SOUTH_KOREA("South Korea", IndustryType.DEFENSE),
    SPAIN("Spain", IndustryType.DEFENSE),
    AUSTRALIA("Australia", IndustryType.DEFENSE),
    MERCURY("Mercury", IndustryType.AEROSPACE),
    VENUS("Venus", IndustryType.AEROSPACE),
    EARTH("Earth", IndustryType.AEROSPACE),
    MARS("Mars", IndustryType.AEROSPACE),
    JUPITER("Jupiter", IndustryType.AEROSPACE),
    SATURN("Saturn", IndustryType.AEROSPACE),
    URANUS("Uranus", IndustryType.AEROSPACE),
    NEPTUNE("Neptune", IndustryType.AEROSPACE);

    private String displayName;

    private IndustryType industryType;

    RegionType(String displayName, IndustryType industryType) {
        this.displayName = displayName;
        this.industryType = industryType;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setIndustryType(IndustryType industryType) {
        this.industryType = industryType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public IndustryType getIndustryType() {
        return  industryType;
    }

    public static List<RegionType> getRegionByIndustryType(IndustryType industryType) {
        List<RegionType> regionList = new ArrayList<>();
        for(RegionType regionType : RegionType.values()) {
            if (industryType.getValue().equals(regionType.getIndustryType().getValue())){
                regionList.add(regionType);
            }
        }
        return regionList;
    }

    public boolean isIndustry(IndustryType industryType) {
        return this.industryType == industryType;
    }

}
