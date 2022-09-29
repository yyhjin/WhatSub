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

    public Combination save(CombDto dto) {
        Combination comb = new Combination();
        comb.setCombinationId(dto.getCombinationId());
        comb.setKcal(dto.getKcal());
        comb.setProtein(dto.getProtein());
        comb.setSodium(dto.getSodium());
        comb.setFat(dto.getFat());
        comb.setSugar(dto.getSugar());
        comb.setPrice(dto.getPrice());


//        comb.setAllergies(dto.getAllergies());
//
//        comb.setSoft(dto.getSoft());
//        comb.setSalty(dto.getSalty());
//        comb.setChewy(dto.getChewy());
//        comb.setSour(dto.getSour());
//        comb.setSweet(dto.getSweet());
//        comb.setNutty(dto.getNutty());
//        comb.setSpicy(dto.getSpicy());
//        comb.setBland(dto.getBland());
        return combRepository.save(comb);
    }


    public Combination findByCombinationId(String combId) {
        return combRepository.findByCombinationId(combId);
    }

}
