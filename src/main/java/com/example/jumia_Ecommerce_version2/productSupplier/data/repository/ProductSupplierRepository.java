package com.example.jumia_Ecommerce_version2.productSupplier.data.repository;

import com.example.jumia_Ecommerce_version2.productSupplier.data.model.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Long> {
    ProductSupplier findByJumiaUserUserName(String username);

    ProductSupplier findByJumiaUserEmailAddress(String emailAddress);
}
