package org.example.exo_spring_aop.service;

import org.example.exo_spring_aop.annotation.LoggerAnnotation;
import org.example.exo_spring_aop.annotation.PerformAnnotation;
import org.example.exo_spring_aop.entity.Book;
import org.example.exo_spring_aop.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@LoggerAnnotation
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    @PerformAnnotation
    public Book addBook(Book book){
        //System.out.println("method : addBook method");
        return bookRepository.save(book);
    }

    @PerformAnnotation
    public Boolean deleteBook(Long id){
        //System.out.println("method : deleteBook method");
        bookRepository.deleteById(id);
        return true;
    }

    @PerformAnnotation
    public Book getBook(Long id){
        //System.out.println("method : getBook method");
        return bookRepository.findByIdIs(id);
    }

    @PerformAnnotation
    public List<Book> getBooks(){
        //System.out.println("method : getBooks method");
        return bookRepository.findAll();
    }
}
