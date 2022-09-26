package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.repository.DibRepository;
import com.ssafy.spring.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private DibRepository DibRepository;

    @Override
    public void save(User user) {
        UserRepository.save(user);
    }

    @Override
    public User getUserByUserId(int userId) {
        return UserRepository.getUserByUserId(userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        return UserRepository.getUserByUserName(userName);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return UserRepository.existsByUserName(userName);
    }

    @Override
    public List<Dib> getDibsByUserAndStateIsTrue(User user) {
        return DibRepository.getDibsByUserAndStateIsTrue(user);
    }
}
