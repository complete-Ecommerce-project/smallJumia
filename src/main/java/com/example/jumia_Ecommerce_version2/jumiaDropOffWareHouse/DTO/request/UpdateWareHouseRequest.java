package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UpdateWareHouseRequest {
    private String oldWareHouseName;
    private String buildingNumber;
    private String streetName;
    private String locationGovernmentName;
    private String state;
    private LocalDateTime lastUpdate;
    private String wareHouseName;
}
