package com.ssafy.spring.comb.dto;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.review.dto.ReviewResponse;
import com.ssafy.spring.review.entity.Review;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class CombPostResponse {

    private int combinationPostId;

    private String userName;

    private Combination combination;

    private String combName;

    private String content;

    private int likesCnt;

    private Date createdAt;

    private String statistics;

    private String imgUrl;

    private float scoreAvg;

    private List<ReviewResponse.ResponseDto> reviews = new ArrayList<>();

}
