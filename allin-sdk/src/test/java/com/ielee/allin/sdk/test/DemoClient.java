package com.ielee.allin.sdk.test;

import com.ielee.allin.common.exception.ApiException;

public interface DemoClient {
    /**
     * 执行公开API请求。
     *
     * @param <T>     具体的API响应类
     * @param request 具体的API请求类
     * @return 具体的API响应
     */
    <T extends DemoResponse> T execute(DemoRequest<T> request) throws ApiException;

    /**
     * 执行隐私API请求。
     *
     * @param <T>     具体的API响应类
     * @param request 具体的API请求类
     * @param session 用户授权码
     * @return 具体的API响应
     */
    <T extends DemoResponse> T execute(DemoRequest<T> request, String session) throws ApiException;
}