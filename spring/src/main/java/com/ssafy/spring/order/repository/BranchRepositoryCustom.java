package com.ssafy.spring.order.repository;

import com.ssafy.spring.order.dto.BranchDto;

import java.util.List;

public interface BranchRepositoryCustom {
    List<BranchDto> findByLatAndLng(float minlat, float maxlat, float minlng, float maxlng);
}
