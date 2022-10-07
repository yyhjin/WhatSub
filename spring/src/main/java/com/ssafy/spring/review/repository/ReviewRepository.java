package com.ssafy.spring.review.repository;

import com.ssafy.spring.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
    List<Review> findAllByCombinationPost_CombinationPostIdOrderByCreatedAtDesc(int combinationPostId);
}
