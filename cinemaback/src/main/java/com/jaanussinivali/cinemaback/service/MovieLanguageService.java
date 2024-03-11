package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.MovieLanguage;
import com.jaanussinivali.cinemaback.repository.MovieLanguageRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieLanguageService {
    @Resource
    private MovieLanguageRepository movieLanguageRepository;
    public List<MovieLanguage> findMovieLanguagesByMovieId(Integer movieId) {
        return movieLanguageRepository.findMovieLanguagesByMovieId(movieId);

    }

    public List<Integer> findFilteredLanguagesMovieIds(Integer languageId) {
        return movieLanguageRepository.findMovieLanguagesMovieIdsByLanguageId(languageId);
    }
}
