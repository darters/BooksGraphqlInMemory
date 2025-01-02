package com.example.grap.repository;

import com.example.grap.model.Author;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {
    private List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {
        return authors;
    }

    public Author findById(int id) {
        return authors.stream()
            .filter(author -> author.id() == id)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author findByName(String name) {
        return authors.stream()
            .filter(author -> author.fullName().equals(name))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Name wasn't found"));
    }
    @PostConstruct
    private void init() {
        authors.add(new Author(1, "John", "Doe"));        
        authors.add(new Author(2, "Artem", "Savchen"));        
        authors.add(new Author(3, "Mark", "Polo"));        
        authors.add(new Author(4, "Tommy", "Andreson"));        
        authors.add(new Author(5, "Vito", "Scalleta"));        
    }
}
