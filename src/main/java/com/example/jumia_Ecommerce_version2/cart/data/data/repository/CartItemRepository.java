package com.example.jumia_Ecommerce_version2.cart.data.data.repository;

import com.example.jumia_Ecommerce_version2.cart.data.data.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
