package com.sso.user.controller;


import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.user.model.User;
import com.sso.user.model.command.UserCommand;
import com.sso.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("/findAllId")
    public User findAllId(@RequestParam("id")String id){
        return userService.findAllId(Integer.parseInt(id));
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

}
