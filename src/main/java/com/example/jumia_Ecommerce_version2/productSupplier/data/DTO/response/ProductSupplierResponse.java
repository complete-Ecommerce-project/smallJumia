package com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSupplierResponse {

    private String mobileNetwork;
    private String userName;
    private String phoneNumber;
}
