package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request;


import com.example.jumia_Ecommerce_version2.data.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseRequest {

    private Address wareHouseAddress;
    private String wareHouseName;
    private String password;
}
