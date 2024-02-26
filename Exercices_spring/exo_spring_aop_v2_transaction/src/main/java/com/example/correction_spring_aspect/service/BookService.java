package com.example.correction_spring_aspect.service;

import com.example.correction_spring_aspect.annotation.Log;
import com.example.correction_spring_aspect.annotation.Performance;
import com.example.correction_spring_aspect.entity.Author;
import com.example.correction_spring_aspect.entity.Book;
import com.example.correction_spring_aspect.repository.AuthorRepository;
import com.example.correction_spring_aspect.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Performance
    public Book save(String name, Author author) {
        Book book = new Book();

        book.setName(name);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Performance
    @Log
    public Book findBookById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        throw new RuntimeException("Not found");
    }

    @Log
    public List<Book> findAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books;
    }

    public Author save(String firstname, String lastname) {
        Author author = new Author();

        author.setFirstname(firstname);
        author.setLastname(lastname);
        return authorRepository.save(author);
    }

    public Author findAuthorById(long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isPresent()){
            return optionalAuthor.get();
        }
        throw new RuntimeException("Not found");
    }

    public Optional<Book> updateBookWithAuthor(long idBook, Author author){
        Optional<Book> optionalBook = bookRepository.findById(idBook);
        if (optionalBook.isPresent()){
            optionalBook.orElseThrow().setAuthor(author);
        }
        return optionalBook;
    }
}
