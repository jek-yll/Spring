package org.example.demo_springdata.controler;

import lombok.AllArgsConstructor;
import org.example.demo_springdata.entity.Person;
import org.example.demo_springdata.service.IPersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonRestController {

    private final IPersonService personService;

    @GetMapping("/list") // localhost:8080/list
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/person/{id}") // localhost:8080/person/*
    public Person findById(@PathVariable Long id){
        // System.out.println(id);
        // System.out.println(personService.findById(id));
        // return personService.findById(id);
        return personService.findById(id);
    }

//    @GetMapping("/add")
//    public Person add(){
//        Person person = Person.builder()
//                .email("test@mail.test")
//                .firstName("toto")
//                .lastName("toto")
//                .build();
//        personService.save(person);
//        return person;
//    }

    @PostMapping("/add") // localhost:8080/add
    public Person addPerson(@RequestBody Person person){
        return personService.save(person);
    }

    @DeleteMapping("/delete/{id}") // localhost:8080/delete/*
    public Boolean deletePerson(@PathVariable Long id){
        return personService.delete(id);
    }

    @PutMapping("/update/{id}") // localhost:8080/update/*
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person){
        return personService.update(id, person);
    }

}
