package com.ssafy.spring.comb.service;

import com.ssafy.spring.comb.dto.IngredientDto;
import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.repository.IngredientRepository;
import com.ssafy.spring.comb.repository.IngredientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    private IngredientRepositoryImpl ingredientRepositoryImpl;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient findByIngredientId(String ingredientId) {
        return ingredientRepository.findByIngredientId(ingredientId);
    }

    @Override
    public List<IngredientDto> findByAllergiesContainsIn(List<String> allergies) {
        return ingredientRepositoryImpl.findByAllergiesContainsIn(allergies);
    }

    @Override
    public List<Ingredient> findByIngredientIdIn(List<String> excludedIngredientIdsList) {
        return ingredientRepository.findByIngredientIdIn(excludedIngredientIdsList);
    }

}
