package com.sso.goods.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Auther: panqw
 * @Date: 2021/6/25 19:55
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommentVo {
    private static final long serialVersionUID = 1L;

    private String spuId;

    private String userId;

    private String commentId;

    private String parentId;

    private String comment;

    private String imageUrl;

    private List<CommentVo> commentVoList;
}
