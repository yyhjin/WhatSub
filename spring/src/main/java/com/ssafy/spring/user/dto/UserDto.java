package com.ssafy.spring.user.dto;

import com.ssafy.spring.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String email;
    private String userName;
    private String profileImg;
    private String subti;

    public UserDto(User user) {
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.profileImg = user.getProfileImg();
        this.subti = user.getSubti();
    }
}
