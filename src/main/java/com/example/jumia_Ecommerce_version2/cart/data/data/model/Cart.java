package com.example.jumia_Ecommerce_version2.cart.data.data.model;

import com.example.jumia_Ecommerce_version2.customer.data.model.Customer;
import com.example.jumia_Ecommerce_version2.product.data.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Customer customer;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Product> listOfProducts = new ArrayList<>();
}
