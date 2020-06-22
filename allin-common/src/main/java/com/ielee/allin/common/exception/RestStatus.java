package com.ielee.allin.common.exception;

public interface RestStatus {
    /**
     * 状态码
     *
     * @return
     */
    int code();

    /**
     * 状态描述
     *
     * @return
     */
    String msg();

    /**
     * 自定义异常消息
     *
     * @param msg
     */
    void setMsg(String msg);
}
