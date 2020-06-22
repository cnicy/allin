package com.ielee.allin.sdk.test;

import com.ielee.allin.common.exception.ApiException;
import com.ielee.allin.sdk.test.request.UserCreateRequest;
import com.ielee.allin.sdk.test.request.UserDetailGetRequest;
import com.ielee.allin.sdk.test.response.UserCreateResponse;
import com.ielee.allin.sdk.test.response.UserDetailGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestTemplateTest {
    private static RestTemplate restTemplate;

    public static void main(String[] args) throws ApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1);
        restTemplate.getForEntity("http://localhost:8080/user/detail?id={id}", null,params);

        DemoClient client = new DefaultDemoClient("http://localhost:8080/",null,null);
        // 请求构建
        UserDetailGetRequest request = new UserDetailGetRequest();
        request.setId(1);
        // 返回参数
        UserDetailGetResponse res =  client.execute(request);
        System.out.println(res.getData());

        UserCreateRequest re = new UserCreateRequest();
        UserCreateRequest.UserCreateDO dto = new UserCreateRequest.UserCreateDO();
        dto.setNickName("jack");
        re.setData(dto);
        UserCreateResponse res1 =  client.execute(re);
        System.out.println(res1.getCode());
    }
}
