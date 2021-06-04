package com.luv2code.springboot.cruddemo.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    //Add an exception handler for BookNotFoundException
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exc){

        //create ErrorResponse
        ErrorResponse error=new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc){

        //create ErrorResponse
        ErrorResponse error=new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
