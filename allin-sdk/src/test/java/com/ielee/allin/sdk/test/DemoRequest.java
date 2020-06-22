package com.ielee.allin.sdk.test;

import com.ielee.allin.common.exception.ApiException;

import java.util.Map;

/**
 * 统一请求封装，实现需要完成以下方法
 * @param <T>
 */
public interface DemoRequest<T extends DemoResponse> {
    /**
     * 获取API名称
     *
     * @return
     */
    String getApiMethodName();

    /**
     * 获取查询参数
     *
     * @return
     */
    Map<String, Object> getQueryParams();

    /**
     * 获取Post参数
     * @return
     */
    Object getPostParams();

    /**
     * 获取返回类型，用于反序列化
     *
     * @return
     */
    Class<T> getResponseClazz();

    /**
     * 客服端校验，减少无效的服务端调用
     */
    void check()throws ApiException;

    /**
     * 获取Http Method GET or POST
     *
     * @return
     */
    String getHttpMethod();
}
