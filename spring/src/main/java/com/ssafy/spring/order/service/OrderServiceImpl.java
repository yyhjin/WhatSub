package com.ssafy.spring.order.service;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.repository.CombRepository;
import com.ssafy.spring.comb.repository.IngredientRepository;
import com.ssafy.spring.comb.repository.MenuRepository;
import com.ssafy.spring.order.dto.BranchDto;
import com.ssafy.spring.order.dto.OrderRequest;
import com.ssafy.spring.order.dto.OrderResponse;
import com.ssafy.spring.order.entity.Branch;
import com.ssafy.spring.order.entity.OrderHistory;
import com.ssafy.spring.order.entity.Orders;
import com.ssafy.spring.order.repository.BranchRepository;
import com.ssafy.spring.order.repository.OrderHistoryRepository;
import com.ssafy.spring.order.repository.OrderRepository;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private CombRepository combRepository;

    @Override
    public BranchDto getStoreInfo(int storeId) {
        return new BranchDto(branchRepository.findById(storeId).orElseThrow());
    }

    @Override
    public List<BranchDto> getStores(float minlat, float maxlat, float minlng, float maxlng) {
        return branchRepository.findByLatAndLng(minlat, maxlat, minlng, maxlng);
    }

    @Override
    public List<OrderResponse.MenuDto> getMenuList() {
        return menuRepository.findAll().stream().map(OrderResponse.MenuDto::new).collect(Collectors.toList());
    }

    @Override
    public List<OrderResponse.IngredientDto> getIngredientList() {
        return ingredientRepository.findAll().stream().map(OrderResponse.IngredientDto::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderResponse.orderDto order(OrderRequest.OrderDto orderRequest){
        // 주문 저장
        Orders order = Orders.builder()
                .branch(branchRepository.getReferenceById(orderRequest.getBranchId()))
                .user(userRepository.getReferenceById(orderRequest.getUserId()))
                .orderPrice(orderRequest.getOrderPrice()).build();
        orderRepository.save(order);
        System.out.println(order.getOrderId());
        // 주문 내역 저장
        User user = userRepository.findById(orderRequest.getUserId())
                .orElseThrow();
        System.out.println(orderRequest.getCombinationList());
        orderRequest.getCombinationList().forEach(comb -> {
            // 1. 조합이 있는지 확인 후, 없으면 생성
            if (combRepository.findByCombinationId(comb.getCombinationId()) == null) {
                saveCombination(comb);
            }
            // 2. 주문 내역 테이블에 넣기
            orderHistoryRepository.save(OrderHistory.builder()
                            .order(order)
                            .combination(combRepository.getReferenceById(comb.getCombinationId()))
                            .count(comb.getCount())
                            .userId(user.getUserId())
                            .userName(user.getUserName())
                            .gender(user.getGender())
                            .birthYear(user.getBirthYear())
                            .subti(user.getSubti())
                            .menuId(comb.getCombinationId().substring(0, 1)).build());
        });
        return new OrderResponse.orderDto(order);
    }

    @Override
    @Transactional
    public List<OrderResponse.orderDto> getOrderHistory(String userName) {
        List<OrderResponse.orderDto> orderList = orderRepository.findOrderHistory(userRepository.getUserByUserName(userName));
        orderList.forEach(order -> {
            order.getCombinationList().forEach(comb -> {
               System.out.println(comb);
                // 조합 식별자 구분하여 저장
                String menuId = comb.getCombinationId().substring(0,1);
                String list = comb.getCombinationId().substring(1);
                for (int i = 0, j = 0; j < list.length()/2; i += 2, j++) {
                    comb.getIngredients().add(new OrderResponse.IngredientDto(ingredientRepository.findByIngredientId(list.substring(i, i+2))));
                }
                comb.setMenu(new OrderResponse.MenuDto(menuRepository.findByMenuId(menuId)));
            });
            System.out.println(order);
        });
        return orderList;
    }

    public Combination saveCombination(OrderRequest.CombinationDto combination) {
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

}
