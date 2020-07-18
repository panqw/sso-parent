
package com.sso.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sso.user.dao.UserMapper;
import com.sso.user.model.User;
import com.sso.user.model.command.UserCommand;
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
import java.util.Map;

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

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public List<User> findAllId(int id) {
        return userMapper.findAllId(id);
    }

    /**
     * 查询所有
     * @param user
     * @return
     */
    @Override
    public List<User> userList(User user) {
        return userMapper.userList(user);
    }

    /**
     * 分页查询逻辑
     * @param user
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<User> findPage(User user, int page, int size) {
        PageHelper.startPage(page,size);
        List<User> users = userMapper.userList(user);
        //执行搜索
        return new PageInfo<User>(users);
    }


}
