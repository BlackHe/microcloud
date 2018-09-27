package com.peony.microcloudstockhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MicrocloudStock8001HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudStock8001HystrixApplication.class, args);
    }
}
