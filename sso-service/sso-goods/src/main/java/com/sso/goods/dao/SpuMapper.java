package com.sso.goods.dao;

import com.sso.goods.entity.Sku;
import com.sso.goods.entity.Spu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sso.goods.entity.search.GoodsSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@Repository
public interface SpuMapper extends BaseMapper<Spu> {

    List<Sku> findGoodsList(GoodsSearch search);
}
