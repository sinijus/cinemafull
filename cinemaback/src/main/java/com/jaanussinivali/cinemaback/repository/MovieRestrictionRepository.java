package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieRestriction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRestrictionRepository extends JpaRepository<MovieRestriction, Integer> {
}