package com.ssafy.spring.comb.service;


import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.user.entity.User;

import java.util.List;

public interface CombPostService {
    CombinationPost save(Combination comb, User user, String imgurl, CombPostRequest request);
    CombinationPost findByCombinationPostId(int postId);
    int scoreUpdate(int postId, float scoreAvg);
    List<CombinationPost> findAllByMenuId (String menuId);
    CombinationPost findByCombination_CombinationId(String combinationId);
    CombinationPost findTopByOrderByLikesCntDescScoreAvgDesc();
    List<CombinationPost> findAllByOrderByScoreAvgDesc();
    List<CombinationPost> findAllByOrderByCreatedAtDesc();
    int likescntUpdate(CombinationPost post, int likesCnt);
    void statisticsUpdate(CombinationPost post, String statistics);

}
