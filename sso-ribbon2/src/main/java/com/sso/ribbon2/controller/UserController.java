package com.sso.ribbon2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/getUserInfo")
    public String getUserInfo(){
        return "ribbon2";
    }

}
