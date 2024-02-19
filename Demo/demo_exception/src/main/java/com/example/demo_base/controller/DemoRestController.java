package com.example.demo_base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @GetMapping("/hello") // http://localhost:8080/hello
    public String hello(){
        Integer error = 25 / 0;
        return "hello !!!";
    }

    @ExceptionHandler(ArithmeticException.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Status : 500 Internal Server Error
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Status : 400 Bad Request
    public String handlerArithmeticException(ArithmeticException ex){
        return "Oups nous avons un problème de mathématiques " + ex.getMessage();
    }
}
