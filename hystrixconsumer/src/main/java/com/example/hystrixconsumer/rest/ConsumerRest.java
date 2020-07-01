package com.example.hystrixconsumer.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerRest {
    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("/normal")
    public String normal() {
        return "==== 访问正常返回 =====";
    }

    @GetMapping("/comm")
    @HystrixCommand(fallbackMethod = "quickFail")
    public String comm() {
        int a = 3/0;
        return "==== comm 方法正常返回 =====";
    }

    @GetMapping("/feignTest")
    public String feignTest() {
        return providerFeign.feignTest();
    }

    private String quickFail() {
        return "==== comm 方法降级处理 =====";
    }
}
