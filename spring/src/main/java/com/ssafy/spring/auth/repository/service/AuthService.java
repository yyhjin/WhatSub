package com.ssafy.spring.auth.repository.service;

import com.ssafy.spring.auth.dto.KakaoTokenInfo;

public interface AuthService {
    KakaoTokenInfo getAccessToken(String code);
}
