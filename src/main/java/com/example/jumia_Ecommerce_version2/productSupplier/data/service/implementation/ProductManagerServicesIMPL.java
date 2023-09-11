package com.example.jumia_Ecommerce_version2.productSupplier.data.service.implementation;

import com.example.jumia_Ecommerce_version2.data.model.Role;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.service.interfaces.JumiaUserService;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.response.ProductSupplierResponse;
import com.example.jumia_Ecommerce_version2.productSupplier.data.model.ProductSupplier;
import com.example.jumia_Ecommerce_version2.productSupplier.data.repository.ProductSupplierRepository;
import com.example.jumia_Ecommerce_version2.productSupplier.data.service.interfaces.ProductSupplierService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Transactional
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductManagerServicesIMPL implements ProductSupplierService {
    private final JumiaUserService jumiaUserService;
    private final ProductSupplierRepository supplierRepository;
    @Override
    public ProductSupplierResponse registerNewProductSupplier(ProductSupplierRequest productSupplierRequest1) {
        JumiaUser registeredJumiaUser = jumiaUserService.registerNewJumiaUser(mapRequestToJumiaUserRequest(productSupplierRequest1));
        ProductSupplier builtProductSupplier = ProductSupplier.builder()
                .role(Role.SUPPLIER)
                .jumiaUser( registeredJumiaUser)
                .build();
        return mapToProductSupplierResponse(supplierRepository.save(builtProductSupplier));
    }
    public JumiaUserRequest mapRequestToJumiaUserRequest(ProductSupplierRequest productSupplierRequest){
        return JumiaUserRequest.builder()
                .userName(productSupplierRequest.getJumiaUser().getUserName())
                .password(productSupplierRequest.getJumiaUser().getPassword())
                .emailAddress(productSupplierRequest.getJumiaUser().getEmailAddress())
                .address(productSupplierRequest.getJumiaUser().getAddress())
                .phoneNumber(productSupplierRequest.getJumiaUser().getPhoneNumber())
                .build();
    }
    public ProductSupplierResponse mapToProductSupplierResponse(ProductSupplier productSupplier){
        return  ProductSupplierResponse.builder()
                .mobileNetwork(productSupplier.getJumiaUser().getMobileNetwork())
                .phoneNumber(productSupplier.getJumiaUser().getPhoneNumber())
                .userName(productSupplier.getJumiaUser().getUserName())
                .build();
    }
}
