package com.peony.microcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicrocloudConfigserver4001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudConfigserver4001Application.class, args);
    }
}
