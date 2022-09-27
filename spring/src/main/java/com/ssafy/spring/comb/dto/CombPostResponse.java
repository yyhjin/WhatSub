package com.ssafy.spring.comb.dto;

import com.ssafy.spring.comb.entity.Combination;
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


    private Combination combination;

    private String combName;

    private String content;

    private int likesCnt;

    private Date createdAt;

    private String statistics;

    private List<Review> reviews = new ArrayList<>();

}
