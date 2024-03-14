package com.jaanussinivali.cinemaback.util;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    MOVIE_NOT_FOUND("Could not find Movie by movieId", 110),
    SCREENING_NOT_FOUND("Could not find Screening by screeningId", 111),
    DIRECTOR_NOT_FOUND("Could not find Director by directorId", 112),
    USER_NOT_FOUND("Could not find User by userId", 113),
    HALL_NOT_FOUND("Could not find Hall by hallId", 114);

    private final String message;
    private final int errorCode;

    ErrorMessage(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
