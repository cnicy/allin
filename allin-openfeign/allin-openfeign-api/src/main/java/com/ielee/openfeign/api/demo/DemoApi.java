package com.ielee.openfeign.api.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * url为测试地址调用，在K8S中是应该是服务Service名称
 */
@FeignClient(value = "demo-service", path = "demo", url = "http://service-name:8089")
public interface DemoApi {
    /**
     * get请求
     *
     * @return
     */
    @GetMapping("hello")
    String hello(@RequestParam("str") String str);

    /**
     * 测试ResponseEntity
     *
     * @return
     */
    @GetMapping(value = "detail1")
    ResponseEntity<String> detail1();
}