package com.sso.goods.dao;

import com.sso.goods.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品类目 Mapper 接口
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@Component
public interface CategoryMapper extends BaseMapper<Category> {

    Category selectByName(@Param("name") String name);
}
