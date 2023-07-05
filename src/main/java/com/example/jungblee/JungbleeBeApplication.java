package com.example.jungblee;

import com.example.jungblee.global.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class JungbleeBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JungbleeBeApplication.class, args);
    }

}
