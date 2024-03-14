package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.CinemaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaUserRepository extends JpaRepository<CinemaUser, Integer> {
}