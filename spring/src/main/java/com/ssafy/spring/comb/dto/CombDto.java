package com.ssafy.spring.comb.dto;

import com.ssafy.spring.comb.entity.Combination;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CombDto {

    private String combinationId;
    private float kcal;
    private float protein;
    private float sodium;
    private float fat;
    private float sugar;
    private int price;

    public CombDto(Combination combination) {
        this.combinationId = combination.getCombinationId();
        this.kcal = combination.getKcal();
        this.protein  = combination.getProtein();
        this.sodium = combination.getSodium();
        this.fat = combination.getFat();
        this.sugar = combination.getSugar();
        this.price = combination.getPrice();
    }
}
