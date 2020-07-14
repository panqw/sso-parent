
package com.sso.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.sso.user.dao.UserMapper;
import com.sso.user.model.User;
import com.sso.user.model.command.UserCommand;
import com.sso.user.model.information.UserInformation;
import com.sso.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author panqw
 * @since 2020-06-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(String username) {
        return userMapper.selectById(username);
    }

    @Transactional
    @Override
    public int register(UserCommand command) {
        User user = userMapper.selectById(command.getUsername());
        if (user!=null){
            throw new RuntimeException("用户名已存在");
        }
        User newUser = new User();
        BeanUtil.copyProperties(command,newUser);
        newUser.setPassword(passwordEncoder.encode(command.getPassword()));
        newUser.setCreated(LocalDateTime.now());
        newUser.setUpdated(LocalDateTime.now());

        return userMapper.insert(newUser);
    }

    @Override
    public List<User> findAllId(int id) {
        return userMapper.findAllId(id);
    }


}
