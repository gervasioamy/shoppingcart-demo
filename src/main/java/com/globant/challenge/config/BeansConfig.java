package com.globant.challenge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * @author gervasio.amy
 */
@Configuration
public class BeansConfig {

    @Bean
    @Autowired
    public RestTemplate restTeamplate(ResponseErrorHandler responseErrorHandler) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(responseErrorHandler);
        return restTemplate;
    }
}

