package com.ssafy.spring.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

public class UserRequest {

    @Data
    public static class SetSubtiRequest {
        private int userId;
        private String subti;
    }

    @Data
    public static class SignUpRequest{
//        private String authId;
        private String email;
        private String gender;
        private int birthYear;
        private String userName;
        private String profileImg;
    }

    @Data
    public static class LoginRequest{
        private String userId;
    }

    @Data
    public static class ExcludeRequest{
        private List<Integer> vegetables;
        private List<Integer> allergies;
    }
}

