package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}