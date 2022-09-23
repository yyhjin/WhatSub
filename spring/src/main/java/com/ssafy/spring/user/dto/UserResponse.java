package com.ssafy.spring.user.dto;

import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.user.entity.Dib;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;

public class UserResponse {
    public static class GetUserResponse{

    }

    @AllArgsConstructor
    public static class GetDibNcombListResponse{
        List<Dib> dibList;
        List<Combination> combinationList;
    }
}
