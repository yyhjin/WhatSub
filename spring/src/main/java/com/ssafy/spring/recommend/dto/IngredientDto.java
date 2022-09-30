package com.ssafy.spring.recommend.dto;

import com.ssafy.spring.review.dto.ReviewResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class IngredientDto {

    private String name;
    private String imgUrl;
    private String category;
    private int price;

}
