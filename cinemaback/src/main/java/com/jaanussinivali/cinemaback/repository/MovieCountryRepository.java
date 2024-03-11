package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCountryRepository extends JpaRepository<MovieCountry, Integer> {
}