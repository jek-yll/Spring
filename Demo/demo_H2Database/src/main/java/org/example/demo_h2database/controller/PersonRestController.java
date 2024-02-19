package org.example.demo_h2database.controller;

import org.example.demo_h2database.entity.Person;
import org.example.demo_h2database.model.PersonDTO;
import org.example.demo_h2database.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService personService;
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public List<PersonDTO> getAllPersons(){
        return personService.listPersons();
    }

    @PostMapping("/add")
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO){
        return personService.addPerson(personDTO);
    }
}
