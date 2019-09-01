package com.chrishi.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule(){
//        return new RandomRule();//用我们重新选择的随机算法替代默认的轮询算法
//    }
}
