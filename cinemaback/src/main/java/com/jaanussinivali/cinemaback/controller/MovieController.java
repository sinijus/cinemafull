package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.dto.*;
import com.jaanussinivali.cinemaback.service.MoviesService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Resource
    private MoviesService moviesService;

    @GetMapping("/countries")
    @Operation(summary = "Leiab kõik riigid.")
    public List<CountryResponse> findAllCountries() {
        return moviesService.findAllCountries();
    }

    @GetMapping("/genres")
    @Operation(summary = "Leiab kõik žanrid.")
    public List<GenreResponse> findAllGenres() {
        return moviesService.findAllGenres();
    }

    @GetMapping("/directors")
    @Operation(summary = "Leiab kõik režissöörid.")
    public List<DirectorResponse> findAllDirectors() {
        return moviesService.findAllDirectors();
    }

    @GetMapping("/languages")
    @Operation(summary = "Leiab kõik keeled")
    public List<LanguageResponse> findAllLanguages() {
        return moviesService.findAllLanguages();
    }

    @GetMapping("/restrictions")
    @Operation(summary = "Leiab kõik piirangud")
    public List<RestrictionResponse> findAllRestrictions() {
        return moviesService.findAllRestrictions();
    }


}
