package com.sso.goods.service.impl;


import com.github.pagehelper.PageHelper;
import com.sso.common.exception.GlobalExecption;
import com.sso.common.utils.BeanUtils;
import com.sso.goods.entity.Brand;
import com.sso.goods.dao.BrandMapper;
import com.sso.goods.entity.command.BrandCommand;
import com.sso.goods.service.BrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 分页查询品牌列表
     * @param command
     * @return
     */
    @Override
    public List<Brand> findBrandList(BrandCommand command) {
        PageHelper.startPage(command.getPage(), command.getRows());
        return brandMapper.queryBrandList(command);
    }

    /**
     * 通过id查询品牌明细
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        Brand brand = brandMapper.selectById(id);
        if (brand == null) {
            throw new GlobalExecption("无此品牌");
        }
        return brand;
    }

    @Transactional
    @Override
    public Integer addBrand(BrandCommand command) {
        Brand brand = BeanUtils.copyProperties(command, Brand.class);
        brand.setCreateBy("PQW");
        brand.setUpdateBy("PQW");
        Date date = new Date();
        brand.setCreateTime(date);
        brand.setUpdateTime(date);

        return brandMapper.insert(brand);
    }

    @Transactional
    @Override
    public Integer updateBrand(@Valid BrandCommand command) {
        Brand brand = BeanUtils.copyProperties(command, Brand.class);
        brand.setUpdateBy("PQW");
        brand.setUpdateTime(new Date());

        return brandMapper.updateById(brand);
    }
}
