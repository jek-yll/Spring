package com.example.demo_base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {

    @ExceptionHandler(ArithmeticException.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Status : 500 Internal Server Error
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Status : 400 Bad Request
    public String handlerArithmeticException(ArithmeticException ex){
        return "Oups nous avons un problème de mathématiques (controler advice)" + ex.getMessage();
    }
}
