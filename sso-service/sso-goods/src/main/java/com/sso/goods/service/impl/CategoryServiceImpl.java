package com.sso.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sso.common.entity.PageResult;
import com.sso.common.entity.StatusCode;
import com.sso.common.exception.GlobalExecption;
import com.sso.common.utils.BeanUtils;
import com.sso.goods.entity.Category;
import com.sso.goods.dao.CategoryMapper;
import com.sso.goods.entity.command.CategoryCommand;
import com.sso.goods.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     *新增商品分类
     */
    @Transactional
    @Override
    public Integer addCategory(@Valid CategoryCommand command) {
        Category category = categoryMapper.selectByName(command.getName());
        Optional.ofNullable(category).ifPresent(u -> {
            throw new GlobalExecption("此分类已存在");
        });
        Category newCategory = BeanUtils.copyProperties(command, Category.class);
        Date date = new Date();
        newCategory.setCreateTime(date);
        newCategory.setUpdateTime(date);
        newCategory.setCreateBy("PQW");
        newCategory.setUpdateBy("PQW");

        return categoryMapper.insert(newCategory);
    }

    /**
     *
     * 更新商品分类
     */
    @Transactional
    @Override
    public Integer updateCategory(@Valid CategoryCommand command) {
        Category category = categoryMapper.selectByName(command.getName());
        if(category!=null && !command.getId().equals(category)){
            throw new GlobalExecption("此分类已存在");
        }
        Category newCategory = BeanUtils.copyProperties(command, Category.class);
        Date date = new Date();
        newCategory.setUpdateTime(date);
        newCategory.setUpdateBy("PQW");

        return categoryMapper.updateById(newCategory);
    }

    /**
     *
     * 查找商品分类列表
     */
    @Override
    public PageResult<Category> findCategoryList(@Valid CategoryCommand command) {

        PageHelper.startPage(command.getPage(), command.getRows());
        List<Category> categoryList = categoryMapper.selectCategoryList(command);

        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        PageResult<Category> pageResult = new PageResult<>();
        pageResult.setCode(StatusCode.OK);
        pageResult.setCount(pageInfo.getTotal());
        pageResult.setData(categoryList);
        pageResult.setMessage("商品分类查询成功");

        return pageResult;
    }

    /**
     *通过id查询商品分类
     */
    @Override
    public Category findCategory(Integer id) {
        return categoryMapper.selectById(id);
    }
    /**
     *通过parentId查询商品分类集合
     */
    @Override
    public List<Category> findListByParentId(Integer parentId) {
        return categoryMapper.selectListByParentId(parentId);
    }

    @Override
    public Integer deleteCategory(Integer id) {
        Category category = categoryMapper.selectById(id);
        Optional.ofNullable(category).orElseThrow(()->new GlobalExecption("您要删的为空"));
        category.setIsDeleted(1);
        return categoryMapper.updateById(category);
    }

}
