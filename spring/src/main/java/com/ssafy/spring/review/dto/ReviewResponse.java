package com.ssafy.spring.review.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponse {
    private String combinationId;
    private int userId;
    private int score;
    private String content;
}