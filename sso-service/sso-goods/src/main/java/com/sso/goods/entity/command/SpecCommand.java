package com.sso.goods.entity.command;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * 规格
 * @author panqw
 * @date 2020/6/24 12:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpecCommand {

    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    @NotNull
    private String name;

    /**
     * 规格选项
     */
    private String options;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 模板ID
     */
    @NotNull
    private Integer templateId;
}
