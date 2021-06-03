package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> findAll();

    public Author findById(int theId);

    public Author save(Author theAuthor);

    public void deleteById(int theId);
}
