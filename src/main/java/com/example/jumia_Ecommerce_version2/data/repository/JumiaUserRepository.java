package com.example.jumia_Ecommerce_version2.data.repository;

import com.example.jumia_Ecommerce_version2.data.model.JumiaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JumiaUserRepository extends JpaRepository<JumiaUser, Long> {
}
