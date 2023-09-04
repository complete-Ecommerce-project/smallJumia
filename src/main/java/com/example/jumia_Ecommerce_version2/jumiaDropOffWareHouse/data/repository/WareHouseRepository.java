package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.data.repository;

import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.data.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {


    boolean existsWareHouseByWareHouseName(String streetName);


    WareHouse findByWareHouseName(String wareHouseName);

}
