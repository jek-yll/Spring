package org.example.demo_h2database.repository;

import org.example.demo_h2database.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IPersonRepository extends JpaRepository<Person, UUID> {
    List<Person> findAllByFirstNameStartingWith(String value);
    Long countAllByFirstNameStartingWith(String value);
}
