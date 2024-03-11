package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRestrictionRepository extends JpaRepository<MovieRestriction, Integer> {
    @Query("select m from MovieRestriction m where m.movie.id = ?1")
    List<MovieRestriction> findMovieRestrictionsByMovieId(Integer id);

    @Query("select m.movie.id from MovieRestriction m where m.restriction.id = ?1 or ?1 = 0")
    List<Integer> findMovieRestrictionsMovieIdsByRestrictionId(Integer id);
}