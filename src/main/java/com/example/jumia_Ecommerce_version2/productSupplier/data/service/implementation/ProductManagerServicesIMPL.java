package com.example.jumia_Ecommerce_version2.productSupplier.data.service.implementation;

import com.example.jumia_Ecommerce_version2.data.model.Role;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.service.interfaces.JumiaUserService;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request.UpdateProductSupplierRequest;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.response.ProductSupplierResponse;
import com.example.jumia_Ecommerce_version2.productSupplier.data.exception.ProductSupplierException;
import com.example.jumia_Ecommerce_version2.productSupplier.data.model.ProductSupplier;
import com.example.jumia_Ecommerce_version2.productSupplier.data.repository.ProductSupplierRepository;
import com.example.jumia_Ecommerce_version2.productSupplier.data.service.interfaces.ProductSupplierService;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public ProductSupplier findProductSupplierByUserName(String username) {
        ProductSupplier foundProductSupplier = supplierRepository.findByJumiaUserUserName(username);
        if (foundProductSupplier == null)
        throw new ProductSupplierException("could'nt find supplier with the name >> "
        +username+" \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49");
        return foundProductSupplier;
    }

    @Override
    public ProductSupplier findProductSupplierByEmailAddress(String emailAddress) {
        ProductSupplier foundProductSupplier = supplierRepository.findByJumiaUserEmailAddress(emailAddress);
        if (foundProductSupplier == null)
            throw new ProductSupplierException("could'nt find supplier with the name >>> "
                    +emailAddress+" \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49");
        return foundProductSupplier;
    }

    @Override
    public ProductSupplierResponse updateProductSupplierDetails(UpdateProductSupplierRequest supplierUpdate) {
        ProductSupplier foundSupplier = null;
        String supplierEmail = supplierUpdate.getEmailAddress();
        String supplierUserName = supplierUpdate.getProductSupplierUserName();
       try {
           if (supplierEmail != null){
               if (jumiaUserService.ifExistByEmail(supplierUpdate.getEmailAddress())) throw new ProductSupplierException(">>email address  "+supplierEmail+" already exist <<<" );
               foundSupplier = findProductSupplierByEmailAddress(supplierEmail);
           } else if (foundSupplier == null && supplierUserName != null) {
               if (jumiaUserService.ifExistByUsername(supplierUpdate.getUserName())) throw new ProductSupplierException(">>user name  "+supplierUserName+" already exist <<<" );

               foundSupplier = findProductSupplierByUserName(supplierUserName);
           }if (foundSupplier == null && supplierUserName == null && supplierEmail == null )
               throw new ProductSupplierException("an error occur due to invalid username >> " +
                       ""+supplierUserName+" << or due to invalid email address >> "+supplierEmail);
       }catch (Exception e){
           System.out.println(e.getMessage()+"  <<<<<<<<<<<<<<<");
       }
        return mapToProductSupplierResponse(supplierRepository.save(Objects.requireNonNull(updateFillUpSupplier(foundSupplier, supplierUpdate))));
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
    private ProductSupplier updateFillUpSupplier(ProductSupplier productSupplier,UpdateProductSupplierRequest updateRequest){
if (updateRequest.getPassword() != null)
productSupplier.getJumiaUser().setPassword
(updateRequest.getPassword());
if (updateRequest.getEmailAddress() != null)
productSupplier.getJumiaUser().setEmailAddress
(updateRequest.getEmailAddress());
if (updateRequest.getPhoneNumber() != null)
productSupplier.getJumiaUser().setPhoneNumber
(updateRequest.getPhoneNumber());
if (updateRequest.getUserName() != null)
productSupplier.getJumiaUser().setUserName
(updateRequest.getUserName());
if (updateRequest.getAddress().getStreetName() != null)
productSupplier.getJumiaUser().getAddress().setStreetName
(updateRequest.getAddress().getStreetName());
if (updateRequest.getAddress().getState() != null)
productSupplier.getJumiaUser().getAddress().setState
(updateRequest.getAddress().getState());
if (updateRequest.getAddress().getBuildingNumber() != null)
productSupplier.getJumiaUser().getAddress().setBuildingNumber
(updateRequest.getAddress().getBuildingNumber());
if (updateRequest.getAddress().getLocationGovernmentName() != null)
productSupplier.getJumiaUser().getAddress().setLocationGovernmentName
(updateRequest.getAddress().getLocationGovernmentName());
return productSupplier;
    }
}
