package com.sso.goods.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author panqw
 * @date 2020/6/23 23:14
 */
@Data
public class BrandVo {

    /**
     * 品牌id
     */
    private Integer id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌图片地址
     */
    private String image;

    /**
     * 品牌的首字母
     */
    private String letter;
    /**
     * 商品数量
     */
    private Integer goodsNum;
    /**
     * 评论数量
     */
    private Integer commentNum;

    /**
     * 排序
     */
    private Integer seq;
}
