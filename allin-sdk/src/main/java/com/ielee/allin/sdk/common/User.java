package com.ielee.allin.sdk.common;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class User {
    private Integer id;
    @NotEmpty(message = "昵称不能为空!")
    private String nickName;
}