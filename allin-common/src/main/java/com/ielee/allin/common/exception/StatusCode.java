package com.ielee.allin.common.exception;

/**
 * 状态码封装
 */
public enum StatusCode implements RestStatus {
    // 请求成功
    OK(200, "请求成功"),
    OK_NO_DATA(201, "请求数据为空"),
    INVALID_MODEL_FIELDS(400, "参数有误!"),
    UNAUTHORIZED(401, "授权失败!"),
    INVALID_AUTH(403, "无权访问!"),
    SERVER_INTERNAL_ERROR(500, "服务端异常, 请稍后再试");

    private int code;
    private String msg;

    StatusCode(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String msg() {
        return this.msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
        this.code = 400;
    }
}
