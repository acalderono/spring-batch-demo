package com.ait.batch.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {
	
	@Value("${spring.datasource.driverClassName}")
	private String dbDatasourceDriver;
	
	@Value("${spring.datasource.url}")
	private String dbDatasourceUrl;
	
	@Value("${spring.datasource.username}")
	private String dbDatasourceUser;
	
	@Value("${spring.datasource.password}")
	private String dbDatasourcePassword;
	
	@Bean(name ="primaryDataSource")
	@Primary
	public DataSource primaryDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(dbDatasourceDriver);
		dataSourceBuilder.url(dbDatasourceUrl);
		dataSourceBuilder.username(dbDatasourceUser);
		dataSourceBuilder.password(dbDatasourcePassword);
		return dataSourceBuilder.build();
	}

	@Bean
	@Primary
	public JdbcTemplate jdbcTemplateDb(@Autowired final DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	//********** db1 config
	
	@Value("${database1.datasource.driverClassName}")
	private String db1DatasourceDriver;
	
	@Value("${database1.datasource.url}")
	private String db1DatasourceUrl;
	
	@Value("${database1.datasource.user}")
	private String db1DatasourceUser;
	
	@Value("${database1.datasource.password}")
	private String db1DatasourcePassword;
	
	@Bean(name="secondaryDataSource")
	public DataSource secondaryDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(db1DatasourceDriver);
		dataSourceBuilder.url(db1DatasourceUrl);
		dataSourceBuilder.username(db1DatasourceUser);
		dataSourceBuilder.password(db1DatasourcePassword);
		return dataSourceBuilder.build();
	}

	@Bean(name = "jdbcTemplateDb1")
	public JdbcTemplate jdbcTemplateDb1(@Qualifier("secondaryDataSource") final DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	

}
