package com.ssafy.spring.review.service;

import com.ssafy.spring.review.entity.Review;
import com.ssafy.spring.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }


    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void update(Review review, int reviewId) {
        review.setReviewId(reviewId);
        review.setCreatedAt(reviewRepository.findById(reviewId)
                .orElseThrow(()-> new IllegalArgumentException("해당 댓글이 없습니다. id:"+reviewId))
                .getCreatedAt());
        reviewRepository.save(review);
    }

    @Override
    public void delete(int reviewId) {
        //이거 delete하기전에 있는지 없는지 검사하고 오류 보내주는거 꼭 이렇게 해야하는지 물어보기
        reviewRepository.findById(reviewId)
                        .orElseThrow(()-> new IllegalArgumentException("해당 댓글이 없습니다. id:"+reviewId));
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<Review> getReviewList(int combinationPostId) {
        return reviewRepository.findAllByCombinationPost_CombinationPostIdOrderByCreatedAtDesc(combinationPostId);
    }
}
