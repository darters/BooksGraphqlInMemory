package com.example.grap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.grap.model.Book;
import com.example.grap.repository.BookRepository;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // @SchemaMapping(typeName = "Query", value = "allBooks")
    @QueryMapping
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    @QueryMapping
    public Book findOne(@Argument Integer id) {
        return bookRepository.findOne(id);
    }
}

