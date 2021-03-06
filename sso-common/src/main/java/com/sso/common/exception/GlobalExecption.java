package com.sso.common.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 飞鱼环球异常信息
 *
 * Create by panqiwen 2019/8/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalExecption extends RuntimeException {

    private String code;

    private String message;
    public GlobalExecption() {
    }
    public GlobalExecption(String code, String message) {
        this.code =code;
        this.message = message;
    }
    public GlobalExecption(String message) {
        this.message = message;
    }
}
