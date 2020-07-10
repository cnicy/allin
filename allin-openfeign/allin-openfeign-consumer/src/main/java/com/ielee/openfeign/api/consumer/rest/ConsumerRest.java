package com.ielee.openfeign.api.consumer.rest;

import com.ielee.openfeign.api.demo.DemoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerRest {
    @Autowired
    private DemoApi demoApi;

    @GetMapping("call")
    public ResponseEntity call() {
        // RPC
        String res = demoApi.hello("world");
        return ResponseEntity.ok(res);
    }

    @GetMapping("detail1")
    public ResponseEntity detail1(){
        ResponseEntity<String> res = demoApi.detail1();
        return ResponseEntity.ok(res.getBody());
    }
}
