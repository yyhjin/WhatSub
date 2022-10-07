package com.ssafy.spring.order.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;

    @NotBlank
    private String branchName;

    @NotBlank
    private String streetAddress;

    @NotBlank
    private String contactNo;

    private float lat;

    private float lng;
}
