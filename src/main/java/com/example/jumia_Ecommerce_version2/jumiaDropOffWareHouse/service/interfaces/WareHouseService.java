package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.service.interfaces;

import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request.WareHouseRequest;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.response.WareHouseLoginResponse;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce_version2.product.DTO.request.ProductRequest;
import com.example.jumia_Ecommerce_version2.product.data.model.Product;


public interface WareHouseService {
    WareHouseResponse registerNewWareHouse(WareHouseRequest wareHouseRequest1);

    WareHouseResponse updateWareHouse(UpdateWareHouseRequest updateWareHouseRequest);

    boolean deleteWareHouseByName(String oyingbo);
    WareHouse findByWareHouseByName(String warehouseHouseName);

    boolean deleteAllWareHouse();

    long countNumberOfWareHouse();

    WareHouseLoginResponse loginToWareHouseDashBoard(String wareHouseName, String wareHousePassword);

}
