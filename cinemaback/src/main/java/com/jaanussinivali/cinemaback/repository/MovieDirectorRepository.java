package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDirectorRepository extends JpaRepository<MovieDirector, Integer> {
}