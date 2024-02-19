package org.example.demo_springdata.service;

import org.example.demo_springdata.entity.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAll();
    Person findById(Long id);
    Person save(Person person);
    Person update(Long id, Person updatePerson);
    Boolean delete(Long id);

}
