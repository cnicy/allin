package com.ielee.allin.sdk.web;

import com.ielee.allin.common.InvokeResult;
import com.ielee.allin.sdk.common.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class DemoUserController {
    @GetMapping("detail")
    public InvokeResult<User> detail(Integer id) {
        User user = new User();
        user.setId(id);
        user.setNickName("demo");

        return InvokeResult.success(user);
    }

    @PostMapping("create")
    public InvokeResult create(@RequestBody User user) {
        System.out.println(user.toString());

        return InvokeResult.success();
    }
}