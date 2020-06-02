package com.sso.goods.entity.command;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sso.common.command.BaseCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * 品牌请求类
 * @author panqw
 * @date 2020/6/1 22:13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BrandCommand extends BaseCommand {

    /**
     * 品牌id
     */
    private Integer id;

    /**
     * 品牌名称
     */
    @NotNull
    private String name;

    /**
     * 品牌图片地址
     */
    @NotNull
    private String image;

    /**
     * 品牌的首字母
     */
    @NotNull
    private String letter;

    /**
     * 排序
     */
    private Integer seq;
}
