package com.sso.goods.entity.search;


import com.sso.common.command.BaseCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 搜素条件
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class TemplateSearch extends BaseCommand {

    private Integer id;
    /**
     * 模板名称
     */
    private String name;
}
