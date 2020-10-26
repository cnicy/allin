package com.ielee.openfeign.api.provider.auth;

import com.ielee.openfeign.api.demo.auth.AuthContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Feign拦截器，用于传递Rpc之间的参数
 * @author kissy
 */
@Component
public class FeignRequestHeaderInterceptor implements RequestInterceptor {
    public FeignRequestHeaderInterceptor(){
        System.out.println("Feign Interceptor Init....");
    }
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = AuthContext.getRequestHeader("Token");
        if (!StringUtils.isEmpty(token)) {
            requestTemplate.header("Token", token);
        }
    }
}