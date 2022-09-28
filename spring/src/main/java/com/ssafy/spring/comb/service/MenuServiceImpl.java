package com.ssafy.spring.comb.service;

import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    public Menu getMenuByMenuId(String meunId) {
        return menuRepository.findByMenuId(meunId);
    }

}
