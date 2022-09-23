package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public void save(User user);

    public User getUserByUserId(int userId);

    public User getUserByUserName(String userName);

    public Boolean existsByUserName(String userName);

    public List<Dib> getDibsByUserAndStateIsTrue(User user);
}
