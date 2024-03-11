package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.ReservedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Integer> {
}