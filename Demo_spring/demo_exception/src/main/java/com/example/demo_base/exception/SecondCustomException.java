package com.example.demo_base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = " Problème !!! ")
public class SecondCustomException extends RuntimeException{

    public SecondCustomException(String message){
        super(message);
    }

}
