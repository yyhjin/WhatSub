package com.ssafy.spring.review.dto;

import lombok.Data;

public class ReviewRequest {
    @Data
    public static class CreateRequest {
        private String content;
        private int score;
        private int combinationPostId;
        private int userId;
    }
    @Data
    public static class UpdateRequest {
        private String content;
        private int score;
    }
}
