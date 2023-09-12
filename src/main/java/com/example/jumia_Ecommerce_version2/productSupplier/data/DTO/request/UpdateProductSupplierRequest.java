package com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request;
import com.example.jumia_Ecommerce_version2.data.model.Address;
import lombok.Data;

@Data
public class UpdateProductSupplierRequest {
    private String productSupplierUserName, productSupplierEmailAddress;

    private String userName;

    private String password;

    private String phoneNumber;

    private String emailAddress;
    private Address address;
}
