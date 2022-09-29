package com.ssafy.spring.comb.dto;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.review.dto.ReviewResponse;
import com.ssafy.spring.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
public class CombPostResponse {
    @Data
    public static class PostDetailResponse {
        private int combinationPostId;
        private String userName;
        private Combination combination;
        private String combName;
        private String content;
        private int likesCnt;
        private Timestamp createdAt;
        private String statistics;
        private String imgUrl;
        private float scoreAvg;
        private List<ReviewResponse.ResponseDto> reviews = new ArrayList<>();

    }
    @Data
    public static class PostResponse {
        private int combinationPostId;
        private Combination combination;
        private String combName;
        private int likesCnt;
        private Timestamp createdAt;
        private String imgUrl;
        private float scoreAvg;

    }
}
