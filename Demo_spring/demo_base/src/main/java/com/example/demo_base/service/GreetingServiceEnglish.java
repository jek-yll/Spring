package com.example.demo_base.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("greetings")
//@Primary
public class GreetingServiceEnglish implements GreetingService{
    @Override
    public String sayHello() {
        return "Hi everybody !";
    }
}
