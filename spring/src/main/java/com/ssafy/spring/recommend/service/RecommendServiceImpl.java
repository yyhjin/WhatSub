package com.ssafy.spring.recommend.service;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.repository.CombPostRepository;
import com.ssafy.spring.recommend.dto.RecommendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecommendServiceImpl implements RecommendService {

    private final CombPostRepository combPostRepository;

    @Autowired
    public RecommendServiceImpl(CombPostRepository combPostRepository){
        this.combPostRepository = combPostRepository;
    }

    @Override
    public List<CombinationPost> findTop30ByOrderByLikesCntDescScoreAvgDesc() {
        return combPostRepository.findTop30ByOrderByLikesCntDescScoreAvgDesc();
    }

    @Override
    public List<CombinationPost> findAllByNutrition(RecommendRequest request) {
        return combPostRepository.findAllByNutrition(request.getKcalMin(), request.getKcalMax(),
                request.getProteinMin(), request.getProteinMax(), request.getSodiumMin(), request.getSodiumMax());
    }


}
