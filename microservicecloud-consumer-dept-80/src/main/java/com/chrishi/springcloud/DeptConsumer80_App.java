package com.chrishi.springcloud;

import com.chrishi.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)//MySelfRule不能放在ComponentScan所扫描的同级包以及字包下面（不能放在主启动类同级及其子包下）
public class DeptConsumer80_App {

    public static void main(String[] args){
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
