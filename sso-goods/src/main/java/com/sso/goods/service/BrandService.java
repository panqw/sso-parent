package com.sso.goods.service;

import com.sso.common.command.BaseCommand;
import com.sso.goods.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.goods.entity.command.BrandCommand;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
public interface BrandService extends IService<Brand> {
    /**
     *
     * @param baseCommand
     * @return
     */
    List<Brand> findBrandList(BrandCommand baseCommand);

    Brand findById(Integer id);

    Integer createBrand(BrandCommand command);
}
