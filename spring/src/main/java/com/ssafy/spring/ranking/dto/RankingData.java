package com.ssafy.spring.ranking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class RankingData {
    private int userId;
    private String userName;
    private String profileImg;
    private int cnt;
    private int ranking;

    public RankingData(int userId, String userName, String profileImg, int cnt, int ranking) {
        this.userId = userId;
        this.userName = userName;
        this.profileImg = profileImg;
        this.cnt = cnt;
        this.ranking = ranking;
    }
}
