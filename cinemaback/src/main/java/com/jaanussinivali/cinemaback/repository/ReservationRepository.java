package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


    @Query("select (count(r) > 0) from Reservation r " +
            "where r.cinemaUser.id = ?1 and r.screening.id = ?2 and r.active = ?3 ")
    boolean reservationWithUserIdAndScreeningIdAndActiveStatusExists(Integer userId, Integer screeningId, Boolean active);

    @Query("select r from Reservation r where r.cinemaUser.id = ?1 and r.screening.id = ?2 and r.active = ?3")
    Reservation findReservationByUserIdAndScreeningIdAndStatusActive(Integer userId, Integer screeningId, Boolean active);

    @Query("select r from Reservation r where r.cinemaUser.id = ?1 and r.active = false")
    List<Reservation> findCompletedReservationsByUserIdAndStatusNotActive(Integer id);
}