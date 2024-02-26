package org.example.demo_springdata.dao;

import org.example.demo_springdata.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByIdIs(Long id);
}
