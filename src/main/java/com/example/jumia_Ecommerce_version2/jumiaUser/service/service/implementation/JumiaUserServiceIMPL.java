package com.example.jumia_Ecommerce_version2.jumiaUser.service.service.implementation;

import com.example.jumia_Ecommerce_version2.exception.RegistrationException;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.repository.JumiaUserRepository;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.service.interfaces.JumiaUserService;
import com.example.jumia_Ecommerce_version2.service.implementation.Tools;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional

public class JumiaUserServiceIMPL implements JumiaUserService {
    private final JumiaUserRepository jumiaUserRepository;
    private final Tools tools;


    @Override
    public JumiaUser registerNewJumiaUser(JumiaUserRequest jumiaUserRequest) {
        tools.passwordValidate(jumiaUserRequest.getPassword());
        if (jumiaUserRepository.existsByEmailAddress(jumiaUserRequest.getEmailAddress()))
            throw new RegistrationException("email address  " + jumiaUserRequest.getEmailAddress()+"  already exists");
        if (jumiaUserRequest.getPhoneNumber().length() < 11 || jumiaUserRequest.getPhoneNumber().length() > 12 )
            throw new RegistrationException("phone number " + jumiaUserRequest.getPhoneNumber()+" is not  invalid");
        JumiaUser builderJumiaUser = mapToJumiaUser(jumiaUserRequest);
        return jumiaUserRepository.save(builderJumiaUser);
    }

    public JumiaUser mapToJumiaUser(JumiaUserRequest jumiaUserRequest){
        return JumiaUser.builder()
                .mobileNetwork(tools.networkProvider(jumiaUserRequest.getPhoneNumber()))
                .userName(jumiaUserRequest.getUserName())
                .emailAddress(jumiaUserRequest.getEmailAddress())
                .phoneNumber(jumiaUserRequest.getPhoneNumber())
                .password(jumiaUserRequest.getPassword())
                .mobileNetwork(tools.networkProvider(jumiaUserRequest.getPhoneNumber()))
                .address(jumiaUserRequest.getAddress())
                .build();
    }
}
