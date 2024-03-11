package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieLanguageRepository extends JpaRepository<MovieLanguage, Integer> {
}