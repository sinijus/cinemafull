package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieCountryRepository extends JpaRepository<MovieCountry, Integer> {
    @Query("select m from MovieCountry m where m.movie.id = ?1")
    List<MovieCountry> findMovieCountriesByMovieId(Integer id);
}