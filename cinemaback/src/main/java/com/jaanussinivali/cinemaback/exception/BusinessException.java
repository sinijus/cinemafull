package com.jaanussinivali.cinemaback.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private final String message;
    private final  Integer errorCode;

    public BusinessException(String message, int errorCode) {
        super("message");
        this.message = message;
        this.errorCode = errorCode;
    }
}
