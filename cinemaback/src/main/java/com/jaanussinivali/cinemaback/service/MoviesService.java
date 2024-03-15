package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.*;
import com.jaanussinivali.cinemaback.mapper.*;
import com.jaanussinivali.cinemaback.model.*;
import com.jaanussinivali.cinemaback.util.MovieGenreRecommender;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class MoviesService {
    @Resource
    private CountryService countryService;
    @Resource
    private GenreService genreService;
    @Resource
    private DirectorService directorService;
    @Resource
    private LanguageService languageService;
    @Resource
    private RestrictionService restrictionService;

    @Resource
    private CountryMapper countryMapper;
    @Resource
    private GenreMapper genreMapper;
    @Resource
    private DirectorMapper directorMapper;

    @Resource
    private LanguageMapper languageMapper;
    @Resource
    private RestrictionMapper restrictionMapper;


    public List<CountryResponse> findAllCountries() {
        List<Country> countries = countryService.findAllCountries();
        return countryMapper.toCountriesResponse(countries);
    }

    public List<GenreResponse> findAllGenres() {
        List<Genre> genres = genreService.findAllGenres();
        return genreMapper.toGenresResponse(genres);
    }

    public List<DirectorResponse> findAllDirectors() {
        List<Director> directors = directorService.findAllDirectors();
        return directorMapper.toDirectorsResponse(directors);

    }

    public List<LanguageResponse> findAllLanguages() {
        List<Language> languages = languageService.findAllLanguages();
        return languageMapper.toLanguagesResponse(languages);

    }

    public List<RestrictionResponse> findAllRestrictions() {
        List<Restriction> restrictions = restrictionService.findAllRestrictions();
        return restrictionMapper.toRestrictionsResponse(restrictions);
    }

    public void recommendMovies(List<String> movieGenres) {
        validateMovieGenres(movieGenres);
        if (movieGenres.size() == 0) {
            //TODO recommend three random movies
        } else {
            HashMap<String, Integer> genreWordWeights = MovieGenreRecommender.genreWordWeights(movieGenres);
        }
    }

    private void validateMovieGenres(List<String> movieGenres) {
        List<GenreResponse> genres = findAllGenres();
        for (int i = 0; i < movieGenres.size(); i++) {
            boolean removeItem = true;
            for (GenreResponse genre : genres) {
                if (Objects.equals(movieGenres.get(i), genre.getName())) {
                    removeItem = false;
                    break;
                }
            }
            if (removeItem) {
                movieGenres.remove(i);
            }
        }
    }
}
