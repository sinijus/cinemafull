package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.*;
import com.jaanussinivali.cinemaback.mapper.*;
import com.jaanussinivali.cinemaback.model.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
