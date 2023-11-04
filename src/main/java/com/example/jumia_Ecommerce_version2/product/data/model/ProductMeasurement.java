package com.example.jumia_Ecommerce_version2.product.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder


public class ProductMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long quantity;
    
    @Column(nullable = false)
    private BigDecimal productMeasurementPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    private long productQuantity;

    private String productMeasurementName;
}
