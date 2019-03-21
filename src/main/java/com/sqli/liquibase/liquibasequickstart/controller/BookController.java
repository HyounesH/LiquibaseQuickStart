package com.sqli.liquibase.liquibasequickstart.controller;

import com.sqli.liquibase.liquibasequickstart.model.Book;
import com.sqli.liquibase.liquibasequickstart.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody  Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }
    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(book));
    }
    @GetMapping("books")
    public ResponseEntity<List<Book>> listBooks() {
        return ResponseEntity.ok(bookService.listBooks());
    }
    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book= bookService.getBookById(id);
        if(book!=null) ResponseEntity.ok(book);
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        try{
            return ResponseEntity.ok().build();
        }catch(ResourceNotFoundException ex){
         return ResponseEntity.badRequest().build();
        }
    }
}
