package com.example.grap.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.grap.model.Book;
import com.example.grap.model.Rating;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    @Autowired
    private AuthorRepository authorRepository;
    private List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }
    public Book findOne(Integer id) {
        return books.stream()
            .filter(book -> book.id() == id)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Book wasn't found"));
    }
    
    @PostConstruct
    private void init() {
        books.add(new Book(1, "Atomic Habits", 333, Rating.FOUR_STARS, authorRepository.findByName("John Doe")));
        books.add(new Book(2, "Keyboard", 120, Rating.FIVE_STARS, authorRepository.findByName("Artem Savchen")));
        books.add(new Book(3, "Clean brain", 240, Rating.ONE_STAR, authorRepository.findByName("Mark Polo")));
        books.add(new Book(4, "Deny Decline Delay", 164, Rating.THREE_STARS, authorRepository.findByName("Tommy Andreson")));
        books.add(new Book(5, "How don't die in lonely", 320, Rating.THREE_STARS, authorRepository.findByName("Vito Scalleta")));
    }
}

