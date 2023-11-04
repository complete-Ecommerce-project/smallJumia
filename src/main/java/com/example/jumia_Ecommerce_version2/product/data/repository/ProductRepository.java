package com.example.jumia_Ecommerce_version2.product.data.repository;

import com.example.jumia_Ecommerce_version2.product.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByWareHouseNameOrderByCategory(String warehouse);

    boolean existsByProductName(String productName);
}
