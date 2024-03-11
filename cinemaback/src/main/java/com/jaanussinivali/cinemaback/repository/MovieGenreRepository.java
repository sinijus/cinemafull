package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieGenreRepository extends JpaRepository<MovieGenre, Integer> {
    @Query("select m from MovieGenre m where m.movie.id = ?1")
    List<MovieGenre> findMovieGenresByMovieId(Integer id);
}