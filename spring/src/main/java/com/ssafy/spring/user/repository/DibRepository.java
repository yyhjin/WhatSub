package com.ssafy.spring.user.repository;

import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DibRepository extends JpaRepository<Dib, Integer> {
    List<Dib> getDibsByUserAndStateIsTrue(User user);
}
