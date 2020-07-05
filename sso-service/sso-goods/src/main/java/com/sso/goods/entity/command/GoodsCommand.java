package com.sso.goods.entity.command;

import com.sso.goods.entity.Sku;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsCommand {

    /**
     * 商品
     */
    @NotNull
    private Long id;

    /**
     * 货号
     */
    @NotNull
    private String sn;

    /**
     * SPU名
     */
    @NotNull
    private String name;

    /**
     * 副标题
     */
    @NotNull
    private String caption;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 一级分类
     */
    private Long category1Id;

    /**
     * 二级分类
     */
    private Long category2Id;

    /**
     * 三级分类
     */
    private Long category3Id;

    /**
     * 模板ID
     */
    private Long templateId;

    /**
     * 运费模板id
     */
    private Long freightId;

    /**
     * 图片
     */
    private String image;

    /**
     * 图片列表
     */
    private String images;

    /**
     * 售后服务
     */
    private String saleService;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 规格列表
     */
    private String specItems;

    /**
     * 参数列表
     */
    private String paraItems;

    /**
     * SKU列表
     */
    private List<Sku> skuList;

}
