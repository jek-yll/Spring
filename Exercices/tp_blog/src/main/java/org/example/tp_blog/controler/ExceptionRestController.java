package org.example.tp_blog.controler;

import org.example.tp_blog.exception.EmailExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionRestController {

    @ResponseBody
    @ExceptionHandler(EmailExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerEmailExistException(EmailExistException ex){
        return ex.getMessage();
    }
}
