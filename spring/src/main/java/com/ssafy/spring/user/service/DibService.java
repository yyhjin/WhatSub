package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;

import java.util.List;

public interface DibService {

    Dib findByCombinationPostIdAndAndUser_UserId(int postId, int userId);

    void save(Dib dib);

    int stateUpdate(Dib dib, boolean state);
}
