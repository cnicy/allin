package com.ielee.allin.springboot.common;

public class InvokeResult<T> {
    private int code;
    private String msg;
    private T data;

    public static InvokeResult success() {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setMsg("提交成功!");
        invokeResult.setCode(200);

        return invokeResult;
    }

    public static InvokeResult success(Object data) {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setData(data);
        invokeResult.setCode(200);
        invokeResult.setMsg("提交成功!");

        return invokeResult;
    }

    public static InvokeResult failure(String msg) {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setCode(400);
        invokeResult.setMsg(msg);

        return invokeResult;
    }

    public static InvokeResult failure(int code, String msg) {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setCode(code);
        invokeResult.setMsg(msg);

        return invokeResult;
    }

    public static InvokeResult error() {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setCode(500);
        invokeResult.setMsg("服务内部错误!");

        return invokeResult;
    }

    public static InvokeResult passNoData() {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setCode(201);
        invokeResult.setMsg("查询数据为空!");

        return invokeResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return this.code > 1000 ? 400 : this.code;
    }
}
