package com.chrishi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptProvider_hystrix_dashboard {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider_hystrix_dashboard.class,args);
    }
}
