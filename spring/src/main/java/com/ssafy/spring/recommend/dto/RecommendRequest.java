package com.ssafy.spring.recommend.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RecommendRequest {

    private String combinationId;
    private int userId;
    private String combName;
    private String content;

}
