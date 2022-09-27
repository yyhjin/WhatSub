package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    Boolean existsByAuthId(String authId);

    User getUserByUserId(int userId);

    User getUserByUserName(String userName);

    User getUserByAuthId(String authId);

    Boolean existsByUserName(String userName);

    List<Dib> getDibsByUserAndStateIsTrue(User user);
}
