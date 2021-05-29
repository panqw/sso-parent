package com.sso.oauth.feign;

import com.sso.oauth.hystrix.UserFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author panqw
 * @date 2020/6/19 10:58
 */
@FeignClient(name = "ribbon")
public interface UserFeignClient {

    @PostMapping("/user/getUserInfo")
    public String getUserInfo();
}
