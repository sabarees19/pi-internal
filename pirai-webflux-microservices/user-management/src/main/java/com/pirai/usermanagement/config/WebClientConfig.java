package com.pirai.usermanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${pirai.gateWay.url}")
    private String gateWayUrl;

    @Bean
    @LoadBalanced
    public WebClient webClient() {
        return WebClient.builder().baseUrl(gateWayUrl).build();
    }

}
