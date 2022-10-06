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
    private int cnt;
    private int ranking;

    public RankingData(int userId, String userName, int cnt, int ranking) {
        this.userId = userId;
        this.userName = userName;
        this.cnt = cnt;
        this.ranking = ranking;
    }
}
