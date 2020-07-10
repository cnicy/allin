package com.ielee.openfeign.api.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "demo-service1", path = "demo1", url = "http://localhost:8089")
public interface DemoApi1 {
    @GetMapping("demo")
    String detail(@RequestParam("str") String str);
}
