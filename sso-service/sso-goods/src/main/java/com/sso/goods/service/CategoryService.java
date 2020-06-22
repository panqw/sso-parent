package com.sso.goods.service;

import com.sso.goods.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.goods.entity.command.CategoryCommand;

import javax.validation.Valid;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
public interface CategoryService extends IService<Category> {

    Integer addCategory(@Valid CategoryCommand command);

    Integer updateCategory(@Valid CategoryCommand command);
}
