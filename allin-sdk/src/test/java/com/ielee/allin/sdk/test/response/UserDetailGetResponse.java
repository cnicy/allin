package com.ielee.allin.sdk.test.response;

import com.ielee.allin.sdk.test.DemoResponse;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDetailGetResponse extends DemoResponse {
    private UserDetailDO data;

    @Data
    public static class UserDetailDO implements Serializable{
        private Integer id;
        private String nickName;
    }
}

