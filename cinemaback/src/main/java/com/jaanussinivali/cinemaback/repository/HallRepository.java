package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Integer> {
}