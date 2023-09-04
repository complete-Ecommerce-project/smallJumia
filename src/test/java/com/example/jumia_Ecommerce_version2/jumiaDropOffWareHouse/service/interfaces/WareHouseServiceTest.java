package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.service.interfaces;

import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request.WareHouseRequest;
import com.example.jumia_Ecommerce_version2.data.model.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WareHouseServiceTest {
@Autowired
private  WareHouseService wareHouseService;
private Address address1;
private Address address2;
private Address address3;
private Address address4;
private WareHouseRequest wareHouseRequest1;
private WareHouseRequest wareHouseRequest2;
private WareHouseRequest wareHouseRequest3;
private WareHouseRequest wareHouseRequest4;
private  UpdateWareHouseRequest updateWareHouseRequest;


    @BeforeEach
    void setUp() {
        wareHouseRequest1 = new WareHouseRequest();
        wareHouseRequest1.setPassword("blueSEa");
        address1 = new Address();
        address1.setBuildingNumber("3");
        address1.setState("lagos");
        address1.setStreetName("yaba");
        address1.setLocationGovernmentName("yaba");
        wareHouseRequest1.setWareHouseAddress(address1);

        wareHouseRequest2 = new WareHouseRequest();
        wareHouseRequest2.setPassword("blueBoat");
        address2 = new Address();
        address2.setBuildingNumber("67");
        address2.setState("lagos");
        address2.setStreetName("sango");
        address2.setLocationGovernmentName("sango");
        wareHouseRequest2.setWareHouseAddress(address2);

        wareHouseRequest3 = new WareHouseRequest();
        wareHouseRequest3.setPassword("blueShip");
        address3 = new Address();
        address3.setBuildingNumber("34");
        address3.setState("lagos");
        address3.setStreetName("mongoMarry");
        address3.setLocationGovernmentName("yaba");
        wareHouseRequest3.setWareHouseAddress(address3);

        wareHouseRequest4 = new WareHouseRequest();
        wareHouseRequest4.setPassword("blueboat");
        address4 = new Address();
        address4.setBuildingNumber("70");
        address4.setState("lagos");
        address4.setStreetName("oshodi");
        address4.setLocationGovernmentName("oshodi");
        wareHouseRequest4.setWareHouseAddress(address4);

        // todo  updating ware house

    updateWareHouseRequest = new UpdateWareHouseRequest();
        updateWareHouseRequest.setWareHouseName("oyingbo");
        updateWareHouseRequest.setOldWareHouseName("yaba");



    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void createWareTes(){
        assertNotNull(wareHouseService.registerNewWareHouse(wareHouseRequest1));
        assertNotNull(wareHouseService.registerNewWareHouse(wareHouseRequest2));
        assertNotNull(wareHouseService.registerNewWareHouse(wareHouseRequest3));
        assertNotNull(wareHouseService.registerNewWareHouse(wareHouseRequest4));
    }
    @Test
    void renameWarehouse(){
        assertEquals("oyingbo",wareHouseService.updateWareHouse(updateWareHouseRequest).getWarehouseName());
    }
    @Test
    void deleteWareHouseBy(){
        assertDoesNotThrow(()->{
            wareHouseService.deleteWareHouseByName("oyingbo");
        });
    }
    @Test
    void findByWareHouseName(){
        assertEquals("yaba", wareHouseService.findByWareHouseByName("yaba").getWareHouseName());
    }
    @Test
    void deleteAllWareHouse(){
        wareHouseService.deleteAllWareHouse();
        assertEquals(0,wareHouseService.countNumberOfWareHouse() );
    }
    @Test
    void warehouseLogin(){
        assertTrue(wareHouseService.loginToWareHouseDashBoard("mongoMarry","blueShip").isLoggedIn());
//        assertDoesNotThrow(()->{
//wareHouseService.loginToWareHouseDashBoard("mongoMarry","blueship");
//        });
    }


}