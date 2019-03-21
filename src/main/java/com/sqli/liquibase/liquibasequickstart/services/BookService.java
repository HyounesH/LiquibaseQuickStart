package com.sqli.liquibase.liquibasequickstart.services;


import com.sqli.liquibase.liquibasequickstart.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book);
    List<Book> listBooks();
    Book getBookById(Long id);
    void deleteBook(Long id);

}
