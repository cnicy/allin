package com.ielee.allin.springboot.config.validate;

import com.ielee.allin.springboot.common.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理Handler
 */
@ControllerAdvice
public class ExceptionErrorHandler {
    /**
     * 内部错误异常
     *
     * @param e
     * @param request
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object exception(Exception e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 业务异常判定
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    public Object restStatusException(BizException e) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
    }
    // TODO 可以根据自身情况进行异常处理类编写和返回逻辑编写
}