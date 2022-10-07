package com.ssafy.spring.recommend.service;


import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.recommend.dto.RecommendRequest;

import java.util.List;

public interface RecommendService {

    List<CombinationPost> findTop30ByOrderByLikesCntDescScoreAvgDesc();

    List<CombinationPost> findAllByNutrition(RecommendRequest request);
}
