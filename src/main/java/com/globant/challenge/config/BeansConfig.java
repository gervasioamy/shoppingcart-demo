package com.globant.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by gamy on 5/2/17.
 */
@Configuration
public class BeansConfig {

    @Bean
    public RestTemplate restTeamplate() {
        return new RestTemplate();
    }
}
