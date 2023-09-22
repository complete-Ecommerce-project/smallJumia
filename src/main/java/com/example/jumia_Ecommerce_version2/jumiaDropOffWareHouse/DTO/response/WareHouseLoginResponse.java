package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.response;

import com.example.jumia_Ecommerce_version2.data.model.Categories;
import com.example.jumia_Ecommerce_version2.product.DTO.response.ProductResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WareHouseLoginResponse {
    private boolean isLoggedIn;
    private Categories[] categories = Categories.values();
    private final List<ProductResponse> listOfProducts = new ArrayList<>();


    public void addProductToList(List<ProductResponse> productResponse){
        listOfProducts.addAll(productResponse);
    }
   }
