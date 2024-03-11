package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.ScreeningResponse;
import com.jaanussinivali.cinemaback.mapper.ScreeningMapper;
import com.jaanussinivali.cinemaback.model.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

            List<MovieDirector> movieDirectors = movieDirectorService.findMovieDirectorsByMovieId(movieId);
            List<Director> directors = new ArrayList<>();
            for (MovieDirector movieDirector : movieDirectors) {
                directors.add(movieDirector.getDirector());
            }

            List<MovieGenre> movieGenres = movieGenreService.findMovieGenresByMovieId(movieId);
            List<Genre> genres = new ArrayList<>();
            for (MovieGenre movieGenre : movieGenres) {
                genres.add(movieGenre.getGenre());
            }

            List<MovieLanguage> movieLanguages = movieLanguageService.findMovieLanguagesByMovieId(movieId);
            List<Language> languages = new ArrayList<>();
            for (MovieLanguage movieLanguage : movieLanguages) {
                languages.add(movieLanguage.getLanguage());
            }

            List<MovieRestriction> movieRestrictions = movieRestrictionService.findMovieRestrictionsByMovieId(movieId);
            List<Restriction> restrictions = new ArrayList<>();
            for (MovieRestriction movieRestriction : movieRestrictions) {
                restrictions.add(movieRestriction.getRestriction());
            }
        }

    }
}
