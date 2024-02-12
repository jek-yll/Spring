package com.example.demo_base.controller;

import com.example.demo_base.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerSet {

    // Injection de dépendance
    private final GreetingService greetingService;

    @Autowired
    public HelloControllerSet(@Qualifier("salutations") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping(value = "hello-set")
    public String sayHello(){
        System.out.println(greetingService.sayHello());

        return "home";
    }

}
