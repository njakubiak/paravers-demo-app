package com.parasoft.demoapp.defaultdata.industry;

import com.parasoft.demoapp.config.datasource.IndustryRoutingDataSource;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class DefenseTablesCreator extends AbstractIndustryTablesCreator {

    @Override
    public void switchIndustry() {
        IndustryRoutingDataSource.currentIndustry = IndustryType.DEFENSE;
    }

}
