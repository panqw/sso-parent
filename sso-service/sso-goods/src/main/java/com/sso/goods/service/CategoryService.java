package com.sso.goods.service;


import com.sso.common.entity.PageResult;
import com.sso.goods.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.goods.entity.command.CategoryCommand;

import javax.validation.Valid;
import java.util.List;

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

    PageResult<Category> findCategoryList(@Valid CategoryCommand command);

    Category findCategory(Integer id);

    List<Category> findListByParentId(Integer parentId);

    Integer deleteCategory(Integer id);

}
