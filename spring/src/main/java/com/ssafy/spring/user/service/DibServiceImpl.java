package com.ssafy.spring.user.service;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.repository.DibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DibServiceImpl implements DibService {

    private final DibRepository dibRepository;

    public DibServiceImpl(DibRepository dibRepository) {
        this.dibRepository = dibRepository;
    }

    @Override
    public Dib findByCombinationPost_CombinationPostIdAndUser_UserId(int postId, int userId) {
//        return dibRepository.findByCombinationPostIdAndAndUser_UserId(postId, userId);
        return dibRepository.findByCombinationPost_CombinationPostIdAndUser_UserId(postId, userId);
    }

    @Override
    public void save(Dib dib) { dibRepository.save(dib); }

    @Transactional
    public int stateUpdate(Dib dib, boolean state) {
        dib.stateUpdate(state);
        return dib.getDibId();
    }

}
