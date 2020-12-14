package com.parasoft.demoapp.service;

import com.parasoft.demoapp.exception.*;
import com.parasoft.demoapp.messages.GlobalPreferencesMessages;
import com.parasoft.demoapp.messages.OrderMessages;
import com.parasoft.demoapp.model.global.preferences.DemoBugEntity;
import com.parasoft.demoapp.model.global.preferences.DemoBugsType;
import com.parasoft.demoapp.model.global.preferences.GlobalPreferencesEntity;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import com.parasoft.demoapp.model.industry.LocationEntity;
import com.parasoft.demoapp.model.industry.OrderEntity;
import com.parasoft.demoapp.model.industry.OrderStatus;
import com.parasoft.demoapp.model.industry.RegionType;
import com.parasoft.demoapp.repository.global.DemoBugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Service
public class DemoBugService {

    @Autowired
    private DemoBugRepository demoBugRepository;

    @Autowired
    private GlobalPreferencesService globalPreferencesService;

    @Autowired
    private LocationService locationService;

    public void removeByGlobalPreferencesId(Long id) {
        Objects.requireNonNull(id, GlobalPreferencesMessages.GLOBAL_PREFERENCES_ID_CANNOT_BE_NULL);

        demoBugRepository.deleteByGlobalPreferencesId(id);
    }

    public void introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(OrderEntity order)
            throws GlobalPreferencesMoreThanOneException, GlobalPreferencesNotFoundException, DemoBugsIntroduceFailedException {

        if(order == null || order.getStatus() != OrderStatus.APPROVED){
            return;
        }

        GlobalPreferencesEntity globalPreferencesEntity = globalPreferencesService.getCurrentGlobalPreferences();
        Set<DemoBugEntity> demoBugs = globalPreferencesEntity.getDemoBugs();

        boolean needBug = false;
        for(DemoBugEntity demoBugEntity : demoBugs){
            if(demoBugEntity.getDemoBugsType() == DemoBugsType.INCORRECT_LOCATION_FOR_APPROVED_ORDERS){
                needBug = true;
                break;
            }
        }

        if(!needBug){
            return;
        }

        IndustryType currentIndustry = globalPreferencesEntity.getIndustryType();
        LocationEntity incorrectLocation = null;

        try{
            if(currentIndustry == IndustryType.DEFENSE) {
                if(order.getRegion() == RegionType.AUSTRALIA){
                    incorrectLocation = locationService.getLocationByRegion(RegionType.UNITED_KINGDOM);
                }else{
                    incorrectLocation = locationService.getLocationByRegion(RegionType.AUSTRALIA);
                }
            }else if(currentIndustry == IndustryType.AEROSPACE){
                if(order.getRegion() == RegionType.NEPTUNE){
                    incorrectLocation = locationService.getLocationByRegion(RegionType.VENUS);
                }else{
                    incorrectLocation =  locationService.getLocationByRegion(RegionType.NEPTUNE);
                }
            }
            // TODO handle incorrect location for other industry when they are needed
        }catch (Exception e){
            throw new DemoBugsIntroduceFailedException(
                    MessageFormat.format(OrderMessages.FAILED_TO_INTRODUCES_INCORRECT_LOCATION_BUG,
                                            DemoBugsType.INCORRECT_LOCATION_FOR_APPROVED_ORDERS.getValue()));
        }

        order.setOrderImage(incorrectLocation.getLocationImage());
        order.setLocation(incorrectLocation.getLocationInfo());
        order.setRegion(incorrectLocation.getRegion());
    }

    public void introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(Collection<OrderEntity> orders)
            throws GlobalPreferencesMoreThanOneException, GlobalPreferencesNotFoundException,
                    DemoBugsIntroduceFailedException {

        if(orders == null){
            return;
        }

        for(OrderEntity order : orders){
            introduceBugWithIncorrectLocationForApprovedOrdersIfNeeded(order);
        }
    }
}
