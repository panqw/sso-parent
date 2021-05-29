package com.sso.oauth.controller;

import com.sso.oauth.feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @PostMapping("getUser")
    public void getUser(){
        String userInfo = userFeignClient.getUserInfo();
        log.info("{}",userInfo);
    }
}
