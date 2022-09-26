package com.ssafy.spring.order.service;

import com.ssafy.spring.order.dto.BranchDto;
import com.ssafy.spring.order.dto.OrderDto;
import com.ssafy.spring.order.repository.BranchRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BranchRepositoryCustom branchRepository;

    @Override
    public List<BranchDto> getStores(float minlat, float maxlat, float minlng, float maxlng) {
        return branchRepository.findByLatAndLng(minlat, maxlat, minlng, maxlng);
    }

    @Override
    public OrderDto.responseDto order(OrderDto.requestDto orderRequestDto) {
        return null;
    }
}
