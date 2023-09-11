package com.example.jumia_Ecommerce_version2.productSupplier.data.service.interfaces;

import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.response.ProductSupplierResponse;

public interface ProductSupplierService {
    ProductSupplierResponse registerNewProductSupplier(ProductSupplierRequest productSupplierRequest1);
}
