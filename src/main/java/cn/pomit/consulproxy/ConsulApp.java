package cn.pomit.consulproxy;

import cn.pomit.consul.ConsulProxyApplication;
import cn.pomit.consul.annotation.EnableServer;
import cn.pomit.consul.annotation.InitConfiguration;
import cn.pomit.consulproxy.config.DataSourceConfiguration;
import cn.pomit.consulproxy.handler.AdviceHandler;

@EnableServer(handler = { AdviceHandler.class })
@InitConfiguration(configurations = { DataSourceConfiguration.class })
public class ConsulApp {
	public static void main(String[] args) {
		ConsulProxyApplication.run(ConsulApp.class, args);
	}

}
