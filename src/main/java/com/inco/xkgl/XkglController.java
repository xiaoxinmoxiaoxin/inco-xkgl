package com.inco.xkgl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("xkgl")
public class XkglController {

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("xkgl")
    @HystrixCommand(fallbackMethod = "callXtgl")
    public void xkgl(){
        restTemplate.getForObject("http://INCO-XTGL/xtgl/xtgl", String.class);


        System.out.println("xkgl");
    }

    public void callXtgl(){
        System.out.println("选课管理调用系统管理失败");
    }
}
