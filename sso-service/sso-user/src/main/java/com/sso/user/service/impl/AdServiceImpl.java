package com.sso.user.service.impl;

import com.sso.user.dao.AdMapper;
import com.sso.user.model.Ad;
import com.sso.user.service.AdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  广告模块实现类
 * </p>
 *
 * @author wuyang
 * @since 2020-08-05
 */
@Service
public class AdServiceImpl extends ServiceImpl<AdMapper, Ad> implements AdService {

    @Autowired
    private AdMapper adMapper;

    @Override
    public void saveAd(Ad ad) {
        adMapper.saveAd(ad);
    }
}
