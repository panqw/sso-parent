package com.sso.common.command;

import lombok.Data;

import java.io.Serializable;

/**
 * 基础请求实体类
 * @author panqw
 * @date 2020/6/1 22:02
 */
@Data
public class BaseCommand implements Serializable {

    private Integer page = 1;   //当前页

    private Integer start=1;

    private Integer rows = 10;

    private String ip;
}
