package com.example.demo_validation.controller;

import com.example.demo_validation.model.Contact;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestControler {

    @GetMapping("/contact")
    public Contact getOneContact(){
        return Contact.builder().firstName("toto").lastName("tata").age(18).build();
    }

    @PostMapping("/contact")
    public ResponseEntity<String> postContact(@Valid @RequestBody Contact contact, BindingResult result){
        if (result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Contact ok", HttpStatus.CREATED);
    }
}
