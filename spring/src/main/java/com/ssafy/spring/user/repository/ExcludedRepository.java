package com.ssafy.spring.user.repository;

import com.ssafy.spring.user.entity.Excluded;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ExcludedRepository extends JpaRepository<Excluded, Integer> {
    Excluded save(Excluded excluded);

}
