package com.example.jumia_Ecommerce_version2.jumiaDropOffWareHouse.data.model;

import com.example.jumia_Ecommerce_version2.data.model.Address;
import com.example.jumia_Ecommerce_version2.product.data.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @OneToOne(orphanRemoval = true)
    private Address wareHouseAddress;
    private LocalDateTime lastUpdate;
    private boolean loggedIn;
    private LocalDateTime createTime;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String wareHouseName;
    @OneToMany(mappedBy = "wareHouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final List<Product> listOfProducts = new ArrayList<>();
}
