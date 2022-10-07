package com.ssafy.spring.user.dto;

import com.ssafy.spring.user.entity.Collection;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class CollectionDto {
    private String menuName;
    private int ranking;
    private Date rankDate;

    public CollectionDto(Collection collection){
        this.menuName = collection.getMenuName();
        this.ranking = collection.getRanking();
        this.rankDate = collection.getRankDate();
    }
}
