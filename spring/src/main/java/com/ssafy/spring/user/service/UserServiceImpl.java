package com.ssafy.spring.user.service;

import com.ssafy.spring.comb.dto.CombPostDto;
import com.ssafy.spring.comb.dto.IngredientDto;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.repository.IngredientRepository;
import com.ssafy.spring.comb.repository.MenuRepository;
import com.ssafy.spring.user.dto.DibDto;
import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.repository.DibRepository;
import com.ssafy.spring.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DibRepository dibRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private MenuRepository menuRepository;


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean existsByAuthId(String authId) {
        return userRepository.existsByAuthId(authId);
    }

    @Override
    public User getUserByUserId(int userId) {
        return userRepository.getUserByUserId(userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }

    @Override
    public User getUserByAuthId(String authId) {
        return userRepository.getUserByAuthId(authId);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public List<Dib> getDibsByUserAndStateIsTrue(User user) {
        return dibRepository.getDibsByUserAndStateIsTrue(user);
    }

    @Override
    public Set<String> getExcludedIngredientId(List<String> vegetables, List<String> allergies, List<IngredientDto> ingredientDtoList) {
        Set<String> excludedIngredientIds = new HashSet<>(vegetables);

        for(IngredientDto ingredientDto : ingredientDtoList){
            List<String> ingredientAllergies = Arrays.asList(ingredientDto.getAllergies().split(","));

            for(String allergy : allergies){
                if(ingredientAllergies.contains(allergy)) {
                    excludedIngredientIds.add(ingredientDto.getIngredientId());
                    break;
                }
            }
        }

        return excludedIngredientIds;
    }

    @Override
    public List<com.ssafy.spring.recommend.dto.IngredientDto> getIngredientList(String combinationId) {
        List<com.ssafy.spring.recommend.dto.IngredientDto> ingredients = new ArrayList<>();

        String list = combinationId.substring(1);
        for (int i = 0, j = 0; j < list.length()/2; i += 2, j++) {
            com.ssafy.spring.recommend.dto.IngredientDto ingredient = new com.ssafy.spring.recommend.dto.IngredientDto();
            String ingredientId = list.substring(i, i+2);
            Ingredient in = ingredientRepository.findByIngredientId(ingredientId);
            ingredient.setCategory(in.getCategory());
            ingredient.setName(in.getName());
            ingredient.setImgUrl(in.getImgUrl());
            ingredients.add(ingredient);
        }

        return ingredients;
    }

    @Override
    public List<DibDto> addMenuNameAndIngredientsToDib(List<DibDto> dibList) {
        for(DibDto dib : dibList){
            CombPostDto combPostDto = dib.getCombinationPostDto();
            Combination combination = combPostDto.getCombination();

            String menuId = combination.getCombinationId().substring(0,1);
            Menu menu = menuRepository.findByMenuId(menuId);
            combPostDto.setMenuName(menu.getMenuName());
            combPostDto.setIngredients(this.getIngredientList(combination.getCombinationId()));
        }

        return dibList;
    }

    @Override
    public List<CombPostDto> addMenuNameAndIngredientsToCombPost(List<CombPostDto> combPostList) {
        for(CombPostDto combPost : combPostList){
            Combination comb = combPost.getCombination();

            String menuId = comb.getCombinationId().substring(0,1);
            Menu menu = menuRepository.findByMenuId(menuId);
            combPost.setMenuName(menu.getMenuName());
            combPost.setIngredients(this.getIngredientList(comb.getCombinationId()));
        }

        return combPostList;
    }
}
