package com.ssafy.spring.review.entity.repository;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.review.entity.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review, Integer>, ReviewRepository{
    @Override
    public List<Review> findByCombinationPost(CombinationPost combId);
}
