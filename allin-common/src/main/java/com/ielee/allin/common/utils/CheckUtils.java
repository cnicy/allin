package com.ielee.allin.common.utils;

import com.ielee.allin.common.exception.ApiException;

/**
 * 自动检查工具
 */
public class CheckUtils {
    public static void checkNotEmpty(Object value, String fieldName) throws ApiException {
        if (value == null) {
            throw new ApiException("client-error:Missing required arguments:" + fieldName + "");
        }
        if (value instanceof String) {
            if (((String) value).trim().length() == 0) {
                throw new ApiException("client-error:Missing required arguments:" + fieldName + "");
            }
        }
    }

    public static void checkMaxLength(String value, int maxLength, String fieldName) throws ApiException {
        if (value != null) {
            if (value.length() > maxLength) {
                throw new ApiException("client-error:Invalid arguments:the string length of " + fieldName + " can not be larger than " + maxLength + ".");
            }
        }
    }

    public static void checkMaxValue(Long value, long maxValue, String fieldName) throws ApiException {
        if (value != null) {
            if (value > maxValue) {
                throw new ApiException("client-error:Invalid arguments:the value of " + fieldName + " can not be larger than " + maxValue + ".");
            }
        }
    }

    public static void checkMinValue(Long value, long minValue, String fieldName) throws ApiException {
        if (value != null) {
            if (value < minValue) {
                throw new ApiException("client-error:Invalid arguments:the value of " + fieldName + " can not be less than " + minValue + ".");
            }
        }
    }
}
