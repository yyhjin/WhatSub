package com.ssafy.spring.comb.service;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.repository.CombRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CombServiceImpl implements CombService {

    private final CombRepository combRepository;

    @Autowired
    public CombServiceImpl(CombRepository combRepository){
        this.combRepository = combRepository;
    }

    public Combination save(Combination combination) {
        return combRepository.save(combination);
    }


    public Combination findByCombinationId(String combId) {
        return combRepository.findByCombinationId(combId);
    }

}
