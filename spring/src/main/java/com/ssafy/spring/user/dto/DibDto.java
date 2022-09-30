package com.ssafy.spring.user.dto;

import com.ssafy.spring.user.entity.User;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
public class DibDto {
    private int dibId;

    @NotNull
    private int combinationPostId;

    @NotNull
    @ColumnDefault("true")
    private boolean state;
}