package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}