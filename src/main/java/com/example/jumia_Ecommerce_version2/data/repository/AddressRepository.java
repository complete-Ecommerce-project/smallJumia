package com.example.jumia_Ecommerce_version2.data.repository;

import com.example.jumia_Ecommerce_version2.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByStreetName(String streetName);
}
