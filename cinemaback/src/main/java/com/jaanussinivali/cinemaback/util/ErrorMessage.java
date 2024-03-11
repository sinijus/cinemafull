package com.jaanussinivali.cinemaback.util;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    MOVIE_NOT_FOUND("Could not find Movie by movieId"),
    DIRECTOR_NOT_FOUND("Could not find Director by directorId");

    private final String message;

    ErrorMessage(String message) {

        this.message = message;
    }
}
