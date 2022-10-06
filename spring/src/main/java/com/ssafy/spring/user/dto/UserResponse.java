package com.ssafy.spring.user.dto;

import com.ssafy.spring.comb.dto.CombPostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class UserResponse {
    @Data
    @Builder
    public static class GetUserResponse {
        private int userId;
        private String email;
        private String gender;
        private int birthYear;
        private String userName;
        private String profileImg;
        private String subti;
        private boolean isDiet;
        private List<CollectionDto> collectionList;
    }

    @Data
    @AllArgsConstructor
    public static class GetDibNcombListResponse {
        List<CollectionDto> collections;
        List<DibDto> dibs;
        List<CombPostDto> combinations;
    }

    @Data
    @Builder
    public static class UserInfoResponse{
        private String img;
        private String userName;
        private String subti;
        private List<CollectionDto> collections;
        private List<CombPostDto> combs;
        private List<DibDto> dibs;
    }
}
