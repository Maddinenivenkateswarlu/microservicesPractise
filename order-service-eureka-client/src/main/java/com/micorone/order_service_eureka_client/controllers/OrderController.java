package com.micorone.order_service_eureka_client.controllers;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class OrderController {

    private  static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private WebClient webClient;
    @GetMapping("/orderName")
    public String gerOrderUserName() {
        return  "hello venkat";
    }

    @GetMapping("/fromorders/users")
    public Mono getUserFromOrders() {
        return   webClient.get().uri("http://localhost:8080/users").retrieve().bodyToMono(Object.class);
    }

    @GetMapping("/client-users")
    @CircuitBreaker(name="usermsclient", fallbackMethod = "usermsfallback")
    public Mono getUsersFromUserms() {
        LOGGER.info("About to call userms from orderms");
        return webClient.get().uri("/users").retrieve().bodyToMono(Object.class);
    }

    private Mono usermsfallback(CallNotPermittedException ex) {
        LOGGER.error("fallback invoked");
        return Mono.just("CalledFromCache");
    }
}
