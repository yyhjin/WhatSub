package com.ssafy.spring.comb.service;


import com.ssafy.spring.comb.entity.Ingredient;

public interface IngredientService {
    Ingredient findByIngredientId(String ingredientId);
}
