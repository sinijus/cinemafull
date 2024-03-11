package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}