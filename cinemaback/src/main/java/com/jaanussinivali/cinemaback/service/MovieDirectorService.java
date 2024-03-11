package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.MovieDirector;
import com.jaanussinivali.cinemaback.repository.MovieDirectorRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDirectorService {
    @Resource
    private MovieDirectorRepository movieDirectorRepository;
    public List<MovieDirector> findMovieDirectorsByMovieId(Integer movieId) {
        return movieDirectorRepository.findMovieDirectorsByMovieId(movieId);
    }
}
