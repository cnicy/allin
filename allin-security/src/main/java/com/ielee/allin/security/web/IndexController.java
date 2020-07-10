package com.ielee.allin.security.web;

import com.ielee.allin.security.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("index")
public class IndexController {
    @GetMapping("detail")
    public User detail(Integer id) {
        User u = new User();
        u.setEmail("cn@aaa");
        u.setId(id);

        return u;
    }

    @PostMapping("create")
    public User create(@RequestBody User user) {
        return user;
    }
}
