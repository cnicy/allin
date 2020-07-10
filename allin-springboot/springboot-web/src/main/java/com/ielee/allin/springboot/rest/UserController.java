package com.ielee.allin.springboot.rest;

import com.ielee.allin.springboot.rest.command.UserCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户Controller
 */
@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping("create")
    public ResponseEntity createUser(@RequestBody @Validated UserCommand user) {
        return ResponseEntity.ok(user);
    }


    /**
     * 正常返回
     * curl -i http://localhost:8080/user/hello
     * HTTP/1.1 200
     * Content-Type: application/json
     * Transfer-Encoding: chunked
     * Date: Thu, 02 Jul 2020 12:05:32 GMT
     * <p>
     * {"id":1,"name":"kissy"}
     *
     * @return
     */
    @GetMapping("hello")
    public ResponseEntity hello() {
        User u = new User();
        u.setId(1);
        u.setName("kissy");

        return ResponseEntity.ok(u);
    }

    /**
     * 返回参数异常
     * curl -i http://localhost:8080/user/detail
     * HTTP/1.1 400
     * Content-Length: 0
     * Date: Thu, 02 Jul 2020 12:05:54 GMT
     * Connection: close
     *
     * @return
     */
    @GetMapping("detail")
    public ResponseEntity detail(Integer id) {
        if (null == id) {
            return ResponseEntity.badRequest().build();
        }
        User u = new User();
        u.setId(1);
        u.setName("kissy");

        return ResponseEntity.ok(u);
    }

    /**
     * 返回500内部错误
     * curl -i http://localhost:8080/user/error
     * HTTP/1.1 500
     * Content-Length: 0
     * Date: Thu, 02 Jul 2020 12:06:08 GMT
     * Connection: close
     *
     * @return
     */
    @GetMapping("error")
    public ResponseEntity error() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
