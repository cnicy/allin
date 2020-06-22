package com.ielee.allin.common.exception;

/**
 * API 异常处理类
 */
public class ApiException extends Exception {
    public ApiException() {
    }

    private RestStatus restStatus;

    public ApiException(RestStatus status) {
        super(status.msg());
        this.restStatus = status;
    }

    public ApiException(String message) {
        super(message);
        this.restStatus = StatusCode.INVALID_MODEL_FIELDS;
        this.restStatus.setMsg(message);
    }
}