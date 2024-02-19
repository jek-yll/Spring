package com.example.demo_base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = " Problème !!! ")
public class CustomException extends RuntimeException{

    public CustomException(String message){
        super(message);
    }

}
