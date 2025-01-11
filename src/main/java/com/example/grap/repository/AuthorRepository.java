package com.example.grap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grap.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
