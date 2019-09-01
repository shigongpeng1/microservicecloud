package chrishi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
@EnableFeignClients(basePackages = {"chrishi.springcloud"})
@ComponentScan("chrishi.springcloud")
public class DeptConsumerFeign_App {

    public static void main(String[] args){
        SpringApplication.run(DeptConsumerFeign_App.class,args);
    }
}
