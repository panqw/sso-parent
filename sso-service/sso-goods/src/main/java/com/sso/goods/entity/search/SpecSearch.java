package com.sso.goods.entity.search;

import com.sso.common.command.BaseCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 规格搜索条件
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SpecSearch extends BaseCommand{

    private Integer id;

    /**
     * 名称
     */
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
    private Integer templateId;
}
