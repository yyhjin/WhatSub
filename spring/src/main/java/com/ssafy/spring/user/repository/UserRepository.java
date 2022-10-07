package com.ssafy.spring.user.repository;

import com.ssafy.spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);

    User getUserByUserId(int userId);

    User getUserByUserName(String userName);

    User getUserByAuthId(String authId);

    Boolean existsByUserName(String userName);

    Boolean existsByAuthId(String authId);

    public interface UserRepositoryCustom{

    }
}
