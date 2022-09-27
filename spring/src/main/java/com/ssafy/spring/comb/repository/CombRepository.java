package com.ssafy.spring.comb.repository;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CombRepository extends JpaRepository<Combination, String> {

    Combination save(Combination comb);

    Combination findByCombinationId(String combId);
}
