package com.ssafy.spring.order.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.spring.order.dto.BranchDto;
import com.ssafy.spring.order.dto.QBranchDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.ssafy.spring.order.entity.QBranch.branch;

@RequiredArgsConstructor
public class BranchRepositoryImpl implements BranchRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<BranchDto> findByLatAndLng(float minlat, float maxlat, float minlng, float maxlng) {
        return queryFactory
                .select(new QBranchDto(branch.branchId, branch.branchName, branch.streetAddress, branch.contactNo, branch.lat, branch.lng))
                .from(branch)
                .where(branch.lat.between(minlat, maxlat).and(branch.lng.between(minlng, maxlng)))
                .fetch();
    }
}
