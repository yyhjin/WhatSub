package com.ssafy.spring.comb.service;


import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.user.entity.User;

public interface CombPostService {
    CombinationPost save(Combination comb, User user, String imgurl, CombPostRequest request);
    CombinationPost findByCombinationPostId(int postId);
}
