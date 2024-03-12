package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieSubtitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieSubtitleRepository extends JpaRepository<MovieSubtitle, Integer> {
    @Query("select m from MovieSubtitle m where m.movie.id = ?1")
    List<MovieSubtitle> findMovieSubtitlesByMovieId(Integer id);
}