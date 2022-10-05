package com.ssafy.spring.ranking.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class RankingDto {

    private int rankingId;
    private String menuId;
    private String menuName;
    private String imgUrl;
    private Date rankDate;
    private List<RankingData> data;

    @SuppressWarnings("unchecked")
    public RankingDto(int rankingId, String menuId, String menuName, String imgUrl, Date rankDate, String data) throws JsonProcessingException {
        this.rankingId = rankingId;
        this.menuId = menuId;
        this.menuName = menuName;
        this.imgUrl = imgUrl;
        this.rankDate = rankDate;

        ObjectMapper mapper = new ObjectMapper();
        this.data = mapper.readValue(data, List.class);
    }
}
