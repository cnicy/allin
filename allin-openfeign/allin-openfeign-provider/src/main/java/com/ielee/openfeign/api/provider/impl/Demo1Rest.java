package com.ielee.openfeign.api.provider.impl;

import com.ielee.openfeign.api.demo.DemoApi1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo1")
public class Demo1Rest implements DemoApi1 {
    @Override
    public String detail(String str) {
        return str;
    }
}