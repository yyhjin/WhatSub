package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Excluded;
import com.ssafy.spring.user.repository.ExcludedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcludedServiceImpl implements ExcludedService {

    @Autowired
    private ExcludedRepository excludedRepository;

    @Override
    public Excluded save(Excluded excluded) {
        return excludedRepository.save(excluded);
    }

    @Override
    public List<Excluded> saveAll(List<Excluded> excludedList) {
        return excludedRepository.saveAll(excludedList);
    }
}
