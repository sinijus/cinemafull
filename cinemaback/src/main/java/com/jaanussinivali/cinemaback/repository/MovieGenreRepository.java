package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreRepository extends JpaRepository<MovieGenre, Integer> {
}