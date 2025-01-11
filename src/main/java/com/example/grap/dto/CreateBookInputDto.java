package com.example.grap.dto;

import java.util.List;

import com.example.grap.entity.Author;

import lombok.Data;

@Data
public class CreateBookInputDto {
    private String title;
    private int pages;
    private List<Author> authors;
}
