package com.example.jumia_Ecommerce_version2.customer.data.model;

import com.example.jumia_Ecommerce_version2.cart.data.data.model.Cart;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.data.model.Role;
import jakarta.persistence.*;
@Entity
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private JumiaUser user;

}
