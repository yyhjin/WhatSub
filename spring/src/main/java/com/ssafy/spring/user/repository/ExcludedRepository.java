package com.ssafy.spring.user.repository;

import com.ssafy.spring.user.entity.Excluded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ExcludedRepository extends JpaRepository<Excluded, Integer> {
    Excluded save(Excluded excluded);

//    List<Excluded> saveAll(List<Excluded> excludedList);
}
