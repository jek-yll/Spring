package com.example.correction_spring_aspect.repository;

import com.example.correction_spring_aspect.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


}
