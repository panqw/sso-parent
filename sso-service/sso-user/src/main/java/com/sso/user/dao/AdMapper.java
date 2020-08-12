package com.sso.user.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sso.user.model.Ad;
import org.springframework.stereotype.Component;


/**
 * <p>
 *  广告模块接口
 * </p>
 *
 * @author wuyang
 * @since 2020-08-05
 */
@Component
public interface AdMapper extends BaseMapper<Ad> {
    void saveAd(Ad ad);
}
