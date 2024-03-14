package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.ReservedSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Integer> {
    @Query("select r from ReservedSeat r where r.screening.id = ?1")
    List<ReservedSeat> findAllReservedSeatsByScreeningId(Integer id);
}