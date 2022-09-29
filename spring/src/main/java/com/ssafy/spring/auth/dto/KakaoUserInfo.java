package com.ssafy.spring.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.json.simple.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KakaoUserInfo {
    private long id;
    private String nickname;
    private String profileImage; //프로필 사진
//    private String email;
//    private String gender; //female & male

    public void setProperties(JSONObject properties){
//        System.out.println(properties);
        this.nickname = (String) properties.get("nickname");
        this.profileImage = (String) properties.get("profile_image");
    }
}
