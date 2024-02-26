package com.example.demo_base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class DemoController {

    @GetMapping("/bonjour") // http://localhost:8080/bonjour
    public String handleError(){
        Integer error = 12/0;
        return "hello";
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Status : 500 Internal Server Error
    public String handleError2(ArithmeticException ex, Model model){
        model.addAttribute("errorMessage", ex.getMessage());
        return "oups";
    }
}
