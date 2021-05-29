package com.sso.oauth.controller;


import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.common.exception.GlobalExecption;
import com.sso.oauth.service.UserLoginService;
import com.sso.oauth.util.AuthToken;
import com.sso.oauth.util.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private TokenStore tokenStore;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Result login(String username, String password, HttpServletResponse response){
        //校验参数
        if (StringUtils.isEmpty(username)){
            throw new GlobalExecption("请输入用户名");
        }
        if (StringUtils.isEmpty(password)){
            throw new GlobalExecption("请输入密码");
        }
        AuthToken authToken = null;
        try {
            authToken = userLoginService.login(username, password, clientId, clientSecret);
        } catch (Exception e) {
            throw new GlobalExecption("登录信息有问题");
        }
        this.saveJtiToCookie(String.valueOf(3600),response);

        return new Result(true, StatusCode.OK,"登录成功",authToken.getJti());
    }

    private void saveJtiToCookie(String jti, HttpServletResponse response) {
        CookieUtil.addCookie(response,cookieDomain,"/","uid",jti,cookieMaxAge,false);
    }

    /**
     * 刷新 token
     * @param access_token
     * @param request
     * @param response
     */
    @PostMapping(value = "/oauth/refresh/token", params = "access_token")
    public void refreshTokenInfo(String access_token, HttpServletRequest request, HttpServletResponse response) {
         if (StringUtils.isBlank(access_token)){
             throw new GlobalExecption("access_token不能为空");
         }

        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(access_token);

    }
}
