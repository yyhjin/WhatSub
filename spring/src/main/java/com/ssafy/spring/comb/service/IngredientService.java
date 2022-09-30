package com.ssafy.spring.comb.service;


import com.ssafy.spring.comb.dto.IngredientDto;
import com.ssafy.spring.comb.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient findByIngredientId(String ingredientId);

    List<IngredientDto> findByAllergiesContainsIn(List<String> allergies);

    List<Ingredient> findByIngredientIdIn(List<String> excludedIngredientIdsList);
}
