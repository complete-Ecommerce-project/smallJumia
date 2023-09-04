package com.example.jumia_Ecommerce_version2.product.service.interfaces;

import com.example.jumia_Ecommerce_version2.product.DTO.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAllProductByWareHouseName(String wareHouseName);



}
