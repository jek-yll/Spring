package com.example.demo_base.service;

import org.springframework.stereotype.Service;

@Service("salutations")

public class GreetingServiceFrench implements GreetingService{
    @Override
    public String sayHello() {
        return "Bonjour tous le monde !";
    }
}
