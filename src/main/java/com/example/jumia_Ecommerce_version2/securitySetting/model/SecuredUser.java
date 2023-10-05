package com.example.jumia_Ecommerce_version2.securitySetting.model;

import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
@AllArgsConstructor
public class SecuredUser implements UserDetails {
    private JumiaUser jumiaUser;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(jumiaUser.getRole().getRoleName()));
    }

    @Override
    public String getPassword() {

        return getJumiaUser().getPassword();
    }

    @Override
    public String getUsername() {
        return getJumiaUser().getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
