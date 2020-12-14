package com.parasoft.demoapp.controller;

import com.parasoft.demoapp.config.datasource.IndustryRoutingDataSource;
import com.parasoft.demoapp.dto.GlobalPreferencesDTO;
import com.parasoft.demoapp.dto.IndustryChangeMQMessageDTO;
import com.parasoft.demoapp.exception.*;
import com.parasoft.demoapp.model.global.preferences.GlobalPreferencesEntity;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService;
import com.parasoft.demoapp.service.GlobalPreferencesMQService;
import com.parasoft.demoapp.service.GlobalPreferencesService;
import com.parasoft.demoapp.service.ParasoftJDBCProxyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Tag(name = "demoAdmin")
@Controller
@RequestMapping
public class GlobalPreferencesController {

	@Autowired
	private GlobalPreferencesService globalPreferencesService;

	@Autowired
	private GlobalPreferencesDefaultSettingsService globalPreferencesDefaultSettingsService;

	@Autowired
	private ParasoftJDBCProxyService parasoftJDBCProxyService;

	@Autowired
	private GlobalPreferencesMQService globalPreferencesMQService;

	//@Hidden
	@Operation(description = "Update current preferences.")
	@ApiResponse(responseCode = "200", description = "Return updated current preferences.")
	@ApiResponse(responseCode = "400", description = "Invalid request parameter.",
				content = {@Content(schema = @Schema(hidden = true))})
	@ApiResponse(responseCode = "403",
				description = "The user does not have permission to update current preferences.",
				content = {@Content(schema = @Schema(hidden = true))})
	@ApiResponse(responseCode = "404", description = "No current preferences, can not update.",
				content = {@Content(schema = @Schema(hidden = true))})
	@PutMapping("/v1/demoAdmin/preferences")
	@ResponseBody
	public ResponseResult<GlobalPreferencesEntity> doSaveChanges(@RequestBody GlobalPreferencesDTO globalPreferencesDto)
			throws GlobalPreferencesNotFoundException, GlobalPreferencesMoreThanOneException, ParameterException,
			EndpointInvalidException, VirtualizeServerUrlException {

		IndustryType previousIndustry = IndustryRoutingDataSource.currentIndustry;

		ResponseResult<GlobalPreferencesEntity> response =
				ResponseResult.getInstance(ResponseResult.STATUS_OK, ResponseResult.MESSAGE_OK);
		response.setData(globalPreferencesService.updateGlobalPreferences(globalPreferencesDto));

		IndustryType currentIndustry = IndustryRoutingDataSource.currentIndustry;
		if(previousIndustry != currentIndustry){
			IndustryChangeMQMessageDTO messageDto = new IndustryChangeMQMessageDTO(previousIndustry, currentIndustry);
			globalPreferencesMQService.sendToIndustryChangeTopic(messageDto);
		}

		return response;
	}

	@Operation(description = "Obtain current industry")
	@ApiResponse(responseCode = "200", description = "Return current industry.")
	@ApiResponse(responseCode = "404", description = "No current industry.",
				content = {@Content(schema = @Schema(hidden = true))})
	@GetMapping("/v1/demoAdmin/currentIndustry")
	@ResponseBody
	public ResponseResult<IndustryType> getCurrentIndustry()
			throws GlobalPreferencesNotFoundException, GlobalPreferencesMoreThanOneException {

		ResponseResult<IndustryType> response =
				ResponseResult.getInstance(ResponseResult.STATUS_OK, ResponseResult.MESSAGE_OK);

		response.setData(globalPreferencesService.getCurrentIndustry());

		return response;
	}

	@Operation(description = "Obtain current preferences")
	@ApiResponse(responseCode = "200", description = "Return current preferences.")
	@ApiResponse(responseCode = "404", description = "No current preferences.",
				content = {@Content(schema = @Schema(hidden = true))})
	@GetMapping("/v1/demoAdmin/currentPreferences")
	@ResponseBody
	public ResponseResult<GlobalPreferencesEntity> getCurrentPreferences()
			throws GlobalPreferencesNotFoundException, GlobalPreferencesMoreThanOneException {

		ResponseResult<GlobalPreferencesEntity> response =
				ResponseResult.getInstance(ResponseResult.STATUS_OK, ResponseResult.MESSAGE_OK);

		response.setData(globalPreferencesService.getCurrentGlobalPreferences());

		return response;
	}

	@Operation(description = "Obtain default preferences")
	@ApiResponse(responseCode = "200", description = "Return default preferences.")
	@GetMapping("/v1/demoAdmin/defaultPreferences")
	@ResponseBody
	public ResponseResult<GlobalPreferencesEntity> getDefaultPreferences() {

		ResponseResult<GlobalPreferencesEntity> response =
				ResponseResult.getInstance(ResponseResult.STATUS_OK, ResponseResult.MESSAGE_OK);

		response.setData(globalPreferencesDefaultSettingsService.defaultPreferences());

		return response;
	}

	@Operation(description = "Reset all insudtries database.")
	@ApiResponse(responseCode = "200", description = "Reset all insudtries database successfully.")
	@ApiResponse(responseCode = "403",
			description = "The user does not have permission to reset all insudtries database.",
			content = {@Content(schema = @Schema(hidden = true))})
	@PutMapping("/v1/demoAdmin/databaseReset")
	@ResponseBody
	public ResponseResult<Void> resetAllIndustriesDatabase(){
		ResponseResult<Void> response =
				ResponseResult.getInstance(ResponseResult.STATUS_OK, ResponseResult.MESSAGE_OK);

		globalPreferencesService.resetAllIndustriesDatabase();

		return response;
	}
	
	@Operation(description = "Clear current industry database.")
	@ApiResponse(responseCode = "200", description = "Clear current industry database successfully.")
	@ApiResponse(responseCode = "403",
			description = "The user does not have permission to clear current industry database.",
			content = {@Content(schema = @Schema(hidden = true))})
	@PutMapping("/v1/demoAdmin/databaseClear")
	@ResponseBody
	public ResponseResult<Void> clearCurrentIndustryDatabase(){
		ResponseResult<Void> response =
				ResponseResult.getInstance(ResponseResult.STATUS_OK, ResponseResult.MESSAGE_OK);

		globalPreferencesService.clearCurrentIndustryDatabase();

		return response;
	}
	
	@Operation(description = "Validate parasoft virtualize server URL.")
	@ApiResponse(responseCode = "200", description = "Valid URL.")
	@ApiResponse(responseCode = "400", description = "Invalid URL.",
			content = {@Content(schema = @Schema(hidden = true))})
	@GetMapping("/v1/demoAdmin/parasoftVirtualizeServerUrlValidation")
	@ResponseBody
	public ResponseResult<Void> validateParasoftVirtualizeServerUrl(String url) throws VirtualizeServerUrlException {
		ResponseResult<Void> response =
				ResponseResult.getInstance(ResponseResult.STATUS_OK, ResponseResult.MESSAGE_OK);

		parasoftJDBCProxyService.validateVirtualizeServerUrl(url);

		return response;
	}
}
