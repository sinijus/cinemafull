package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.exception.DataNotFoundException;
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

    public Movie findMovie(Integer movieId) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isEmpty()) {
            throw new DataNotFoundException(ErrorMessage.MOVIE_NOT_FOUND.getMessage(), ErrorMessage.MOVIE_NOT_FOUND.getErrorCode());
        } else {
            return movieOptional.get();
        }
    }
}
