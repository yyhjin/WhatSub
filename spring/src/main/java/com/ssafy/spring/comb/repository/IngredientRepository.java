package com.ssafy.spring.comb.repository;

import com.ssafy.spring.comb.dto.IngredientDto;
import com.ssafy.spring.comb.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    Ingredient findByIngredientId(String ingredientId);

    List<Ingredient> findByIngredientIdIn(List<String> ingredientIdList);

    public interface IngredientRepositoryCustom{
        List<IngredientDto> findByAllergiesContainsIn(List<String> allergiesList);
    }
}
