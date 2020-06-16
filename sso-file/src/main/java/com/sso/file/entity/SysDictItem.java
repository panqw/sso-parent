package com.sso.file.entity;


import lombok.Data;

import java.util.Date;

@Data
public class SysDictItem  {

    private Long sysDictItemId;

    /**
     * 数据类型
     */

    private String dataType;

    /**
     * 数据KEY
     */
    private String dataKey;

    /**
     * 数据VALUE
     */
    private String dataValue;

    /**
     * 排序
     */
    private Integer dispOrder;

    /**
     * 扩展字段1
     */
    private String extText1;

    /**
     * 扩展字段2
     */
    private String extText2;

    /**
     * 扩展字段3
     */
    private String extText3;

    /**
     * 数据更新
     */
    private Date updateTime;


}