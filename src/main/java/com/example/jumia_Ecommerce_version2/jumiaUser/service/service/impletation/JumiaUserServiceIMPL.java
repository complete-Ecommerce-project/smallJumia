package com.example.jumia_Ecommerce_version2.jumiaUser.service.service.impletation;

import com.example.jumia_Ecommerce_version2.jumiaUser.service.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.service.implementation.JumiaUserService;

public class JumiaUserServiceIMPL implements JumiaUserService {




    public JumiaUser mapToJumiaUser(JumiaUserRequest jumiaUserRequest){
        return JumiaUser.builder()
                .userName(jumiaUserRequest.getUserName())
                .emailAddress(jumiaUserRequest.getEmailAddress())
                .phoneNumber(jumiaUserRequest.getPhoneNumber())
                .password(jumiaUserRequest.getPassword())
                .mobileNetwork(jumiaUserRequest.getMobileNetwork())
                .address(jumiaUserRequest.getAddress())
                .build();
    }

    @Override
    public JumiaUser registerNewJumiaUser(JumiaUserRequest jumiaUserRequest) {
        tools.passwordValidate(jumiaUserRequest.getPassword());
        if (jumiaUserRepository.existsByEmailAddress(jumiaUserRequest.getEmailAddress()))
            throw new RegistrationException("email address  " + jumiaUserRequest.getEmailAddress()+"  already exists");
        if (jumiaUserRequest.getPhoneNumber().length() < 11 || jumiaUserRequest.getPhoneNumber().length() > 12 )
            throw new RegistrationException("phone number " + jumiaUserRequest.getPhoneNumber()+" is invalid");

        JumiaUser builderJumiaUser = mapToJumiaUser(jumiaUserRequest);

        return null;
    }
}
