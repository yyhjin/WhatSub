package com.ssafy.spring.comb.service;


import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.entity.Combination;

public interface CombService {
    Combination save(Combination combination);

    Combination findByCombinationId(String combinationId);
}
