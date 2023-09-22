package com.example.jumia_Ecommerce_version2.product.service.interfaces;

import com.example.jumia_Ecommerce_version2.product.DTO.request.ProductRequest;
import com.example.jumia_Ecommerce_version2.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce_version2.product.data.model.Product;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAllProductByWareHouseName(String wareHouseName);

   Product supplyNewProduct(ProductRequest productRequest);
   Product findProductByProductName(String productName);


    Product saveProduct(Product foundProduct);
}
