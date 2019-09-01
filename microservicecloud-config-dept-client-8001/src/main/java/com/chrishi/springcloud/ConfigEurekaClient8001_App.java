package com.chrishi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ConfigEurekaClient8001_App {

    public static void main(String[] args){
        SpringApplication.run(ConfigEurekaClient8001_App.class,args);
    }
}
