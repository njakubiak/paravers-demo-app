package com.parasoft.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parasoft.demoapp.service.LocalizationService;

@Controller
public class LocalizationController {
	@Autowired
	private LocalizationService localizationService;
	
	@GetMapping("/localize")
	@ResponseBody
	   public ResponseResult<String> getLocalization(@RequestParam(value = "lang") String language) {

		ResponseResult<String> response =
					ResponseResult.getInstance(ResponseResult.STATUS_OK, ResponseResult.MESSAGE_OK);

			try {
				String localization = localizationService.getLocalization(language);
				response.setData(localization);
			}catch (Exception e){
				response.setStatus(ResponseResult.STATUS_ERR);
				response.setMessage(ResponseResult.MESSAGE_ERR);
			}
			
		 	return response;
		}

}
