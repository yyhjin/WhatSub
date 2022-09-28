package com.ssafy.spring.auth.dto;

import lombok.Data;

public class AuthRequest {
    @Data
    public class UserCheckRequest{
        private String code;
    }

}
