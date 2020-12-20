package com.peony.microcloudstock;

import com.peonys.peonystarter.configure.MetricService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
//@EnableEurekaClient
public class MicrocloudStock8001Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(MicrocloudStock8001Application.class, args);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        MetricService bean = ac.getBean(MetricService.class);
        System.out.println(bean);
    }
}
