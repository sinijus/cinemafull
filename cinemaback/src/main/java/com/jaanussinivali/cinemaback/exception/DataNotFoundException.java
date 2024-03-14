package com.jaanussinivali.cinemaback.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataNotFoundException extends RuntimeException {
    private final String message;
    private final  Integer errorCode;

    public DataNotFoundException(String message, int errorCode) {
        super("message");
        this.message = message;
        this.errorCode = errorCode;
    }
}
