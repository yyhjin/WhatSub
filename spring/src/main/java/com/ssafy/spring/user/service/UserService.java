package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void save(User user);

    User getUserByUserId(int userId);

    User getUserByUserName(String userName);

    Boolean existsByUserName(String userName);

    List<Dib> getDibsByUserAndStateIsTrue(User user);
}
