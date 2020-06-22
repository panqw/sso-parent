package com.sso.goods.entity.command;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sso.common.command.BaseCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @NotNull
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
