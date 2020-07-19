package com.sso.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.user.model.User;
import com.sso.user.model.command.UserCommand;
import com.sso.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author panqw
 * @since 2020-06-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findUserInfo")
    public User findUserInfo(@RequestParam("username") String username) {
        return userService.findById(username);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/findAllId")
    public List<User> findAllId(@RequestParam("id")String id){
        return userService.findAllId(Integer.parseInt(id));
    }

    /**
     * 查询所有用户
     * @param user
     * @return
     */
    @GetMapping("/UserList")
    public List<User> userList(User user){
        return userService.userList(user);
    }


    /**
     * 分页查询
     */
    @PostMapping(value = "/findPage/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) User user, @PathVariable  int page, @PathVariable  int size){
        //执行搜索
        PageInfo<User> pageInfo = userService.findPage(user, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody @Valid UserCommand command){
        try {
            int i = userService.register(command);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
        return new Result(true, StatusCode.OK,"注册成功");
    }

    /**
     *修改用户信息
     */

    @PutMapping(value="/{id}")
    public Result upDate(@RequestBody User user,@PathVariable Integer id){
        user.setId(id);
        userService.upDate(user);
        return new Result(true,StatusCode.OK,"修改成功");
    }
}
