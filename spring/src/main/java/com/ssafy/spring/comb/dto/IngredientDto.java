package com.ssafy.spring.comb.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class IngredientDto {
    private String ingredientId;
    private String allergies;

    @QueryProjection
    public IngredientDto(String ingredientId, String allergies){
        this.ingredientId = ingredientId;
        this.allergies = allergies;
    }

}
