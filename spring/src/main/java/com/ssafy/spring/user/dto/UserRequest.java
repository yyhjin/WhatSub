package com.ssafy.spring.user.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class UserRequest {

    @Data
    public static class SetSubtiRequest {
        private int userId;
        private String subti;
    }

    @Data
    public static class SignUpRequest{
        private int userId;
        private String email;
        private String gender;
        private int birthYear;
        private String userName;
        private MultipartFile profileImg;
    }

    @Data
    public static class LoginRequest{
        private String userId;
    }

    @Data
    public static class ExcludeRequest{
        private boolean isDiet;
        private List<String> vegetables;
        private List<String> allergies;
    }
}

