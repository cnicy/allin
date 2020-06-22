package com.ielee.allin.sdk.test.request;

import com.ielee.allin.common.Constants;
import com.ielee.allin.common.exception.ApiException;
import com.ielee.allin.common.utils.CheckUtils;
import com.ielee.allin.sdk.test.DemoRequest;
import com.ielee.allin.sdk.test.response.UserDetailGetResponse;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据用户ID,获取用户详情
 */
@Data
public class UserDetailGetRequest implements DemoRequest<UserDetailGetResponse> {
    /**
     * 用户ID
     */
    private Integer id;

    @Override
    public String getApiMethodName() {
        return "user/detail";
    }

    @Override
    public Map<String, Object> getQueryParams() {
        Map<String,Object> params = new HashMap<>();
        params.put("id",this.id);

        return params;
    }

    @Override
    public Object getPostParams() {
        return null;
    }

    @Override
    public Class<UserDetailGetResponse> getResponseClazz() {
        return UserDetailGetResponse.class;
    }

    @Override
    public void check() throws ApiException {
        CheckUtils.checkNotEmpty(id,"id");
    }

    @Override
    public String getHttpMethod() {
        return Constants.HTTP_METHOD_GET;
    }
}
