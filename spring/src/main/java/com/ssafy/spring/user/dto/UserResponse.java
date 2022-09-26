package com.ssafy.spring.user.dto;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.user.entity.Dib;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class UserResponse {
    @Data
    @Builder
    public static class GetUserResponse {
        private String email;
        private String gender;
        private int birthYear;
        private String userName;
        private String profileImg;
        private String subti;
        private boolean isDiet;
    }

    @Data
    @AllArgsConstructor
    public static class GetDibNcombListResponse{
        List<Dib> dibList;
        List<Combination> combinationList;
    }
}
