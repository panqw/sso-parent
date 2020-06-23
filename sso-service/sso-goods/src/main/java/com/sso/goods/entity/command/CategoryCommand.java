package com.sso.goods.entity.command;


import com.sso.common.command.BaseCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CategoryCommand extends BaseCommand{

    /**
     * 商品分类id
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 是否显示
     */
    private String isShow;

    /**
     * 商品分类级别
     */
    private Integer levelType;

    /**
     * 是否导航
     */
    private String isMenu;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 上级ID,  0 顶级分类
     */
    private Integer parentId;

    /**
     * 模板ID
     */
    private Integer templateId;

}
