package com.ssafy.spring.user.dto;

import com.ssafy.spring.user.entity.Dib;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter @Setter
public class DibDto {
    private int dibId;
    private int combinationPostId;
    private boolean state;

    public DibDto(Dib dib) {
        this.dibId = dib.getDibId();
        this.combinationPostId = dib.getCombinationPostId();
        this.state = dib.isState();
    }
}
