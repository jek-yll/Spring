package org.example.demo_springdata.service;

import org.example.demo_springdata.dao.PersonRepository;
import org.example.demo_springdata.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.getReferenceById(id);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Long id, Person updatePerson) {
        Person person = personRepository.getReferenceById(id);
        person.setEmail(updatePerson.getEmail());
        person.setFirstName(updatePerson.getFirstName());
        person.setLastName(updatePerson.getLastName());
        return personRepository.save(person);

    }

    @Override
    public Boolean delete(Long id) {
        Person personDelete = personRepository.getReferenceById(id);
        personRepository.delete(personDelete);
        return true;
    }


}
