package com.sso.oauth.feign;


import com.sso.oauth.hystrix.UserFeignHystrix;
import com.sso.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author panqw
 * @date 2020/6/19 10:58
 */
@FeignClient(name = "user",fallback = UserFeignHystrix.class)
public interface UserFeignController {

    @PostMapping("/user/findUserInfo")
    public User findUserInfo(@RequestParam("username") String username);
}
