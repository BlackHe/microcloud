package com.peony.microcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicrocloudEureka7001Application {

	public static void main(String[] args) {
		SpringApplication.run(MicrocloudEureka7001Application.class, args);
	}
}
