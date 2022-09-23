package com.ssafy.spring.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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

    @NotBlank
    private float lat;

    @NotBlank
    private float lng;
}
