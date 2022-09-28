package com.ssafy.spring.comb.repository;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CombPostRepository extends JpaRepository<CombinationPost, String> {

    CombinationPost save(CombinationPost combPost);

    CombinationPost findByCombinationPostId(int postId);

}
