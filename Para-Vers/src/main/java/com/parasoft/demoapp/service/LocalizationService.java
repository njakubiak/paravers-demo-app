package com.parasoft.demoapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Map.Entry;

import com.google.gson.Gson;

import com.parasoft.demoapp.exception.GlobalPreferencesMoreThanOneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.parasoft.demoapp.exception.GlobalPreferencesNotFoundException;
import com.parasoft.demoapp.exception.LocalizationFileNotFoundException;
import com.parasoft.demoapp.messages.LocalizationMessages;
import com.parasoft.demoapp.messages.Messages;
import com.parasoft.demoapp.model.global.LanguageType;
import com.parasoft.demoapp.model.global.preferences.IndustryType;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class LocalizationService {
	@Autowired
	private GlobalPreferencesService globalPreferencesService;
	@Autowired
	ResourceLoader resourceLoader;
	
	private Messages messages = new LocalizationMessages();
	
	private static final String DEFENSE_FILE_RESOURCE_PATH = "i18n/defense/common";
	private static final String AEROSPACE_FILE_RESOURCE_PATH = "i18n/aerospace/common";
	private static final String FILE_EXTENSION = ".properties";
	private static final String LANG_EN_TYPE = "";
	private static final String LANG_ZH_TYPE = "_zh_CN";
	
	public String getLocalization(String language) throws GlobalPreferencesNotFoundException, GlobalPreferencesMoreThanOneException {
		IndustryType currentIndustry = globalPreferencesService.getCurrentIndustry();
		String languageType = getLanguageType(language);
		
		return getJSON(languageType, currentIndustry);
	}

	/**
	 * to get language type which user needs, set it with 'en' as default.
	 * @param language
	 * @return
	 */
	private String getLanguageType(String language) {
		String languageType = LANG_EN_TYPE;
		
		if(LanguageType.ZH.getValue().equals(language)) {
			languageType = LANG_ZH_TYPE;
		}
		
		return languageType;
	}
	
	/**
	 * to get the content of corresponding properties files according to incoming language, like: 'en','zh', etc.
	 * @param languageType 
	 * @param currentIndustry 
	 * @return
	 * @throws LocalizationFileNotFoundException 
	 */
	@SuppressWarnings("static-access")
	private String getJSON(String languageType, IndustryType currentIndustry) {
		Gson gSon = new Gson();
		HashMap<String, String> map = new HashMap<>();
		Properties localizationProperties = new Properties();
		Throwable var1 = null;
		InputStream input = null;
		StringBuilder stringBuilder = new StringBuilder();
		
		if(IndustryType.DEFENSE.equals(currentIndustry)) {
			stringBuilder.append(DEFENSE_FILE_RESOURCE_PATH);
		}else if(IndustryType.AEROSPACE.equals(currentIndustry)){
			stringBuilder.append(AEROSPACE_FILE_RESOURCE_PATH);
		}
		
		String resourcePath = stringBuilder.toString() + languageType + FILE_EXTENSION;
		if(!languageType.equals(LANG_EN_TYPE) && !resourceLoader.getResource(resourceLoader.CLASSPATH_URL_PREFIX + resourcePath).exists()) {
			languageType = LANG_EN_TYPE;
		}
		
		stringBuilder.append(languageType).append(FILE_EXTENSION);
		
		input = LocalizationService.class.getClassLoader()
				.getResourceAsStream(stringBuilder.toString());
		
		try {
			localizationProperties.load(input);
			Iterator<?> iterator = localizationProperties.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<?, ?> localizationEntry = (Entry<?, ?>) iterator.next();
				String localizationKey = (String) localizationEntry.getKey();
				String localizationValue = (String) localizationEntry.getValue();
				map.put(localizationKey, localizationValue);
			}
		} catch (Throwable var2) {
			var1 = var2;
			log.info(messages.getString(LocalizationMessages.PROPERTIES_FILE_NOT_FOUND));
		} finally {
			if (input != null) {
				if (var1 != null) {
					try {
						input.close();
					} catch (Throwable var3) {
						var1.addSuppressed(var3);
					}
				} else {
					try {
						input.close();
					} catch (IOException e) {
						log.info(messages.getString(LocalizationMessages.PROPERTIES_FILE_NOT_FOUND));
					}
				}
			}
		}		
		return gSon.toJson(map);
	}

}
