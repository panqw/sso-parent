package com.sso.user.service;

import com.sso.user.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.user.model.command.UserCommand;

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
}
