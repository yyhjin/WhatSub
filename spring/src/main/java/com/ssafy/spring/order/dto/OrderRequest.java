package com.ssafy.spring.order.dto;

import lombok.Getter;

import java.util.List;

public class OrderRequest {

    @Getter
    public static class CombinationDto {
        private String combinationId;
        private float kcal;
        private float protein;
        private float sodium;
        private float fat;
        private float sugar;
        private int price;
        private int count;
    }

    @Getter
    public static class OrderDto {
        private int userId;
        private int branchId;
        private int orderPrice;
        private List<CombinationDto> combinationList;
    }
}
