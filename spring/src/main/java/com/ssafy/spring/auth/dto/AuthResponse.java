package com.ssafy.spring.auth.dto;

import com.ssafy.spring.user.entity.User;
import lombok.Data;
import lombok.ToString;

public class AuthResponse {
    @Data
    @ToString
    public static class LoginResponse {
        private int userId;
        private int result; // 1이면 기존 유저, 2이면 신규 유저
        private String userName;
        private String profileImage;

        private String accessToken;

        public LoginResponse(User user, int result, String accessToken){
            this.userId = user.getUserId();
            this.result = result;
            this.userName = user.getUserName();
            this.profileImage = user.getProfileImg();
            this.accessToken = accessToken;
        }
    }
}
