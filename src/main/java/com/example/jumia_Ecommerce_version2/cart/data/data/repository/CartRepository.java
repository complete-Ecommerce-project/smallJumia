package com.example.jumia_Ecommerce_version2.cart.data.data.repository;

import com.example.jumia_Ecommerce_version2.cart.data.data.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
