package com.sso.user.dao;

import com.sso.user.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author panqw
 * @since 2020-06-19
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    User findAllId(int id);
}
