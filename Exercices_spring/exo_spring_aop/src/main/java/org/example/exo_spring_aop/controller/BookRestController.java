package org.example.exo_spring_aop.controller;

import org.example.exo_spring_aop.entity.Book;
import org.example.exo_spring_aop.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {

    private final BookService bookService;


    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.getBooks();
    }


    @GetMapping("/book/{id}") // localhost:8080/book/*
    public Book findById(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PostMapping("/book")  // localhost:8080/book
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/book/{id}") // localhost:8080/book/*
    public Boolean deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}
