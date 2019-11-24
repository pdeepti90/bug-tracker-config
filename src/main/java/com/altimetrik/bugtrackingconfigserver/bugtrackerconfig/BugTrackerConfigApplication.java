package com.altimetrik.bugtrackingconfigserver.bugtrackerconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.h2.tools.Server;
import java.sql.SQLException;

@EnableConfigServer
@SpringBootApplication
public class BugTrackerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerConfigApplication.class, args);
	}
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
		return Server.createTcpServer(
				"-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}
}
