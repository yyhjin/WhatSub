package com.ssafy.spring.comb.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

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

    @Data
    public static class ingredientResponse {
        private String category;
        private String name;
    }
}
