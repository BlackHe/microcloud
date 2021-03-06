package com.peony.microcloudstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicrocloudStock8002Application {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudStock8002Application.class, args);
    }
}
