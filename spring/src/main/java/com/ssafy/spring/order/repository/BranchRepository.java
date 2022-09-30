package com.ssafy.spring.order.repository;

import com.ssafy.spring.order.dto.BranchDto;
import com.ssafy.spring.order.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Integer>, BranchRepositoryCustom {

}
