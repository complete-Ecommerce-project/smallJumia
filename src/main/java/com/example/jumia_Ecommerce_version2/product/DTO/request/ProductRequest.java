package com.example.jumia_Ecommerce_version2.product.DTO.request;

import com.example.jumia_Ecommerce_version2.cart.data.data.model.Cart;
import com.example.jumia_Ecommerce_version2.data.model.Categories;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce_version2.productSupplier.data.model.ProductSupplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ProductRequest {


    private String productName;

    private BigDecimal productPrice;
    private Categories category;
    private String wareHouseName;
    private long quantity;
    private String productSupplierName;

    private ProductSupplier productSupplier;

    private WareHouse wareHouse;
}
