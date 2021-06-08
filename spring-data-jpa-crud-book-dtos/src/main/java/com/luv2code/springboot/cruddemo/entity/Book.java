package com.luv2code.springboot.cruddemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="book")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    @NotBlank(message = "Title may not be blank")
    private String title;

    @Column(name="author_id")
    @NotNull(message= "AuthorId field may not be blank")
    private int authorId;

    @Column(name="description")
    private String description;

    @Column(name="category")
    @NotBlank(message = "category may not be blank")
    private String category;


}
