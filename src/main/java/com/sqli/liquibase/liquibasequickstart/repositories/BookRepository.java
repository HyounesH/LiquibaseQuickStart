package com.sqli.liquibase.liquibasequickstart.repositories;

import com.sqli.liquibase.liquibasequickstart.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface BookRepository extends CrudRepository<Book,Long> {
    Book getBookById(Long id);
}
