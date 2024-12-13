package com.microservicesapigateway.api_gateway.conrollers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String textEndpoint(){
        return "hello world!";
    }
}
