package com.ssafy.spring.comb.service;


import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;

public interface CombPostService {
    CombinationPost save(Combination comb, CombPostRequest request);
    CombinationPost findByCombinationPostId(int postId);
}
