package com.hzl.hadoop.config.mybatis;

import com.hzl.hadoop.constant.DBTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/01/07 9:54 PM
 */

@Configuration
@Component
public class DynamicDataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.master")
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.slave1")
	public DataSource slaveDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	public DynamicDataSource dataSource(DataSource xiaobinMasterDataSource, DataSource xiaobinSlaveDataSource) {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DBTypeEnum.MASTER.value(), xiaobinMasterDataSource);
		targetDataSources.put(DBTypeEnum.SLAVE1.value(), xiaobinSlaveDataSource);
		return new DynamicDataSource(xiaobinMasterDataSource, targetDataSources);
	}

}
