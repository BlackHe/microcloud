package com.peony.microcloudhystrixserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MicrocloudHystrixserver9001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudHystrixserver9001Application.class, args);
    }
}
