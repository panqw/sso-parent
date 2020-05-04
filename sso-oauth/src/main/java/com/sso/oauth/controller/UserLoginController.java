package com.sso.oauth.controller;


import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.oauth.service.UserLoginService;
import com.sso.oauth.util.AuthToken;
import com.sso.oauth.util.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Value("${auth.clientId}")
    private String clientId;
    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/login")
    public Result login(String username, String password, HttpServletResponse response){
        //校验参数
        if (StringUtils.isEmpty(username)){
            throw new RuntimeException("请输入用户名");
        }
        if (StringUtils.isEmpty(password)){
            throw new RuntimeException("请输入密码");
        }
        AuthToken authToken = null;
        try {
            authToken = userLoginService.login(username, password, clientId, clientSecret);
        } catch (Exception e) {
            throw new RuntimeException("dd");
        }
        this.saveJtiToCookie(String.valueOf(3600),response);

        return new Result(true, StatusCode.OK,"登录成功",authToken.getJti());
    }

    private void saveJtiToCookie(String jti, HttpServletResponse response) {
        CookieUtil.addCookie(response,cookieDomain,"/","uid",jti,cookieMaxAge,false);
    }
}
