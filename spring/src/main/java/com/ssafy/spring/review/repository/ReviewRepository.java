package com.ssafy.spring.review.repository;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.review.entity.Review;

import java.util.List;

public interface ReviewRepository {
    public List<Review> findByCombinationPost(CombinationPost combId); // combId에 해당하는 리뷰목록 반환
}
