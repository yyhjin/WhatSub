package com.ssafy.spring.user.service;

import com.ssafy.spring.user.entity.Excluded;

import java.util.List;

public interface ExcludedService {

    Excluded save(Excluded excluded);

    List<Excluded> saveAll(List<Excluded> excludedList);
}
