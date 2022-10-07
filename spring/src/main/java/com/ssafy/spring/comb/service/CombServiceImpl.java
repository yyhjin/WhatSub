package com.ssafy.spring.comb.service;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.repository.CombRepository;
import com.ssafy.spring.comb.repository.IngredientRepository;
import com.ssafy.spring.comb.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class CombServiceImpl implements CombService {

    private final CombRepository combRepository;
    private final MenuRepository menuRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public CombServiceImpl(CombRepository combRepository, MenuRepository menuRepository, IngredientRepository ingredientRepository){
        this.combRepository = combRepository;
        this.menuRepository = menuRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Combination save(CombDto combination) {
        Combination newcomb = new Combination();
        newcomb.setCombinationId(combination.getCombinationId());
        newcomb.setKcal(combination.getKcal());
        newcomb.setProtein(combination.getProtein());
        newcomb.setSodium(combination.getSodium());
        newcomb.setFat(combination.getFat());
        newcomb.setSugar(combination.getSugar());
        newcomb.setPrice(combination.getPrice());

        // 재료 하나하나 반영해서 더할 변수
        Set<String> set = new HashSet<>();
        String allergies = "";
        int soft = 0;
        int salty = 0;
        int chewy = 0;
        int sour = 0;
        int sweet = 0;
        int nutty = 0;
        int spicy = 0;
        int bland = 0;

        // 조합 식별자 구분하여 저장
        String menuId = combination.getCombinationId().substring(0,1);
        String list = combination.getCombinationId().substring(1);
        String[] ingredients = new String[list.length()/2];
        for (int i = 0, j = 0; j < list.length()/2; i += 2, j++) {
            ingredients[j] = list.substring(i, i+2);
        }

        // 메뉴 영양정보, 알러지 더하기
        Menu menu = menuRepository.findByMenuId(menuId);

        String[] menu_aller = menu.getAllergies().split(",");
        for (int i = 0; i < menu_aller.length; i++) {
            set.add(menu_aller[i]);
        }

        soft += menu.getSoft();
        salty += menu.getSalty();
        chewy += menu.getChewy();
        sour += menu.getSour();
        sweet += menu.getSweet();
        nutty += menu.getNutty();
        spicy += menu.getSpicy();
        bland += menu.getBland();

        // 재료 영양정보, 알러지 더하기
        for (int i = 0; i < ingredients.length; i++) {
            Ingredient ingredient = ingredientRepository.findByIngredientId(ingredients[i]);

            String[] ingre_aller = menu.getAllergies().split(",");
            for (int j = 0; j < ingre_aller.length; j++) {
                set.add(ingre_aller[j]);
            }

            soft += menu.getSoft();
            salty += menu.getSalty();
            chewy += menu.getChewy();
            sour += menu.getSour();
            sweet += menu.getSweet();
            nutty += menu.getNutty();
            spicy += menu.getSpicy();
            bland += menu.getBland();
        }

        // set에 있는 알러지 정보들 string으로 묶기
        allergies = String.join(",", set);

        newcomb.setAllergies(allergies);
        newcomb.setSoft(soft);
        newcomb.setSalty(salty);
        newcomb.setChewy(chewy);
        newcomb.setSour(sour);
        newcomb.setSweet(sweet);
        newcomb.setNutty(nutty);
        newcomb.setSpicy(spicy);
        newcomb.setBland(bland);

        return combRepository.save(newcomb);
    }


    public Combination findByCombinationId(String combId) {
        return combRepository.findByCombinationId(combId);
    }

}
