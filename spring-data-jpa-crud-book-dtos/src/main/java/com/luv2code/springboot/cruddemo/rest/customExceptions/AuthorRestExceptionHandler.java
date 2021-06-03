package com.luv2code.springboot.cruddemo.rest.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AuthorRestExceptionHandler {

    //Add an exception handler for AuthorNotFoundException
    @ExceptionHandler
    public ResponseEntity<AuthorErrorResponse> handleException(AuthorNotFoundException exc){
        //create BookErrorResponse
        AuthorErrorResponse error=new AuthorErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    //Add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<AuthorErrorResponse> handleException(Exception exc){

        //create BookErrorResponse
        AuthorErrorResponse error=new AuthorErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
