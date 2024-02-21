package org.example.tp_blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Email already registered")
public class EmailExistException extends RuntimeException{

    private EmailExistException(String message){
        super(message);
    }
}
