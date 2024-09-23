package com.vidyudabhi.Userserv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class SecretKeyProvider {

    @Bean
    public SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        keyGenerator.init(256,new SecureRandom());
        return keyGenerator.generateKey();
    }
//    @Bean
//    public SecretKey generateSecretKeyNew() throws NoSuchAlgorithmException {
//        byte[] decodedKey = Base64.getDecoder().decode("AbcSdtjkm989ijiejjefjifijgjoojj+ihif/8l+/");
//
//        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
//    }
}
