package com.sso.user.model.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户入参类
 */
@Data
public class UserCommand implements Serializable{
    /**
     * 用户名
     */
    @NotNull
    private String username;

    /**
     * 密码，加密存储
     */
    @NotNull
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    private String email;
}
