package com.ielee.openfeign.api.provider.impl;

import com.ielee.openfeign.api.demo.DemoApi;
import com.ielee.openfeign.api.demo.auth.AuthContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoRest implements DemoApi {
    @Override
    public String hello(String str) {
        String token = AuthContext.getRequestHeader("Token");
        System.out.println(token);
        System.out.println("provider " + str);
        return "hello " + str;
    }

    @Override
    public ResponseEntity<String> detail1() {
        return ResponseEntity.ok("hello world!");
    }
}