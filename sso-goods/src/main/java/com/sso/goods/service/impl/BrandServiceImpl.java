package com.sso.goods.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.sso.common.exception.GlobalExecption;
import com.sso.goods.entity.Brand;
import com.sso.goods.dao.BrandMapper;
import com.sso.goods.entity.command.BrandCommand;
import com.sso.goods.service.BrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Brand> brandList = brandMapper.queryBrandList(command);

        return brandList;
    }

    /**
     * 通过id查询品牌明细
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        Brand brand = brandMapper.selectById(id);
        if (brand != null) {
            throw new GlobalExecption("无此品牌");
        }
        return brand;
    }

    @Override
    public Integer createBrand(BrandCommand command) {
        Brand brand = new Brand();
        BeanUtil.copyProperties(command,brand);
        brand.setCreateBy("PQW");
        brand.setUpdateBy("PQW");
        Date date = new Date();
        brand.setCreateTime(date);
        brand.setUpdateTime(date);

        Integer num = brandMapper.insert(brand);

        return num;
    }
}
