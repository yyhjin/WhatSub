package com.ssafy.spring.comb.dto;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.user.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CombPostDto {
    private int combinationPostId;
    private Combination combination;
    private UserDto user;
    private String menuName;
    private String combName;
    private String content;
    private String imgUrl;
    private float scoreAvg;
    private int likesCnt;
    private Timestamp createdAt;
    private String statistics;
    private List<IngredientDto.ingredientResponse> ingredients = new ArrayList<>();

    public CombPostDto (CombinationPost combinationPost){
        this.combinationPostId = combinationPost.getCombinationPostId();
        this.combination = combinationPost.getCombination();
        this.user = new UserDto(combinationPost.getUser());
        this.combName = combinationPost.getCombName();
        this.content = combinationPost.getContent();
        this.imgUrl = combinationPost.getImgUrl();
        this.scoreAvg = combinationPost.getScoreAvg();
        this.likesCnt = combinationPost.getLikesCnt();
        this.createdAt = combinationPost.getCreatedAt();
        this.statistics = combinationPost.getStatistics();
    }
}
