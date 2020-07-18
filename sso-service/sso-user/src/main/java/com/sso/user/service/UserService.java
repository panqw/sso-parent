package com.sso.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.sso.user.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.user.model.command.UserCommand;


import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author panqw
 * @since 2020-06-19
 */
public interface UserService extends IService<User> {

    User findById(String username);

    int register(UserCommand command);

    List<User> findAllId(int id);

    List<User> userList(User user);

    PageInfo<User> findPage(User user, int page, int size);


}
