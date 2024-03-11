package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
}