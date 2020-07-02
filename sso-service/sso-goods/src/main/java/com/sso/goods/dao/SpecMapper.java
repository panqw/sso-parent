package com.sso.goods.dao;

import com.sso.goods.entity.Spec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sso.goods.entity.search.SpecSearch;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author panqw
 * @since 2020-06-24
 */
public interface SpecMapper extends BaseMapper<Spec> {

    List<Spec> findSpecList(SpecSearch search);
}
