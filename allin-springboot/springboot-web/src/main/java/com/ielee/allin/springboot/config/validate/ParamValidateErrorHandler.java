package com.ielee.allin.springboot.config.validate;

import com.ielee.allin.springboot.common.InvokeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

/**
 * 添加AOP拦截器进行参数异常拦截，做统一异常处理
 * @author kissy
 */
@ControllerAdvice
public class ParamValidateErrorHandler {
    private MessageSource messageSource;
    @Autowired
    public ParamValidateErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * 提交参数验证异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity processValidationError(MethodArgumentNotValidException ex) {
        System.out.println("errrrrrrr");
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        final String err = processFieldErrors(fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                header("msg",err).
                body(InvokeResult.failure(400,err));
    }

    /**
     * 多参数校验异常信息处理
     * @param fieldErrors
     * @return
     */
    private String processFieldErrors(List<FieldError> fieldErrors) {
        // ValidationErrorDTO dto = new ValidationErrorDTO();
        StringBuffer sb = new StringBuffer();
        for (FieldError fieldError : fieldErrors) {
            String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            sb.append(localizedErrorMessage);
            sb.append(";");
        }
        return sb.toString();
    }

    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

        return localizedErrorMessage;
    }
}
