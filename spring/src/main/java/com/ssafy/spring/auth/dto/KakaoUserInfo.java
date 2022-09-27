package com.ssafy.spring.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoUserInfo {
    private long id;
    private String nickname;
    private String picture; //프로필 사진
    private String email;
    private String gender; //female & male
}
