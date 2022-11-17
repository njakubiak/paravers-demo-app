/**
 * 
 */
package com.parasoft.demoapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.config.datasource.IndustryDataSourceConfig;
import com.parasoft.demoapp.config.datasource.IndustryRoutingDataSource;
import com.parasoft.demoapp.config.datasource.DataSourceConfigurationProperties.DataSourceProperties;
import com.parasoft.demoapp.config.datasource.DataSourceConfigurationProperties.Industry;
import com.parasoft.demoapp.exception.ParameterException;
import com.zaxxer.hikari.HikariDataSource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Parasoft Jtest UTA: Test class for ParasoftJDBCProxyService
 *
 * @see com.parasoft.demoapp.service.ParasoftJDBCProxyService
 * @author jakubiak
 */
public class ParasoftJDBCProxyServiceTest {

	/**
	 * Parasoft Jtest UTA: Test for getProxyKeyOfCurrentIndustry()
	 *
	 * @see com.parasoft.demoapp.service.ParasoftJDBCProxyService#getProxyKeyOfCurrentIndustry()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testGetProxyKeyOfCurrentIndustry() throws Throwable {
		// Given
		ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();

		// When
		String result = underTest.getProxyKeyOfCurrentIndustry();

		// Then - assertions for result of method getProxyKeyOfCurrentIndustry()
		assertEquals("defense_virtualize", result);

	}

	/**
	 * Parasoft Jtest UTA: Test for refreshParasoftJDBCProxyDataSource()
	 *
	 * @see com.parasoft.demoapp.service.ParasoftJDBCProxyService#refreshParasoftJDBCProxyDataSource()
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testRefreshParasoftJDBCProxyDataSource() throws Throwable {
		// Given
		ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();
		IndustryDataSourceConfig industryDataSourceConfigValue = mockIndustryDataSourceConfig();
		ReflectionTestUtils.setField(underTest, "industryDataSourceConfig", industryDataSourceConfigValue);
		IndustryRoutingDataSource industryRoutingDataSourceValue = mock(IndustryRoutingDataSource.class);
		ReflectionTestUtils.setField(underTest, "industryRoutingDataSource", industryRoutingDataSourceValue);

		// When
		underTest.refreshParasoftJDBCProxyDataSource();

	}

	/**
	 * Parasoft Jtest UTA: Helper method to generate and configure mock of IndustryDataSourceConfig
	 */
	private static IndustryDataSourceConfig mockIndustryDataSourceConfig() throws Throwable {
		IndustryDataSourceConfig industryDataSourceConfigValue = mock(IndustryDataSourceConfig.class);
		Map<Object, Object> getIndustryDataSourcesResult = new HashMap<Object, Object>(); // UTA: default value
		doReturn(getIndustryDataSourcesResult).when(industryDataSourceConfigValue).getIndustryDataSources();
		return industryDataSourceConfigValue;
	}

	/**
	 * Parasoft Jtest UTA: Test for validateVirtualizeGroupId(String)
	 *
	 * @see com.parasoft.demoapp.service.ParasoftJDBCProxyService#validateVirtualizeGroupId(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000)
	public void testValidateVirtualizeGroupId() throws Throwable {
		// Given
		ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();

		// When
		String virtualizeGroupId = "virtualizeGroupId"; // UTA: default value
		underTest.validateVirtualizeGroupId(virtualizeGroupId);

	}

	/**
	 * Parasoft Jtest UTA: Test for validateVirtualizeGroupId(String)
	 *
	 * @see com.parasoft.demoapp.service.ParasoftJDBCProxyService#validateVirtualizeGroupId(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testValidateVirtualizeGroupId2() throws Throwable {
		// Given
		ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();

		// When
		String virtualizeGroupId = null; // UTA: provided value
		underTest.validateVirtualizeGroupId(virtualizeGroupId);

	}

	/**
	 * Parasoft Jtest UTA: Test for validateVirtualizeServerPath(String)
	 *
	 * @see com.parasoft.demoapp.service.ParasoftJDBCProxyService#validateVirtualizeServerPath(String)
	 * @author jakubiak
	 */
	@Test(timeout = 5000, expected = ParameterException.class)
	public void testValidateVirtualizeServerPath2() throws Throwable {
		// Given
		ParasoftJDBCProxyService underTest = new ParasoftJDBCProxyService();

		// When
		String virtualizeServerPath = null; // UTA: provided value
		underTest.validateVirtualizeServerPath(virtualizeServerPath);

	}

}