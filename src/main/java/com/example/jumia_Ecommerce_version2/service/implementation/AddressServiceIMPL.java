package com.example.jumia_Ecommerce_version2.service.implementation;

import com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.exception.AddressException;
import com.example.jumia_Ecommerce_version2.data.model.Address;
import com.example.jumia_Ecommerce_version2.data.repository.AddressRepository;
import com.example.jumia_Ecommerce_version2.service.interfaces.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceIMPL implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findByStreetName(String streetName) {
        Address foundAddress = addressRepository.findByStreetName(streetName);
        if (foundAddress == null) {
            throw new AddressException("Could not find address by street name " + streetName);
        }
       return foundAddress;
    }

    @Override
    public void deleteAllAddress() {
        addressRepository.deleteAll();
    }

    @Override
    public long countAddresses() {
        return addressRepository.count();
    }
}
