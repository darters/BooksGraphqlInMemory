package com.example.grap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grap.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
