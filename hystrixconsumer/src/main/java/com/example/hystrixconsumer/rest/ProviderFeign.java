package com.example.hystrixconsumer.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider", fallback = FeignFallback.class)
public interface ProviderFeign {
    @GetMapping("/provider/feignTest")
    String feignTest();
}
