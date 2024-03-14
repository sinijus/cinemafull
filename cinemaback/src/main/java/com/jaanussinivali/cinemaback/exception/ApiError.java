package com.jaanussinivali.cinemaback.exception;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private Integer errorCode;

}
