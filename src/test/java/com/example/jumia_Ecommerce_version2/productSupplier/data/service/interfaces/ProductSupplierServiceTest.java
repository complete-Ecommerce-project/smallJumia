package com.example.jumia_Ecommerce_version2.productSupplier.data.service.interfaces;

import com.example.jumia_Ecommerce_version2.data.model.Address;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce_version2.productSupplier.data.DTO.request.UpdateProductSupplierRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ProductSupplierServiceTest {
    @Autowired
private  ProductSupplierService productSupplierServiceService;


private Address address1;
private Address address2;
private Address address3;
private JumiaUser jumiaUser1;
private JumiaUser jumiaUser2;
private JumiaUser jumiaUser3;
private UpdateProductSupplierRequest supplierUpdateRequest;
private Address updateAddress;

private ProductSupplierRequest productSupplierRequest1;
private ProductSupplierRequest productSupplierRequest2;
private ProductSupplierRequest productSupplierRequest3;


    @BeforeEach
    void setUp() {
     address1 = new Address();
     address1.setState("lagos");
     address1.setStreetName("88");
     address1.setStreetName("awoyejo");
     address1.setLocationGovernmentName("mushin");
jumiaUser1 = new JumiaUser();
    jumiaUser1.setAddress(address1);
    jumiaUser1.setUserName("samuel shola");
    jumiaUser1.setPassword("SAMUELSHOLA14@GMAIL.COM0");
    jumiaUser1.setEmailAddress("samuelshola14@gmail.com");
    jumiaUser1.setPhoneNumber("09099332737");
    productSupplierRequest1 = new ProductSupplierRequest();
    productSupplierRequest1.setJumiaUser(jumiaUser1);


address2 = new Address();
    address2.setLocationGovernmentName("ikeja");
    address2.setStreetName("airport road");
    address2.setState("lagos");
    address2.setBuildingNumber("56");
jumiaUser2 = new JumiaUser();
    jumiaUser2.setPhoneNumber("09062666877");
    jumiaUser2.setAddress(address2);
    jumiaUser2.setUserName("boneshaker");
    jumiaUser2.setPassword("BONESHAKER986@GMAIL.COM");
    jumiaUser2.setEmailAddress("boneshaker896@gmail.com");
    productSupplierRequest2 = new ProductSupplierRequest();
    productSupplierRequest2.setJumiaUser(jumiaUser2);

address3 = new Address();
    address3.setBuildingNumber("100");
    address3.setState("lagos");
    address3.setStreetName("makoko");
    address3.setLocationGovernmentName("ebute meta");
jumiaUser3 = new JumiaUser();
    jumiaUser3.setEmailAddress("sholaibrahimoh@gmail.com");
    jumiaUser3.setPassword("blueboat123");
    jumiaUser3.setAddress(address3);
    jumiaUser3.setUserName("sambone");
    jumiaUser3.setPhoneNumber("09062666877");
    jumiaUser3.setPassword("1SHOLAIBRAHIMOH2@GMAIL.COM3");
    productSupplierRequest3 = new ProductSupplierRequest();
    productSupplierRequest3.setJumiaUser(jumiaUser3);

    supplierUpdateRequest = new UpdateProductSupplierRequest();
    updateAddress = new Address();
    updateAddress.setLocationGovernmentName("iwaya");
    updateAddress.setStreetName("more road");
    supplierUpdateRequest.setProductSupplierUserName("sambone");
    supplierUpdateRequest.setUserName("isreal");
    supplierUpdateRequest.setAddress(updateAddress);

    }

    @Test
    void registerNewProductSupplier(){
try{
    assertNotNull(productSupplierServiceService.registerNewProductSupplier(productSupplierRequest1));
    assertNotNull(productSupplierServiceService.registerNewProductSupplier(productSupplierRequest2));
    assertNotNull(productSupplierServiceService.registerNewProductSupplier(productSupplierRequest3));

}catch(Exception e){
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>  "+e.getMessage());
}
    }

    @Test
    void updateProductSupplier(){
try{
    assertEquals("isreal", productSupplierServiceService.updateProductSupplierDetails(supplierUpdateRequest).getUserName());

}catch (Exception a){
    System.out.println(a.getMessage()+"   <<<<<<<");
}
    }

@Test
    void deleteProductSupplier(){
        assertEquals("deleted successfully \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49", productSupplierServiceService.deleteProductSupplierByName("sambone"));
        assertEquals("deleted successfully \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49", productSupplierServiceService.deleteProductSupplierByName("boneshaker"));
        assertEquals("deleted successfully \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49", productSupplierServiceService.deleteProductSupplierByName("samuel shola"));
        assertNull(productSupplierServiceService.findProductSupplierByUserName("samuel shola"));
        assertNull(productSupplierServiceService.findProductSupplierByEmailAddress("samuelshola14@gmail.com"));
        assertNull(productSupplierServiceService.findProductSupplierByUserName("boneshaker"));
        assertNull(productSupplierServiceService.findProductSupplierByEmailAddress("sholaibrahimoh@gmail.com"));
        assertNull(productSupplierServiceService.findProductSupplierByUserName("sambone"));
        assertNull(productSupplierServiceService.findProductSupplierByEmailAddress("boneshaker896@gmail.com"));
}
@Test
    void reRegisterDeletedProductSupplier(){
    assertNotNull(productSupplierServiceService.registerNewProductSupplier(productSupplierRequest3));

}
@Test
    void deleteAllProductSupplier(){
        productSupplierServiceService.deleteAllProductSupplier();
    }


}