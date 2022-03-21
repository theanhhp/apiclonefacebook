package com.Theanh.apiclonefacebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiCloneFacebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCloneFacebookApplication.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
