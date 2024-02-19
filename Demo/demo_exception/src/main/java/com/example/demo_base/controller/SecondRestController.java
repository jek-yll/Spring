package com.example.demo_base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondRestController {

    @GetMapping("/bye") // http://localhost:8080/bye
    public String bye(){
        Integer error = 25 / 0;
        return "Bye !!!";
    }

}
