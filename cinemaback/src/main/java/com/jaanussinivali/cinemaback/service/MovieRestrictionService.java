package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.MovieRestriction;
import com.jaanussinivali.cinemaback.repository.MovieRestrictionRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieRestrictionService {
    @Resource
    private MovieRestrictionRepository movieRestrictionRepository;
    public List<MovieRestriction> findMovieRestrictionsByMovieId(Integer movieId) {
        return movieRestrictionRepository.findMovieRestrictionsByMovieId(movieId);
    }
}
