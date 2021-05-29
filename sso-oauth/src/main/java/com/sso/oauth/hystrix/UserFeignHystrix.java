package com.sso.oauth.hystrix;

import com.sso.oauth.feign.UserFeignController;
import com.sso.user.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserFeignHystrix implements UserFeignController {

    @Override
    public User findUserInfo(@RequestParam("username")String username) {
        return new User();
    }
}
