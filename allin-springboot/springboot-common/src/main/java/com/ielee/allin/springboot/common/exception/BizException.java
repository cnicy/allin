package com.ielee.allin.springboot.common.exception;

/**
 * 自定义业务统一异常处理类
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = -2359843215972162510L;
    private RestStatus restStatus;

    public BizException() {
    }

    public BizException(RestStatus status) {
        this.restStatus = status;
    }

    public BizException(String message){
        super(message);
        //this.restStatus = StatusCode.INVALID_MODEL_FIELDS;
    }

    public RestStatus getRestStatus() {
        return this.restStatus;
    }
}