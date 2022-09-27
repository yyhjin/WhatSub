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
    private UserRepository userRepository;

    @Autowired
    private DibRepository dibRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean existsByAuthId(String authId) {
        return userRepository.existsByAuthId(authId);
    }

    @Override
    public User getUserByUserId(int userId) {
        return userRepository.getUserByUserId(userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }

    @Override
    public User getUserByAuthId(String authId) {
        return userRepository.getUserByAuthId(authId);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public List<Dib> getDibsByUserAndStateIsTrue(User user) {
        return dibRepository.getDibsByUserAndStateIsTrue(user);
    }
}
