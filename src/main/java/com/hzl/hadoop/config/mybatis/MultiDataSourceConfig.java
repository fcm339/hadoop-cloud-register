package com.hzl.hadoop.config.mybatis;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.hzl.hadoop.constant.DBTypeEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 * 多数据
 * @author hzl 2020/01/07 9:54 PM
 */
@Configuration
@ConditionalOnProperty(prefix = "hadoop", name = "openMulti", havingValue = "true", matchIfMissing = false)
public class MultiDataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.master")
	@Primary
	public DataSource masterDataSource() {
		System.out.println("注入主数据源");
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.slave1")
	public DataSource slaveDataSource() {
		System.out.println("注入slave1数据源");
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	public DynamicDataSource dataSource(@Qualifier("masterDataSource") DataSource masterDataSource, @Qualifier("slaveDataSource") DataSource slaveDataSource) {
		System.out.println("启动多数据源");
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DBTypeEnum.MASTER.value(), masterDataSource);
		if (slaveDataSource != null) {
			targetDataSources.put(DBTypeEnum.SLAVE1.value(), slaveDataSource);
		}
		return new DynamicDataSource(masterDataSource, targetDataSources);
	}

}
