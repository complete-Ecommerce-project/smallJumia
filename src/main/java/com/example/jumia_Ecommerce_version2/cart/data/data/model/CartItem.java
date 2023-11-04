package com.example.jumia_Ecommerce_version2.cart.data.data.model;

import com.example.jumia_Ecommerce_version2.product.data.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Cart cart;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> listOfProduct = new ArrayList<>();
}
