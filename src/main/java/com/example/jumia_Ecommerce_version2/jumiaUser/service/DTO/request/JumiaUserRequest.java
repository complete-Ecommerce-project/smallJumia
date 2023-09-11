package com.example.jumia_Ecommerce_version2.jumiaUser.service.DTO.request;

import com.example.jumia_Ecommerce_version2.data.model.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class JumiaUserRequest {
    private String userName;
    private String password;

    private String phoneNumber;

    private String emailAddress;
    private String mobileNetwork;

    private Address address;
}
