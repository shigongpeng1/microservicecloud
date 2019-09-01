package chrishi.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
