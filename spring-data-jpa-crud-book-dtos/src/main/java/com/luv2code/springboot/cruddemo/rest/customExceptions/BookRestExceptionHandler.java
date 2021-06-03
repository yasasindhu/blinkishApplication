package com.luv2code.springboot.cruddemo.rest.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookRestExceptionHandler {

    //Add an exception handler for BookNotFoundException
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException exc){

        //create BookErrorResponse
        BookErrorResponse error=new BookErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(Exception exc){

        //create BookErrorResponse
        BookErrorResponse error=new BookErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
