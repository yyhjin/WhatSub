package com.ssafy.spring.review.service;

import com.ssafy.spring.review.entity.Review;
import com.ssafy.spring.review.repository.ReviewJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewJpaRepository reviewJpaRepository;
    @Autowired
    public ReviewServiceImpl(ReviewJpaRepository reviewJpaRepository){
        this.reviewJpaRepository = reviewJpaRepository;
    }


    @Override
    public void create(Review review) {
        reviewJpaRepository.save(review);
    }

    @Override
    public void update(Review review, int id) {
        review.setReviewId(id);
        review.setCreatedAt(reviewJpaRepository.findById(id).get().getCreatedAt());
        reviewJpaRepository.save(review);
    }

    @Override
    public void delete(int id) {
        reviewJpaRepository.deleteById(id);
    }

    @Override
    public List<Review> getReviewList(int id) {
        // 게시글id로 게시글을 찾고
        // CombinationPost combinationPost = combinationPostRepository.findById(id);
        // 해당 게시글을 이용해서 리뷰 목록 가져오기
//         return reviewJpaRepository.findByCombinationPost(combinationPost);
//        reviewJpaRepository.findByCombinationPost_CombinationPostId(int id);
        return null;
    }
}
