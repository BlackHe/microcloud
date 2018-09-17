package com.peony.microcloudmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicrocloudMall80Application {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudMall80Application.class, args);
    }
}
