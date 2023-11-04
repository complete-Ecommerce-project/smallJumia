package com.example.jumia_Ecommerce_version2.product.data.model;

import com.example.jumia_Ecommerce_version2.cart.data.data.model.Cart;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce_version2.data.model.Categories;
import com.example.jumia_Ecommerce_version2.productSupplier.data.model.ProductSupplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String productName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private Categories category;
    @Column(nullable = false)
    private String wareHouseName;


       @ManyToOne

    private ProductSupplier productSupplier;
    @ManyToOne
    private WareHouse wareHouse;

    @OneToMany
    private List<ProductMeasurement> listOfProductMeasure = new ArrayList<>();

}
