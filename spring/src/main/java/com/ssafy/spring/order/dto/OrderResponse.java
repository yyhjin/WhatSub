package com.ssafy.spring.order.dto;

import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.order.entity.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderResponse {

    @Getter
    public static class MenuDto {
        private String menuId;
        private String imgUrl;
        private String menuName;
        private String ingredients;
        private String menuDesc;
        private String allergies;
        private int price;
        private float kcal;
        private float protein;
        private float sodium;
        private float fat;
        private float sugar;

        public MenuDto(Menu menu) {
            this.menuId = menu.getMenuId();
            this.imgUrl = menu.getImgUrl();
            this.menuName = menu.getMenuName();
            this.ingredients = menu.getIngredients();
            this.menuDesc = menu.getMenuDesc();
            this.allergies = menu.getAllergies();
            this.price = menu.getPrice();
            this.kcal = menu.getKcal();
            this.protein = menu.getProtein();
            this.sodium = menu.getSodium();
            this.fat = menu.getFat();
            this.sugar = menu.getSugar();
        }
    }

    @Getter
    public static class IngredientDto {
        private String ingredientId;
        private String category;
        private String name;
        private String imgUrl;
        private float kcal;
        private float protein;
        private float sodium;
        private float fat;
        private float sugar;
        private String allergies;
        private int price;

        public IngredientDto(Ingredient ingredient) {
            this.ingredientId = ingredient.getIngredientId();
            this.imgUrl = ingredient.getImgUrl();
            this.name = ingredient.getName();
            this.category = ingredient.getCategory();
            this.allergies = ingredient.getAllergies();
            this.price = ingredient.getPrice();
            this.kcal = ingredient.getKcal();
            this.protein = ingredient.getProtein();
            this.sodium = ingredient.getSodium();
            this.fat = ingredient.getFat();
            this.sugar = ingredient.getSugar();
        }
    }

    @Setter
    @Getter
    public static class orderDto {
        private int orderId;
        private int userId;
        private int branchId;
        private int orderPrice;
        private LocalDateTime orderedAt;
        private List<CombinationDto> combinationList;

        public orderDto(Orders order) {
            this.orderId = order.getOrderId();
            this.userId = order.getUser().getUserId();
            this.branchId = order.getBranch().getBranchId();
            this.orderPrice = order.getOrderPrice();
            this.orderedAt = order.getOrderedAt().toLocalDateTime();
            this.combinationList = new ArrayList<>();
        }
        public orderDto(Orders order, List<CombinationDto> combinationList) {
            this.orderId = order.getOrderId();
            this.userId = order.getUser().getUserId();
            this.branchId = order.getBranch().getBranchId();
            this.orderPrice = order.getOrderPrice();
            this.orderedAt = order.getOrderedAt().toLocalDateTime();
            this.combinationList = combinationList;
        }
//        @QueryProjection
//        public orderDto(int orderId, int userId, int branchId, int orderPrice, Timestamp orderedAt) {
//            this.orderId = orderId;
//            this.userId = userId;
//            this.branchId = branchId;
//            this.orderPrice = orderPrice;
//            this.orderedAt = orderedAt.toLocalDateTime();
//            this.combinationList = new ArrayList<>();
//        }

        @Override
        public String toString() {
            return "orderDto{" +
                    "orderId=" + orderId +
                    ", userId=" + userId +
                    ", branchId=" + branchId +
                    ", orderPrice=" + orderPrice +
                    ", orderedAt=" + orderedAt +
                    ", combinationList=" + combinationList +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class CombinationDto {
        private String combinationId;
        private MenuDto menu;
        private List<IngredientDto> ingredients = new ArrayList<>();
        private String allergies;
        private int count;

        public CombinationDto(String combinationId, String allergies, int count) {
            this.combinationId = combinationId;
            this.allergies = allergies;
            this.count = count;
        }

        @Override
        public String toString() {
            return "CombinationDto{" +
                    "combinationId='" + combinationId + '\'' +
                    ", menu=" + menu +
                    ", ingredients=" + ingredients +
                    ", allergies='" + allergies + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

}
