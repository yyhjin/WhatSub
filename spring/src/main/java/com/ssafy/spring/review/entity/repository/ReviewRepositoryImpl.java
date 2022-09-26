package com.ssafy.spring.review.entity.repository;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.review.entity.entity.Review;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

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
