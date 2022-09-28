package com.ssafy.spring.comb.repository;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.dto.CombPostResponse;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
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

}
