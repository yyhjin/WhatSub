package com.ssafy.spring.comb.repository;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

    Menu findByMenuId(String menuId);
}
