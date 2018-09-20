package com.peony.microcloudmall;

import com.peony.microcloudmall.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROCLOUD-STOCK",configuration = MyRule.class)   //如果不需要自定义负载均衡策略时，此注解可以不用
public class MicrocloudMall80Application {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudMall80Application.class, args);
    }
}
