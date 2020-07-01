package com.example.hystrixconsumer.rest;

import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements ProviderFeign{
    @Override
    public String feignTest() {
        return "==== feign接口调用失败降级处理 ====";
    }
}
