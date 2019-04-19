package com.peony.microcloudmall.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {


    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /***
     * rebbion请求分发算法
     * randomRule   随机
     * retryRule    重试
     * roundRandomRule  轮询
     * @return
     */
    @Bean
    public IRule getIRule() {
        return new RandomRule();      //随机
//        return new RetryRule();
//        return new RoundRobinRule();    //轮询
    }
}
