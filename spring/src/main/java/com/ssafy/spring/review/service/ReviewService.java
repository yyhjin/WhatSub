package com.ssafy.spring.review.service;

import com.ssafy.spring.review.entity.Review;

import java.util.List;

public interface ReviewService {
    public void create(Review review); // 댓글 작성
    public void update(Review review, int reviewId); // 댓글 수정
    public void delete(int reviewId); // 댓글 삭제
    public List<Review> getReviewList(int combinationPostId); // 댓글목록 조회
}
