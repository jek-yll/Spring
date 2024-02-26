package com.example.demo_base.controller;

import com.example.demo_base.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//@RestControllerAdvice
@ControllerAdvice
public class ExceptionRestController {

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Status : 500 Internal Server Error
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Status : 400 Bad Request
    public String handlerArithmeticException(ArithmeticException ex){
        return "Oups nous avons un problème de mathématiques (controller advice)" + ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Status : 418 I'm a teapot (RFC 2324)
    public String handlerCustomException(CustomException ex){
        return ex.getMessage();
    }
}
