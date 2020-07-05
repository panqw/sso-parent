package com.sso.goods.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Spu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 货号
     */
    private String sn;

    /**
     * SPU名
     */
    private String name;

    /**
     * 副标题
     */
    private String caption;

    /**
     * 品牌ID
     */
    private Integer brandId;

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
     * 模板ID
     */
    private Integer templateId;

    /**
     * 运费模板id
     */
    private Integer freightId;

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
     * 销量
     */
    private Integer saleNum;

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 是否上架
     */
    private String isMarketable;

    /**
     * 是否启用规格
     */
    private String isEnableSpec;


    /**
     * 审核状态
     */
    private String status;

    /**
     *创建时间
     */
    private String createBy;
    /**
     *创建时间
     */
    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer isDeleted;




}
