package com.sso.user.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sso.user.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;


import java.util.List;

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
    //根据id查询用户信息
    List<User> findAllId(int id);

    //查询所有的用户信息
    List<User> userList(User user);

    //修改用户信息
    void upDate(User user);
}
