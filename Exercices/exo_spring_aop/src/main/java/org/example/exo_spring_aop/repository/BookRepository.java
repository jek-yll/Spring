package org.example.exo_spring_aop.repository;

import org.example.exo_spring_aop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIdIs(Long id);
}
