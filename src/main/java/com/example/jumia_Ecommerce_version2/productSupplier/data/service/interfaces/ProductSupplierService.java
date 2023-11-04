package com.example.jumia_Ecommerce_version2.productSupplier.data.service.interfaces;

import com.example.jumia_Ecommerce_version2.product.data.model.Product;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request.UpdateProductSupplierRequest;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.response.ProductSupplierResponse;
import com.example.jumia_Ecommerce_version2.productSupplier.data.model.ProductSupplier;

import java.security.Principal;

public interface ProductSupplierService {
    ProductSupplierResponse registerNewProductSupplier(ProductSupplierRequest productSupplierRequest1);
    ProductSupplier findProductSupplierByUserName(String username);
    ProductSupplier findProductSupplierByEmailAddress(String emailAddress);
    ProductSupplierResponse updateProductSupplierDetails(UpdateProductSupplierRequest supplierUpdateRequest);
    String deleteProductSupplierByName(String username);

    Product supplyNewProduct(Principal principal, Product product);

    String deleteAllProductSupplier();
}
