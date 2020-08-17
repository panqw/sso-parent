package com.sso.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.user.model.Address;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuyang
 * @since 2020-07-12
 */
public interface AddressService extends IService<Address> {

    Address findById(String id);

}
