package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.controller;

import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request.WareHouseRequest;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.service.interfaces.WareHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jumia/api")
public class WareHouseController {
    private final WareHouseService wareHouseService;

    @PostMapping("/")
    public ResponseEntity<WareHouseResponse> registerWareHouse(@RequestBody WareHouseRequest wareHouseRequest){
        return new ResponseEntity<>(wareHouseService.registerNewWareHouse(wareHouseRequest), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<WareHouseResponse> updateWareHouseDetails(UpdateWareHouseRequest updateWareHouseRequest){
        return new ResponseEntity<>(wareHouseService.updateWareHouse(updateWareHouseRequest), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/")
    public ResponseEntity<String> deleteWareHouseByWareHouseName(@RequestParam String wareHouseName){
        wareHouseService.deleteWareHouseByName(wareHouseName);
        return new ResponseEntity<>(" ware house with the name "+wareHouseName+" has been deleted  \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49",HttpStatus.OK);

    }
    @DeleteMapping("/")
    public ResponseEntity<String> deleteAllWareHouse(){
        wareHouseService.deleteAllWareHouse();
        return new ResponseEntity<>(" all ware house has been deleted  \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49",HttpStatus.OK);

    }



}
