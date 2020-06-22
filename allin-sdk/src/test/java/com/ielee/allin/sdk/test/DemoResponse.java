package com.ielee.allin.sdk.test;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class DemoResponse implements Serializable {
    private Integer code;
    private String msg;
}