package com.ssafy.spring.comb.repository;

import com.ssafy.spring.comb.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    Ingredient findByIngredientId(String ingredientId);

}
