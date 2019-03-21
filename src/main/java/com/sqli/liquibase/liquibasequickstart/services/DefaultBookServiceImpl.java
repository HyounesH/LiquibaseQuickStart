package com.sqli.liquibase.liquibasequickstart.services;

import com.sqli.liquibase.liquibasequickstart.model.Book;
import com.sqli.liquibase.liquibasequickstart.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultBookServiceImpl implements  BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> listBooks() {
        List<Book> books=new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book getBookById(Long id) {
      Optional<Book> book= bookRepository.findById(id);
      return book.orElse(null);
    }

    @Override
    public void deleteBook(Long id) {
     bookRepository.deleteById(id);
    }
}
