package com.ielee.openfeign.api.consumer.rest;

import com.ielee.openfeign.api.demo.DemoApi1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer1")
public class ConsumerRest1 {
    @Autowired
    private DemoApi1 demoApi1;

//    @FeignClient(name = "demofeign", path = "demo", url = "http://localhost:8089")
//    interface DemoApi {
//        @GetMapping("detail")
//        String detail(@RequestParam("str") String str);
//    }

    //    @Autowired
//    private FeignClientService feignClientService;
//
    @GetMapping("detail")
    public ResponseEntity detail() {
        System.out.println("test");
        String res = demoApi1.detail("hello world");
        return ResponseEntity.ok(res);
    }
}
