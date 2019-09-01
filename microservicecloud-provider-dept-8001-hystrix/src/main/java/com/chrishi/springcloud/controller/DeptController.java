package com.chrishi.springcloud.controller;

import com.chrishi.springcloud.entities.Dept;
import com.chrishi.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String>  list = client.getServices();
        System.out.println("********************"+list);
        List<ServiceInstance> serviceInstanceList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance instance:serviceInstanceList){
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }
        return this.client;
    }


    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = deptService.get(id);
        if(dept == null){
            throw new RuntimeException("该ID"+id+"没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id")Long id){
        return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应的信息,null--@HystrixCommand").setDb_source("no this database in Mysql");
    }

    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> get(){
        return deptService.list();
    }

}
