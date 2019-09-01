package chrishi.springcloud.service;

import com.chrishi.springcloud.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {


    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);

    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> list();


    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery();
}
