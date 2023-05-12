package com.example.iluvcamping.util;

import com.uploadcare.api.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadConfig {

    @Value("${uploadcare.publicKey}")
    private String publicKey;

    @Value("${uploadcare.secretKey}")
    private String secretKey;

    @Bean
    public Client uploadcareClient() {
        return new Client(publicKey, secretKey);
    }

}
