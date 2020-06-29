package com.sso.goods.dao;

import com.sso.goods.entity.Template;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sso.goods.entity.search.TemplateSearch;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author panqw
 * @since 2020-06-24
 */
public interface TemplateMapper extends BaseMapper<Template> {

    List<Template> findTemplateList(TemplateSearch search);
}
