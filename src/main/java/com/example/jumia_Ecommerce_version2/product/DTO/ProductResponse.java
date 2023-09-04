package com.example.jumia_Ecommerce_version2.product.DTO;

import com.example.jumia_Ecommerce_version2.data.model.Categories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String productName;
    private BigDecimal productPrice;
    private LocalDateTime createdAt;
    private Categories category;
    private long quantity;
}
