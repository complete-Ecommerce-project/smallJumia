package com.example.jumia_Ecommerce_version2.jumiaUser.service.data.repository;

import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JumiaUserRepository extends JpaRepository<JumiaUser, Long> {
    boolean existsByEmailAddress(String emailAddress);
    boolean existsByUserName(String username);
}
