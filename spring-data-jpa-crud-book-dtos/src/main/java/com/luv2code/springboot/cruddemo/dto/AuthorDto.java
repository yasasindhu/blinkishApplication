package com.luv2code.springboot.cruddemo.dto;

import com.luv2code.springboot.cruddemo.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {

    private int id;
    private String firstName;
    private String lastName;
    private List<Book> book;
}
