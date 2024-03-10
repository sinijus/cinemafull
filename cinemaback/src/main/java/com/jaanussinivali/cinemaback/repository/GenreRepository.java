package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}