package com.ssafy.spring.recommend.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RecommendRequest {

    private float kcalMin;
    private float kcalMax;
    private float proteinMin;
    private float proteinMax;
    private float sodiumMin;
    private float sodiumMax;

}
