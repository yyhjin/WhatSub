package com.ssafy.spring.ranking.service;

import com.ssafy.spring.ranking.dto.RankingDto;

import java.util.List;

public interface RankingService {
    List<RankingDto> getMonthlyRanking();

}
