package com.ssafy.spring.review.repository;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.review.entity.Review;

import javax.persistence.EntityManager;
import java.util.List;


public class ReviewRepositoryImpl implements ReviewRepository {

    private final EntityManager em;

    public  ReviewRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Review> findByCombinationPost(CombinationPost combinationPost) {
        return em.createQuery("select r from Review r where r.combinationPost=:combinationPost")
                .setParameter("combinationPost", combinationPost)
                .getResultList();
    }

}
