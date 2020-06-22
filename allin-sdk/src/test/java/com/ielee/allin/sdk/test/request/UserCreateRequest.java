package com.ielee.allin.sdk.test.request;

import com.ielee.allin.common.Constants;
import com.ielee.allin.common.exception.ApiException;
import com.ielee.allin.common.utils.ValidationUtils;
import com.ielee.allin.sdk.test.DemoRequest;
import com.ielee.allin.sdk.test.response.UserCreateResponse;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * 用户创建接口
 */
@Data
public class UserCreateRequest implements DemoRequest<UserCreateResponse> {
    private UserCreateDO data;

    @Override
    public String getApiMethodName() {
        return "user/create";
    }

    @Override
    public Map<String, Object> getQueryParams() {
        return null;
    }

    @Override
    public Object getPostParams() {
        return data;
    }

    @Override
    public Class<UserCreateResponse> getResponseClazz() {
        return UserCreateResponse.class;
    }

    @Override
    public void check() throws ApiException {
        ValidationUtils.validate(data);
    }

    @Override
    public String getHttpMethod() {
        return Constants.HTTP_METHOD_POST;
    }

    @Data
    public static class UserCreateDO {
        private Integer id;
        @NotEmpty(message = "昵称不能为空!")
        private String nickName;
    }
}
