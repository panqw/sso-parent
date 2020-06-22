package com.sso.goods.service.impl;

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

}
