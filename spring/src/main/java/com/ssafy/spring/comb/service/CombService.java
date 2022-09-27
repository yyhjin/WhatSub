package com.ssafy.spring.comb.service;


import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.entity.Combination;

public interface CombService {
    Combination save(CombDto dto);

    Combination findByCombinationId(String combinationId);
}
