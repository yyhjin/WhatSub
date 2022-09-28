package com.ssafy.spring.auth.service;

import com.ssafy.spring.auth.dto.KakaoTokenInfo;
import com.ssafy.spring.auth.dto.KakaoUserInfo;

public interface AuthService {
    KakaoTokenInfo getTokenByCode(String code);

    KakaoUserInfo getUserByAccessToken(String accessToken);
}
