package com.ssafy.spring.comb.service;


import com.ssafy.spring.comb.dto.IngredientDto;
import com.ssafy.spring.comb.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient findByIngredientId(String ingredientId);

    // 알레르기 정보가 포함된 재료dto 리턴
    List<IngredientDto> findByAllergiesContainsIn(List<String> allergies);

    // 유저가 먹지 않는 재료들의 id에 해당하는 ingredient 리턴
    List<Ingredient> findByIngredientIdIn(List<String> excludedIngredientIdsList);
}
