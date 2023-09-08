package com.example.jumia_Ecommerce_version2.productSupplier.data.model;

import com.example.jumia_Ecommerce_version2.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.data.model.Role;
import com.example.jumia_Ecommerce_version2.product.data.model.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ProductSupplier  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
    private JumiaUser jumiaUser;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role = Role.SUPPLIER;
    @OneToMany(mappedBy = "productSupplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final List<Product> listOfProducts = new ArrayList<>();
}
