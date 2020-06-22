package com.ielee.allin.common.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;

/**
 * 手动调用api方法校验对象
 */
public class ValidationUtils {
    public static void validate(@Valid Object user) {
        Set<ConstraintViolation<@Valid Object>> validateSet = Validation.buildDefaultValidatorFactory()
                .getValidator()
                .validate(user, new Class[0]);

        if (null != validateSet && validateSet.size() > 0) {
            String messages = validateSet.stream()
                    .map(ConstraintViolation::getMessage)
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");

            throw new IllegalArgumentException(messages);
        }
    }
}