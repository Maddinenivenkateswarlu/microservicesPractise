package com.micorone.order_service_eureka_client.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


//    @Bean
//    public WebClient buildWebClient() {
//        return WebClient.builder().build();
//    }

    @Bean
    @LoadBalanced // client-side load balancing
    public WebClient.Builder builder() {
        return WebClient.builder().baseUrl("http://sampleone");
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}

