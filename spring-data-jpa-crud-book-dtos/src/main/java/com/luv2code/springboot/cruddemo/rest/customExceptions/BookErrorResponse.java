package com.luv2code.springboot.cruddemo.rest.customExceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookErrorResponse {

    private int status;
    private String message;
    private long timeStamp;


    public BookErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

}
