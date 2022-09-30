package com.ssafy.spring.comb.dto;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.user.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class CombPostDto {
    private int combinationPostId;
    private Combination combination;
    private UserDto user;
    private String combName;
    private String content;
    private String imgUrl;
    private float scoreAvg;
    private int likesCnt;
    private Timestamp createdAt;
    private String statistics;

    public CombPostDto (CombinationPost combinationPost){
        this.combinationPostId = combinationPost.getCombinationPostId();
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
