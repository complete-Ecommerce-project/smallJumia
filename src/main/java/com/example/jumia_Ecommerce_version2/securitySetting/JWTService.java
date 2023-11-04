package com.example.jumia_Ecommerce_version2.securitySetting;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTService {
    private final Key key;



    public boolean isTokenValid(String token){

        try{
            final Claims cLaims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJwt(token)
                    .getBody();
            final Date expiration = cLaims.getExpiration();
            return expiration != null && expiration.after(Date.from(Instant.now()));
        }catch (Exception e){
            System.out.println(e.getMessage() +" <-- JWT expiration");
            return false;
        }

    }
    public boolean ifTokenBelongsToUser(String token, UserDetails userDetails){
        return userDetails.getUsername().equalsIgnoreCase(extractUserEmailFromToken(token));
    }
    public String extractUserEmailFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

}
