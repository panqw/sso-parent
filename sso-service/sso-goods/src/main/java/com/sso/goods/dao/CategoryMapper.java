package com.sso.goods.dao;

import com.sso.goods.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sso.goods.entity.command.CategoryCommand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;

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

    List<Category> selectCategoryList(CategoryCommand command);

    List<Category> selectListByParentId(@Param("parentId") Integer parentId);
}
