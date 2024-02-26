package com.example.demo_base.controller;

import com.example.demo_base.exception.CustomException;
import com.example.demo_base.exception.SecondCustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondRestController {

    @GetMapping("/bye") // http://localhost:8080/bye
    public String bye(){
        Integer error = 25 / 0;
        return "Bye !!!";
    }

    @GetMapping("/byebye") // http://localhost:8080/byebye
    public String byebye(){
        if (true){
            throw new CustomException("Oupsy !!!");
        }
        return "Hasta la vista Baby !";
    }

    @GetMapping("/hellothere") // http://localhost:8080/hellothere
    public String helloThere(){
        if (true){
            throw new SecondCustomException("General Kenobi !!!");
        }
        return "Hasta la vista Baby !";
    }

}
