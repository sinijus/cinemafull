package com.jaanussinivali.cinemaback.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaUserRepository extends JpaRepository<CinemaUser, Integer> {
}