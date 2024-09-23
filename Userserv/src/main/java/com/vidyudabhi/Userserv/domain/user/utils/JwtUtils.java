package com.vidyudabhi.Userserv.domain.user.utils;

import com.vidyudabhi.Userserv.domain.user.model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtUtils {
    private long EXPIRATION_TIME= 2*60*1000;

    private final SecretKey secretKey;


    public String generateJwtToken(String username, Long userid, Role role){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
        return Jwts.builder().header().add("typ","JWT").and()
                .subject(userid.toString())
                .claim("usr",username)
                .claim("rle",role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }

    public Claims extractClaims(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
    }

    public String extractUsername(String token){
        return extractClaims(token).get("user", String.class);
    }

    public boolean isTokenExpired(String token){
        return extractClaims(token).getExpiration().before(new Date());
    }

    public boolean isTokenValid(String token,String username){
        return (username.equals(extractUsername(token))&& !isTokenExpired(token));
    }
}
