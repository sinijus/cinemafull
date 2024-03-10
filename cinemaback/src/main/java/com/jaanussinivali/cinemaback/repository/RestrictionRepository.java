package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestrictionRepository extends JpaRepository<Restriction, Integer> {
}