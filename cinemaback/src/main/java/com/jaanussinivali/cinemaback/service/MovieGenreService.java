package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.MovieGenre;
import com.jaanussinivali.cinemaback.repository.MovieGenreRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreService {
    @Resource
    private MovieGenreRepository movieGenreRepository;
    public List<MovieGenre> findMovieGenresByMovieId(Integer movieId) {
        return movieGenreRepository.findMovieGenresByMovieId(movieId);
    }
}
