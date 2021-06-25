package com.sso.goods.entity.command;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: panqw
 * @Date: 2021/6/25 19:36
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommentCommand implements Serializable {
    private static final long serialVersionUID = 1L;

    private String spuId;

    private String userId;

    private String commentId;

    private String parentId;

    private String comment;

    private String imageUrl;

    private String sortType;

    private String sort;

    private Integer page;

    private Integer size;
}
