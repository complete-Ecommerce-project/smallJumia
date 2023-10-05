package com.example.jumia_Ecommerce_version2.securitySetting;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@Configuration
public class SecurityBeans {

    @Value("${SECURITY_SECRET_KEY}")
    private String JWT_SECRET_KEY;
    @Bean
    public Key key(){
        return new SecretKeySpec(JWT_SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();    }

}
