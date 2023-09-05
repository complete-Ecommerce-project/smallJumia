package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.service.implementation;

import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.request.WareHouseRequest;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.response.WareHouseLoginResponse;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.data.repository.WareHouseRepository;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.exception.WareHouseLoginException;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.exception.WareHouseRegistrationException;
import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.service.interfaces.WareHouseService;
import com.example.jumia_Ecommerce_version2.data.model.Address;
import com.example.jumia_Ecommerce_version2.product.service.interfaces.ProductService;
import com.example.jumia_Ecommerce_version2.service.interfaces.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WareHouseServiceIMPL implements WareHouseService {
    private final WareHouseRepository wareHouseRepository;
    private final AddressService addressService;
    private final ProductService productService;

    @Override
    public WareHouseResponse registerNewWareHouse(WareHouseRequest wareHouseRequest) {
        String wareHouseName = wareHouseRequest.getWareHouseAddress().getStreetName();
        if (wareHouseRepository.existsWareHouseByWareHouseName(wareHouseName))
            throw new WareHouseRegistrationException("Warehouse already exists");
        Address savedAddress = addressService.saveAddress(wareHouseRequest.getWareHouseAddress());
        WareHouse newWareHouse = WareHouse.builder()
                .wareHouseAddress(savedAddress)
                .createTime(LocalDateTime.now())
                .password(wareHouseRequest.getPassword())
                .wareHouseName(wareHouseName)
                .build();
        wareHouseRepository.save(newWareHouse);
        return WareHouseResponse.builder().warehouseName(wareHouseName).build();
    }

    @Override
    public WareHouseResponse updateWareHouse(UpdateWareHouseRequest updateWareHouseRequest) {
        if (wareHouseRepository.existsWareHouseByWareHouseName(updateWareHouseRequest.getWareHouseName()))
            throw new WareHouseRegistrationException("the attempt update name value "+updateWareHouseRequest.getWareHouseName()+" already in use");
   WareHouse foundWareHouse = findByWareHouseByName(updateWareHouseRequest.getOldWareHouseName());
   Address foundAddress = foundWareHouse.getWareHouseAddress();
   if (updateWareHouseRequest.getState() != null){
       foundAddress.setState(updateWareHouseRequest.getState());
   }
    if (updateWareHouseRequest.getBuildingNumber() != null){
        foundAddress.setBuildingNumber(updateWareHouseRequest.getBuildingNumber());
    }
    if (updateWareHouseRequest.getLocationGovernmentName() != null){
        foundAddress.setLocationGovernmentName(updateWareHouseRequest.getLocationGovernmentName());
    }
    if (updateWareHouseRequest.getStreetName() != null){
        foundWareHouse.setWareHouseName(updateWareHouseRequest.getStreetName());
    }
   foundWareHouse.setWareHouseAddress(foundAddress);

    foundWareHouse.setWareHouseName(updateWareHouseRequest.getWareHouseName());


        foundWareHouse.setLastUpdate(LocalDateTime.now());
    wareHouseRepository.save(foundWareHouse);
        return WareHouseResponse.builder().warehouseName(foundWareHouse.getWareHouseName()).build();
    }

    @Override
    public boolean deleteWareHouseByName(String wareHouseName) {
        try {
            WareHouse foundWareHouse = findByWareHouseByName(wareHouseName);
            wareHouseRepository.delete(foundWareHouse);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public WareHouse findByWareHouseByName(String warehouseHouseName) {
        WareHouse foundWareHouse = wareHouseRepository.findByWareHouseName(warehouseHouseName);
        if (foundWareHouse == null) throw new WareHouseRegistrationException("could not find warehouse with name " + warehouseHouseName);
        return foundWareHouse;
    }

    @Override
    public boolean deleteAllWareHouse() {
        wareHouseRepository.deleteAll();
        return true;
    }

    @Override
    public long countNumberOfWareHouse() {
        return wareHouseRepository.count();
    }

    @Override
    public WareHouseLoginResponse loginToWareHouseDashBoard(String wareHouseName, String wareHousePassword) {
        WareHouse foundWareHouse = findByWareHouseByName(wareHouseName);
        if (!foundWareHouse.getPassword().equals(wareHousePassword)) throw new WareHouseLoginException("Login Failed \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49");
        foundWareHouse.setLoggedIn(true);
        WareHouseLoginResponse wareHouseLoginResponse = new WareHouseLoginResponse();
        wareHouseLoginResponse.addProductToList(productService.getAllProductByWareHouseName(foundWareHouse.getWareHouseName()));
        wareHouseLoginResponse.setLoggedIn(foundWareHouse.isLoggedIn());
        wareHouseRepository.save(foundWareHouse);
        return  wareHouseLoginResponse;
    }



}
