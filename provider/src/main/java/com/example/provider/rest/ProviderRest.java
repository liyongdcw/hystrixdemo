package com.example.provider.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderRest {
    @Value("${server.port}")
    private String port;

    @GetMapping("/feignTest")
    public String feignTest(){
        return "==== feign接口调用成功 ==== | 端口号："+this.port;
    }
}
