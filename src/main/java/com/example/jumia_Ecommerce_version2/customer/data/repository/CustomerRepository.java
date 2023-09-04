package com.example.jumia_Ecommerce_version2.customer.data.repository;

import com.example.jumia_Ecommerce_version2.customer.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
