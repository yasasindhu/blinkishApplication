package com.luv2code.springboot.cruddemo.rest.Controller;

import com.luv2code.springboot.cruddemo.entity.Author;
import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.entity.dto.AuthorDto;
import com.luv2code.springboot.cruddemo.entity.dto.BookDto;
import com.luv2code.springboot.cruddemo.rest.customExceptions.BookNotFoundException;
import com.luv2code.springboot.cruddemo.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AuthorRestController {


    @Autowired
    private ModelMapper modelMapper;

    //autowire the AuthorService
    @Autowired
    private AuthorService authorService;

    //add mapping for GET /authors
    @GetMapping("/authors")
    public List<AuthorDto> getAuthor(){
        return authorService.findAll().stream().map(author -> modelMapper.map(author, AuthorDto.class))
                .collect(Collectors.toList());
    }

    //add mapping for GET /authors/{authorId}
    @GetMapping("/authors/{authorId}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable int authorId){
        Author theAuthor=authorService.findById(authorId);
        if(theAuthor==null){
            throw new BookNotFoundException("Author id not found -"+authorId);
        }
        // convert entity to DTO
        AuthorDto authorResponse = modelMapper.map(theAuthor, AuthorDto.class);

        return ResponseEntity.ok().body(authorResponse);
    }

    //add mapping for POST/author -add new Author
    @PostMapping("/authors")
    public ResponseEntity<AuthorDto>  addAuthor(@Valid @RequestBody  AuthorDto theAuthorDto){

        // convert DTO to entity
        Author authorRequest = modelMapper.map(theAuthorDto, Author.class);


        //also just in case the pass an id in JSON ... set id to 0
        //this is force a save of new item ... instead of update
        authorRequest.setId(0);
        Author author = authorService.save(authorRequest);

        // convert entity to DTO
        AuthorDto authorResponse = modelMapper.map(author, AuthorDto.class);

        return new ResponseEntity<AuthorDto>(authorResponse, HttpStatus.CREATED);
    }
    //add mapping for PUT/Books -update existing Book
    @PutMapping("/authors")
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto){

        // convert DTO to Entity
        Author authorRequest = modelMapper.map(authorDto, Author.class);

        int authorId= authorRequest.getId();

        Author tempAuthor=authorService.findById(authorId);
        if(tempAuthor==null){
            throw new BookNotFoundException("Author id not found -"+authorId);
        }
        Author author = authorService.save(authorRequest);

        // entity to DTO
        AuthorDto authorResponse = modelMapper.map(author, AuthorDto.class);

        return ResponseEntity.ok().body(authorResponse);
    }

    //add mapping for DELETE/Books/{BookId} -delete Book
    @DeleteMapping("/authors/{authorId}")
    public String deleteBook(@PathVariable int authorId){

        Author tempAuthor=authorService.findById(authorId);
        if(tempAuthor==null){
            throw new BookNotFoundException("Author id not found -"+authorId);
        }
        authorService.deleteById(authorId);
        return "Deleted Author id- "+authorId;
    }


}
