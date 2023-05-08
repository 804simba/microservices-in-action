package com.simba.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigurations {

    @Bean
    @LoadBalanced // configures the RestTemplate to load balance each request.
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
