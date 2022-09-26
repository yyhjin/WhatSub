package com.ssafy.spring.review.entity.service;

import com.ssafy.spring.review.entity.entity.Review;
import com.ssafy.spring.review.entity.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    public void create(Review review); // 댓글 작성
    public void update(Review review, int id); // 댓글 수정
    public void delete(int id); // 댓글 삭제

    public List<Review> getReviewList(int id); // 인자로 CombinationPost인지 int인지 모르겠음
}
