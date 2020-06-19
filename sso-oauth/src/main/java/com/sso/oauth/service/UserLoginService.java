package com.sso.oauth.service;

import com.sso.oauth.util.AuthToken;

/**
 * @author panqw
 * @date 2020/6/19 9:53
 */
public interface UserLoginService {

    AuthToken login(String username, String password, String clientId, String clientSecret);
}
