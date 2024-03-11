package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.ScreeningResponse;
import com.jaanussinivali.cinemaback.mapper.ScreeningMapper;
import com.jaanussinivali.cinemaback.model.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScreeningsService {

    @Resource
    private ScreeningService screeningService;

    @Resource
    private MovieService movieService;

    @Resource
    private MovieDirectorService movieDirectorService;

    @Resource
    private MovieGenreService movieGenreService;

    @Resource
    private MovieLanguageService movieLanguageService;

    @Resource
    private MovieRestrictionService movieRestrictionService;




    @Resource
    private DirectorService directorService;

    @Resource
    private GenreService genreService;

    @Resource
    private LanguageService languageService;

    @Resource
    private RestrictionService restrictionService;

    @Resource
    private ScreeningMapper screeningMapper;


    public void findAllMovieScreenings() {
        List<ScreeningResponse> screeningsResponse = new ArrayList<>();
        List<Screening> screenings = screeningService.findAllScreenings();
        for (Screening screening : screenings) {
            ScreeningResponse screeningResponse = new ScreeningResponse();
            Integer movieId = screening.getMovie().getId();

            Movie movie = movieService.findMovieById(movieId);

            List<MovieDirector> movieDirectors = movieDirectorService.findDirectorsByMovieId(movieId);
            List<Director> directors = new ArrayList<>();
            for (MovieDirector movieDirector : movieDirectors) {
                Director director = directorService.findDirectorById(movieDirector.getDirector().getId());
                directors.add(director);
            }






        }

    }
}
