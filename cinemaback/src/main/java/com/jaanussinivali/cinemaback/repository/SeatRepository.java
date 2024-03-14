package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    @Query("select s from Seat s where s.hall.id = ?1")
    List<Seat> findAllSeatsByHallId(Integer id);
}