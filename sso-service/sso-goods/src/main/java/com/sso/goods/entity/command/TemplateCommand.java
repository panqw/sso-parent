package com.sso.goods.entity.command;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TemplateCommand {

    private Integer id;
    /**
     * 模板名称
     */
    @NotNull
    private String name;

}
