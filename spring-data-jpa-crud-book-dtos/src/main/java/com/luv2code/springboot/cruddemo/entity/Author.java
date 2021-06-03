package com.luv2code.springboot.cruddemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="author")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    @NotBlank(message = "Firstname  may not be blank")
    private String firstName;

    @Column(name="last_name")
    @NotBlank(message = "Lastname field may not be blank")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="author_id")
    private List<Book> book;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void addBook(Book thebook){
        if(book==null){
            book=new ArrayList<>();
        }
        book.add(thebook);
    }

}
