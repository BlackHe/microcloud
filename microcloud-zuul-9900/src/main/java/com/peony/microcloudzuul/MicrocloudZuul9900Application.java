package com.peony.microcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicrocloudZuul9900Application {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudZuul9900Application.class, args);
    }
}
