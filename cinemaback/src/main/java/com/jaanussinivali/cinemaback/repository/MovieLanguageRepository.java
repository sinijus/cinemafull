package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieLanguageRepository extends JpaRepository<MovieLanguage, Integer> {
    @Query("select m from MovieLanguage m where m.movie.id = ?1")
    List<MovieLanguage> findMovieLanguagesByMovieId(Integer id);

    @Query("select m.movie.id from MovieLanguage m where m.language.id = ?1 or ?1 = 0")
    List<Integer> findMovieLanguagesMovieIdsByLanguageId(Integer id);
}