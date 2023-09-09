package com.example.jumia_Ecommerce_version2.service.interfaces;

import com.example.jumia_Ecommerce_version2.jumiaUser.service.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;

public interface JumiaUserService {

        JumiaUser registerNewUser(JumiaUserRequest jumiaUserRequest);
}
