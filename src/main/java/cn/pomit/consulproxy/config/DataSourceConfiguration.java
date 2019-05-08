package cn.pomit.consulproxy.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import cn.pomit.mybatis.configuration.MybatisConfiguration;

public class DataSourceConfiguration {
	public static final String DATASOURCE_PREFIX = "datasource.";
	public static void initConfiguration(Properties properties) {
		String packageName = "cn.pomit.consulproxy.mapper";
		try {
			Properties dataSourceProperties = new Properties();
			for (Object key : properties.keySet()) {
				String tmpKey = key.toString();
				if(tmpKey.startsWith(DATASOURCE_PREFIX)){
					String datasourceKey = tmpKey.replace(DATASOURCE_PREFIX, "");
					dataSourceProperties.put(datasourceKey, properties.get(key));
				}
			}
			DataSource dataSource = BasicDataSourceFactory.createDataSource(dataSourceProperties);
			MybatisConfiguration.initConfiguration(packageName, dataSource);
		} catch (Exception e) {
			e.printStackTrace();
			MybatisConfiguration.initConfiguration(packageName, properties);
		}
	}

	
}
