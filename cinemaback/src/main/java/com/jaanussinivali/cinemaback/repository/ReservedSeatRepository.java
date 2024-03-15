package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.ReservedSeat;
import com.jaanussinivali.cinemaback.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Integer> {
    @Query("select r from ReservedSeat r where r.screening.id = ?1")
    List<ReservedSeat> findAllReservedSeatsByScreeningId(Integer id);

    @Query("select r from ReservedSeat r where r.screening.id = ?1 and r.reservation.id = ?2 and r.reservation.active = ?3 ")
    List<ReservedSeat> findActiveReservedSeatsByScreeningIdAndReservationId(Integer screeningId, Integer reservationId, Boolean active);

    @Query("""
            select r from ReservedSeat r
            where r.screening.id = ?1 and (r.reservation.id != ?2 or r.reservation.active = false)""")
    List<ReservedSeat> findReservedSeatsByScreeningIdExcludingActiveReservedSeatsByReservationId(Integer screeningId, Integer reservationId);
}