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
public class CombPostRequest {

    private String combinationId;
    private String combName;
    private String content;

}
