package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.MovieSubtitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieSubtitleRepository extends JpaRepository<MovieSubtitle, Integer> {
}