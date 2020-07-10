package com.ielee.allin.springboot.rest.command;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * User映射实体
 * @author kissy
 */
@Data
public class UserCommand implements Serializable {
    @NotNull(message = "用户id不能为空！")
    private Long id;  
  
    @NotEmpty(message = "name不能为空！")
    @Length(min = 5, max = 20, message = "参数错误，name长度为5-20！")
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "name参数不合法！")
    private String name;
}