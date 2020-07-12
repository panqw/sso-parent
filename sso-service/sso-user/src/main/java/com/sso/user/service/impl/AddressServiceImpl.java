package com.sso.user.service.impl;

import com.sso.user.dao.AddressMapper;
import com.sso.user.dao.UserMapper;
import com.sso.user.model.Address;
import com.sso.user.model.User;
import com.sso.user.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuyang
 * @since 2020-07-12
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressMapper addressmapper;
    @Autowired
    private User user;

    @Override
    public Address findById(String id) {
        Address address = addressmapper.selectById(id);
        User user = new User();

        return null;
    }
}
