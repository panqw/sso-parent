package com.sso.goods.service.impl;

import com.sso.goods.entity.Category;
import com.sso.goods.dao.CategoryMapper;
import com.sso.goods.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
