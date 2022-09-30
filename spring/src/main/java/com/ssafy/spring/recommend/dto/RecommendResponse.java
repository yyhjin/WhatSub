package com.ssafy.spring.recommend.dto;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.review.dto.ReviewResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class RecommendResponse {

    // 꿀조합 게시판 정보
    private String combinationId;
    private int combinationPostId;
    private String combName;
    private String content;
    private int likesCnt;
    private float scoreAvg;

    // 조합 정보
    private float kcal;
    private float protein;
    private float sodium;
    private float fat;
    private float sugar;
    private String allergies;
    private int price;

    // 메뉴 정보
    private String menuName;
    private String imgUrl;
    private String ingredients;
    private String menuDesc;

    // 재료 정보
    private List<IngredientDto> ingredient = new ArrayList<>();
}
