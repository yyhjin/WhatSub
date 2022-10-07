package com.ssafy.spring.comb.repository;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CombRepository extends JpaRepository<Combination, String> {

    Combination save(Combination comb);

    Combination findByCombinationId(String combId);
}
