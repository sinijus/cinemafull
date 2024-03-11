package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieDirectorRepository extends JpaRepository<MovieDirector, Integer> {
    @Query("select m from MovieDirector m where m.movie.id = ?1")
    List<MovieDirector> findMovieDirectorsByMovieId(Integer id);
}