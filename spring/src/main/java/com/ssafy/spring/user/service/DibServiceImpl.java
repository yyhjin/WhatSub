package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.repository.DibRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DibServiceImpl implements DibService {

    private final DibRepository dibRepository;

    public DibServiceImpl(DibRepository dibRepository) {
        this.dibRepository = dibRepository;
    }

    @Override
    public Dib findByCombinationPost_CombinationPostIdAndUser_UserId(int postId, int userId) {
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
