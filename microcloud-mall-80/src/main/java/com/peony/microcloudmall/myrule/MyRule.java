package com.peony.microcloudmall.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    /***
     * 自定义的负载策略，覆盖rebbion自带的策略
     * @return
     */
    @Bean
    public IRule getIRule(){
            return new RoundRobinRule();
//        return new RandomRule();
    }
}
