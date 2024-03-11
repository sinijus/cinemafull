package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}