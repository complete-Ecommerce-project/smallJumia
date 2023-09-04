package com.example.jumia_Ecommerce_version2.service.interfaces;

import com.example.jumia_Ecommerce_version2.data.model.Address;

public interface AddressService {
    Address saveAddress(Address address);
    Address findByStreetName(String streetName);
    void deleteAllAddress();
    long countAddresses();

}
