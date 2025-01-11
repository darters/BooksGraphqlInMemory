package com.example.grap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.grap.dto.CreateBookInputDto;
import com.example.grap.entity.Book;
import com.example.grap.repository.BookRepository;

@Controller
@RequestMapping("library")
public class LibraryController {
    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    public Optional<Book> getBookById(@Argument Integer id) {
        return bookRepository.findById(id);
    }
    @QueryMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @MutationMapping
    public Book createBook(@Argument CreateBookInputDto createBookInputDto) {
        Book book = Book.builder()
            .title(createBookInputDto.getTitle())
            .pages(createBookInputDto.getPages())
            .authors(createBookInputDto.getAuthors())
            .build();
        return bookRepository.save(book);
    }
}
