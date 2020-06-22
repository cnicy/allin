package com.ielee.allin.sdk.test;

import com.ielee.allin.common.Constants;
import com.ielee.allin.common.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 默认处理类
 */
public class DefaultDemoClient implements DemoClient {
    protected String serverUrl;
    protected String appKey;
    protected String appSecret;
    protected String format = Constants.FORMAT_JSON;
    protected boolean needCheckRequest = true; // 是否在客户端校验请求
    protected RestTemplate restTemplate = new RestTemplate();

    /**
     * 默认实现
     *
     * @param serverUrl 服务请求url
     * @param appKey    请求加密key
     * @param appSecret 请求加密Secret
     */
    public DefaultDemoClient(String serverUrl, String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.serverUrl = serverUrl;
    }

    public DefaultDemoClient(String serverUrl, String appKey, String appSecret, String format) {
        this(serverUrl, appKey, appSecret);
        this.format = format;
    }

    @Override
    public <T extends DemoResponse> T execute(DemoRequest<T> request) throws ApiException {
        // 本地参数校验
        if (this.needCheckRequest) {
            request.check();
        }
        // 构建URL
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serverUrl);
        // 构建http path
        builder.path(request.getApiMethodName());

        // builder query params
        if (null != request.getQueryParams() && request.getQueryParams().size() > 0) {
            request.getQueryParams().entrySet().stream().forEach(o ->
                    builder.queryParam(o.getKey(), o.getValue()));
        }

        ResponseEntity<T> rsp = null;
        if (request.getHttpMethod().equals(Constants.HTTP_METHOD_GET)) {
            // do get
            rsp = restTemplate.getForEntity(builder.build().encode().toString(),
                    request.getResponseClazz());
            return rsp.getBody();
        } else if (request.getHttpMethod().equals(Constants.HTTP_METHOD_POST)) {
            // go post
            rsp = restTemplate.postForEntity(builder.build().encode().toString(),
                    request.getPostParams(), request.getResponseClazz());
        }
        return rsp.getBody();
    }

    @Override
    public <T extends DemoResponse> T execute(DemoRequest<T> request, String session) throws ApiException {
        return null;
    }
}
