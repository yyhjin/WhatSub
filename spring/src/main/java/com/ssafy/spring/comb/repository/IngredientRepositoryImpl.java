package com.ssafy.spring.comb.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.spring.comb.dto.IngredientDto;
import com.ssafy.spring.comb.dto.QIngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ssafy.spring.comb.entity.QIngredient.ingredient;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository.IngredientRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<IngredientDto> findByAllergiesContainsIn(List<String> allergiesList) {
//        QIngredient ingrd = new QIngredient("ingrd");

        return queryFactory.select(new QIngredientDto(ingredient.ingredientId, ingredient.allergies))
                .from(ingredient)
                .where(ingredient.allergies.isNotEmpty())
                .fetch();
    }
}
