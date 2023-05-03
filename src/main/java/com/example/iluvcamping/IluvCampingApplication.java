package com.example.iluvcamping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IluvCampingApplication {

    public static void main(String[] args) {
        SpringApplication.run(IluvCampingApplication.class, args);
    }

}
