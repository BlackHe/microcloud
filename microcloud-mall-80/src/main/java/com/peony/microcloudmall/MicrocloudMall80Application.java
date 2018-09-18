package com.peony.microcloudmall;

import com.peony.microcloudmall.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROCLOUD-STOCK",configuration = MyRule.class)
public class MicrocloudMall80Application {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudMall80Application.class, args);
    }
}
