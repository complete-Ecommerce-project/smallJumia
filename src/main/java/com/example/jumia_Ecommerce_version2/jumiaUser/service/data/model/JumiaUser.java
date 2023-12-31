package com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model;

import com.example.jumia_Ecommerce_version2.data.model.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@MappedSuperclass
public class JumiaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false, unique = true)
    private String emailAddress;
    private String mobileNetwork;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Enumerated(EnumType.STRING)
    private Role role;

}
