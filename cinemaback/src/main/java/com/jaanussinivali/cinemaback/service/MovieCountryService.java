package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.MovieCountry;
import com.jaanussinivali.cinemaback.repository.MovieCountryRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCountryService {

    @Resource
    private MovieCountryRepository movieCountryRepository;
    public List<MovieCountry> findMovieCountriesByMovieId(Integer movieId) {
        return movieCountryRepository.findMovieCountriesByMovieId(movieId);
    }
}
