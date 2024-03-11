package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieGenreRepository extends JpaRepository<MovieGenre, Integer> {
    @Query("select m from MovieGenre m where m.movie.id = ?1")
    List<MovieGenre> findMovieGenresByMovieId(Integer id);

    @Query("select m.movie.id from MovieGenre m where m.genre.id = ?1 or ?1 = 0")
    List<Integer> findMovieGenresMovieIdsByGenreId(Integer id);
}