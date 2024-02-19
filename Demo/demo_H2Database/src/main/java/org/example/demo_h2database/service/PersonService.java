package org.example.demo_h2database.service;

import org.example.demo_h2database.mapper.PersonMapper;
import org.example.demo_h2database.model.PersonDTO;
import org.example.demo_h2database.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final IPersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(IPersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> listPersons(){
        return personRepository.findAll().stream()
                .map(personMapper::personToPersonDto)
                //.map(person -> personMapper.personToPersonDto(person))
                .toList();
    }

    public PersonDTO addPerson(PersonDTO personDTO){
//        Person person = personMapper.PersonDtoToPerson(personDTO);
//        Person personSave = personRepository.save(person);
//        PersonDTO savedDto = personMapper.personToPersonDto(personSave);
//        return savedDto;
        return personMapper.personToPersonDto(personRepository.save(personMapper.PersonDtoToPerson(personDTO)));
    }
}
