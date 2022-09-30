package com.ssafy.spring.comb.repository;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.dto.CombPostResponse;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.recommend.dto.RecommendRequest;
import com.ssafy.spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CombPostRepository extends JpaRepository<CombinationPost, String> {

    CombinationPost save(CombinationPost combPost);

    CombinationPost findByCombinationPostId(int postId);

    @Query("select p from CombinationPost p where substring(p.combination.combinationId,1,1) = :menuId")
    List<CombinationPost> findAllByMenuId(String menuId);

    CombinationPost findByCombination_CombinationId(String combinationId);

    CombinationPost findTopByOrderByLikesCntDescScoreAvgDesc();

    List<CombinationPost> findAllByOrderByScoreAvgDesc();

    List<CombinationPost> findAllByOrderByCreatedAtDesc();

    List<CombinationPost> findAllByUser(User user);

    List<CombinationPost> findTop30ByOrderByLikesCntDescScoreAvgDesc();

    @Query("select p from CombinationPost p where p.combination.kcal between :kcalMin and :kcalMax " +
            "and p.combination.protein between :proteinMin and :proteinMax " +
            "and p.combination.sodium between :sodiumMin and :sodiumMax")
    List<CombinationPost> findAllByNutrition(float kcalMin, float kcalMax, float proteinMin, float proteinMax,
                                             float sodiumMin, float sodiumMax);
}
