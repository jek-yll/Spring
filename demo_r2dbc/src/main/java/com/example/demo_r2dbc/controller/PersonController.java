package com.example.demo_r2dbc.controller;


import com.example.demo_r2dbc.dao.PersonDAO;
import com.example.demo_r2dbc.entity.Person;
import com.example.demo_r2dbc.repository.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonDAO personDAO;

    public PersonController(PersonRepository personRepository, PersonDAO personDAO) {
        this.personRepository = personRepository;
        this.personDAO = personDAO;
    }

    @PostMapping
    public Mono<Person> post(@RequestBody Person person) {
        //return personDAO.add(person.getFirstname(), person.getLastname());
        return personRepository.save(person);
    }

    @PutMapping("{id}")
    public Mono<Long> put(@RequestBody Person person, @PathVariable("id") int id) {
        return personDAO.update(id, person.getFirstname(), person.getLastname());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> get() {
        //return personDAO.getAll();
        return personRepository.findAll();
    }

    @GetMapping(path = "search/{search}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> search(@PathVariable("search") String search) {
        //return personDAO.getAll();
        return personRepository.customSearch(search);
    }

    @DeleteMapping("{id}")
    public Mono delete(@PathVariable("id") int id) {
        return personDAO.delete(id);
    }
}
