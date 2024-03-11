package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.exception.MovieNotFoundException;
import com.jaanussinivali.cinemaback.model.Movie;
import com.jaanussinivali.cinemaback.repository.MovieRepository;
import com.jaanussinivali.cinemaback.util.ErrorMessage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class MovieService {

    @Resource
    private MovieRepository movieRepository;

    public Movie findMovieById(Integer movieId) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isEmpty()) {
            throw new MovieNotFoundException(ErrorMessage.MOVIE_NOT_FOUND.getMessage());
        } else {
            return movieOptional.get();
        }
    }
}
