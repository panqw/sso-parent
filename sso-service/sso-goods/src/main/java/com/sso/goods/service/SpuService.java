package com.sso.goods.service;

import com.sso.common.entity.PageResult;
import com.sso.common.entity.Result;
import com.sso.goods.entity.Spu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.goods.entity.command.CommentCommand;
import com.sso.goods.entity.command.GoodsCommand;
import com.sso.goods.entity.search.GoodsSearch;
import com.sso.goods.entity.vo.CommentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
public interface SpuService extends IService<Spu> {

    Result addGoods(GoodsCommand command);

    PageResult findGoodsList(GoodsSearch search);

    void search(String searchParam, String userId);

    List<String> getSearch(String userId);

    void addComment(CommentCommand command);

    List<CommentVo> getComment(CommentCommand command);
}
