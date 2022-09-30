package com.ssafy.spring.comb.service;

import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient findByIngredientId(String ingredientId) {
        return ingredientRepository.findByIngredientId(ingredientId);
    }

}
