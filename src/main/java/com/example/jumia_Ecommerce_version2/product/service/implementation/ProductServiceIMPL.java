package com.example.jumia_Ecommerce_version2.product.service.implementation;

import com.example.jumia_Ecommerce_version2.product.DTO.request.ProductRequest;
import com.example.jumia_Ecommerce_version2.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce_version2.product.data.model.Product;
import com.example.jumia_Ecommerce_version2.product.data.repository.ProductRepository;
import com.example.jumia_Ecommerce_version2.product.exception.ProductException;
import com.example.jumia_Ecommerce_version2.product.service.interfaces.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional

public class ProductServiceIMPL implements ProductService {
    private final ProductRepository productRepository;


//    @Override
//    public List<ProductResponse> getAllProductByWareHouseName(String wareHouseName) {
//        List<Product> listOfProduct = productRepository.findByWareHouseNameOrderByCategory(wareHouseName);
//        List<ProductResponse> productResponseList = new ArrayList<>();
//        for (int i = 0; i < listOfProduct.size(); i++) {
//            ProductResponse productResponse = ProductResponse.builder()
//                    .productName(listOfProduct.get(i).getProductName())
//                    .productPrice(listOfProduct.get(i).getProductPrice())
//                    .category(listOfProduct.get(i).getCategory())
//                    .createdAt(listOfProduct.get(i).getCreatedAt())
//                    .build();
//            productResponseList.add(productResponse);
//        }
//        return productResponseList;
//    }

    public ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .createdAt(product.getCreatedAt())
                .productName(product.getProductName())
                .category(product.getCategory())
                .productPrice(product.getProductPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public List<ProductResponse> getAllProductByWareHouseName(String wareHouseName) {
        List<Product> listOfProduct = productRepository.findByWareHouseNameOrderByCategory(wareHouseName);

        return listOfProduct.stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Product supplyNewProduct(ProductRequest productRequest) {
        return productRepository.save( Product.builder()
                .productSupplier(productRequest.getProductSupplier())
                .productSupplierName(productRequest.getProductSupplierName())
                .wareHouse(productRequest.getWareHouse())
                .productPrice(productRequest.getProductPrice())
                .productName(productRequest.getProductName())
                .category(productRequest.getCategory())
                .wareHouseName(productRequest.getWareHouseName())
                .quantity(productRequest.getQuantity())
                .build());
            }

    @Override
    public Product findProductByProductName(String productName) {
        Product foundProduct = productRepository.findByProductName(productName);
        if (foundProduct == null)throw new ProductException("counld'nt find product with the name >>>>"+productName);
        return foundProduct;
    }

    @Override
    public Product saveProduct(Product foundProduct) {
        return productRepository.save(foundProduct);
    }
}

