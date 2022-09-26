package com.ssafy.spring.order.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class BranchDto {
    private int branchId;
    private String branchName;
    private String streetAddress;
    private String contactNo;
    private float lat;
    private float lng;

    @QueryProjection
    public BranchDto(int branchId, String branchName, String streetAddress, String contactNo, float lat, float lng) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.streetAddress = streetAddress;
        this.contactNo = contactNo;
        this.lat = lat;
        this.lng = lng;
    }
}
