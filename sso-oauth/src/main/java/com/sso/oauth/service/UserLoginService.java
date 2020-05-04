package com.sso.oauth.service;

import com.sso.oauth.util.AuthToken;

public interface UserLoginService {
    AuthToken login(String username, String password, String clientId, String clientSecret);
}
