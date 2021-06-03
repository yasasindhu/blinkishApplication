package com.luv2code.springboot.cruddemo.rest.customExceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String message) {
        super(message);
    }

    public AuthorNotFoundException(Throwable cause) {
        super(cause);
    }

    public AuthorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
