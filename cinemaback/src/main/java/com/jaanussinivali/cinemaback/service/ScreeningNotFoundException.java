package com.jaanussinivali.cinemaback.service;

public class ScreeningNotFoundException extends RuntimeException {
    public ScreeningNotFoundException(String message) {
        super(message);
    }
}
