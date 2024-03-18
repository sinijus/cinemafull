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

    public List<Integer> findFilteredGenresMovieIds(Integer genreId) {
        return movieGenreRepository.findMovieGenresMovieIdsByGenreId(genreId);
    }

    public List<Integer> findMovieIdsByCombinationOfGenreNames(String genreOneName, String genreTwoName, String genreThreeName) {
        return movieGenreRepository.findMovieIdsByCombinationOfGenreNames(genreOneName, genreTwoName, genreThreeName);
    }

    public List<String> findMovieGenreNamesByMovieId(Integer movieId) {
        return movieGenreRepository.findMovieGenreNamesByMovieId(movieId);

    }
}
