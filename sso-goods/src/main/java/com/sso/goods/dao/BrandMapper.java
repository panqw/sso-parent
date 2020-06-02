package com.sso.goods.dao;

import com.sso.common.command.BaseCommand;
import com.sso.goods.entity.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@Repository
public interface BrandMapper extends BaseMapper<Brand> {

    List<Brand> queryBrandList(BaseCommand baseCommand);
}
