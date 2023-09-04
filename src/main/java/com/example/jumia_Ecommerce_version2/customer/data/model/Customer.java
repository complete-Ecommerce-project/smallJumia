package com.example.jumia_Ecommerce_version2.customer.data.model;

import com.example.jumia_Ecommerce_version2.cart.data.data.model.Cart;
import com.example.jumia_Ecommerce_version2.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.data.model.Role;
import jakarta.persistence.*;
@Entity
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Cart cart;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private JumiaUser user;

}
