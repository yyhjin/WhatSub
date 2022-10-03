package com.ssafy.spring.user.dto;

import com.ssafy.spring.comb.dto.CombPostDto;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.user.entity.Dib;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter @Setter
public class DibDto {
    private int dibId;
//    private int combinationPostId;
    private CombPostDto combinationPostDto;
    private boolean state;

    public DibDto(Dib dib) {
        this.dibId = dib.getDibId();
        this.combinationPostDto = new CombPostDto(dib.getCombinationPost());
        this.state = dib.isState();
    }
}
