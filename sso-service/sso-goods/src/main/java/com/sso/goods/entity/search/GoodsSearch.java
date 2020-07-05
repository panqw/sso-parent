package com.sso.goods.entity.search;

import com.sso.common.command.BaseCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品搜索条件
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsSearch extends BaseCommand{

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 一级分类
     */
    private Integer category1Id;

    /**
     * 二级分类
     */
    private Integer category2Id;

    /**
     * 三级分类
     */
    private Integer category3Id;

    /**
     * 审核状态 0 待审核，2 已审核，4 已驳回
     */
    private String status;

    /**
     * 是否上架 0 已下线，2已上线
     */
    private String isMarketable;

}
