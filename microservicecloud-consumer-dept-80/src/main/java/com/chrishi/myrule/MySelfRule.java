package com.chrishi.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
//        return new RetryRule();//自定义轮询规则
        return new RandomRule_CH();//自定义轮询
    }
}
