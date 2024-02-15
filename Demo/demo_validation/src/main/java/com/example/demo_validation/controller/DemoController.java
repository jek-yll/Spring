package com.example.demo_validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/hello")
    public String hello(){
        return "/hello";
    }

//    @GetMapping("/pb")
//    public String pb(){
//        if (true){
//        throw new RuntimeException("Problème");
//        }
//        return "hello";
//    }

}
