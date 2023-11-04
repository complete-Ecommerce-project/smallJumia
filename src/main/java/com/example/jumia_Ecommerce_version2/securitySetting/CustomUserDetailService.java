package com.example.jumia_Ecommerce_version2.securitySetting;

import com.example.jumia_Ecommerce_version2.exception.JumiaUserException;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.model.JumiaUser;
import com.example.jumia_Ecommerce_version2.jumiaUser.service.data.repository.JumiaUserRepository;
import com.example.jumia_Ecommerce_version2.securitySetting.model.SecuredUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
private final JumiaUserRepository jumiaUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       JumiaUser jumiaUser = null;
       try {
       jumiaUser =    jumiaUserRepository.findByEmailAddress(username);
       }catch (Exception e){
           System.out.println(e.getMessage());
           throw new JumiaUserException("Could not find user with the email ->" + username);
       }
        return new SecuredUser(jumiaUser);
    }
}
