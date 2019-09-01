package chrishi.springcloud.controller;

import com.chrishi.springcloud.entities.Dept;
import chrishi.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){
        return service.add(dept);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        return service.list();
    }


    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery(){
        return service.discovery();
    }
}
