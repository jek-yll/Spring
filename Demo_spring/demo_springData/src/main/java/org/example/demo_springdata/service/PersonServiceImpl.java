package org.example.demo_springdata.service;

import org.example.demo_springdata.dao.PersonRepository;
import org.example.demo_springdata.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return personRepository.findByIdIs(id);
    }

    public Person findByIdOptionnal(Long id){
        Optional<Person> result = personRepository.findById(id);
        return result.orElse(null);
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
        personRepository.deleteById(id);
        return true;
    }


}
