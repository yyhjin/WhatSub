package com.ssafy.spring.user.repository;

import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);

    User getUserByUserId(int userId);

    User getUserByUserName(String userName);

    Boolean existsByUserName(String userName);

    public interface UserRepositoryCustom{

    }
}
