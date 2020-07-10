package com.ielee.allin.security.web;

import com.ielee.allin.security.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @author kissy
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("detail")
    public User detail(Integer id, HttpServletRequest request) {
        User u = new User();
        u.setEmail("cn@aaa");
        u.setId(id);

        Enumeration<String> list = request.getHeaderNames();
        while (list.hasMoreElements()) {
            String header = list.nextElement();
            System.out.println(header +":"+request.getHeader(header));
            if (null != header && header.equals("jwt_payload")) {
                u.setPayload(request.getHeader(header));
            }
        }
        return u;
    }

    @PostMapping("create")
    public User create(@RequestBody User user) {
        return user;
    }
}
