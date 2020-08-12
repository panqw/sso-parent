package com.sso.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.user.model.Ad;

/**
 * <p>
 *  广告模块服务类
 * </p>
 *
 * @author wuyang
 * @since 2020-08-05
 */
public interface AdService extends IService<Ad> {
    void saveAd(Ad ad);
}
