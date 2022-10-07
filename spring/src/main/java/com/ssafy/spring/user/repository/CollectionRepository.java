package com.ssafy.spring.user.repository;

import com.ssafy.spring.user.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CollectionRepository extends JpaRepository<Collection, Integer> {
    Collection save(Collection collection);
}
