package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Collection;
import com.ssafy.spring.user.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public Collection save(Collection collection) {
        return collectionRepository.save(collection);
    }
}
