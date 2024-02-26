package org.example.demo_h2database.mapper;

import org.example.demo_h2database.entity.Person;
import org.example.demo_h2database.model.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source = "firstName", target = "blabla")
    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    PersonDTO personToPersonDto(Person person);

    @Mapping(source = "blabla", target = "firstName")
    Person PersonDtoToPerson(PersonDTO personDTO);

    @Named("convertDateToAge")
    public static Integer convertDateToAge(LocalDate date){
        LocalDate now = LocalDate.now();
        Integer age = now.getYear() - date.getYear();

        if (now.minusYears(age).isBefore(date)){
            age--;
        }
        return age;
    }

}
