package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.model.Reservation;
import com.jaanussinivali.cinemaback.repository.ReservationRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Resource
    private ReservationRepository reservationRepository;

    public boolean activeReservationWithUserIdAndScreeningIdExists(Integer userId, Integer screeningId) {
        return reservationRepository.reservationWithUserIdAndScreeningIdAndActiveStatusExists(userId, screeningId, true);
    }

    public Reservation findReservationByUserIdAndScreeningId(Integer userId, Integer screeningId) {
        return reservationRepository.findReservationByUserIdAndScreeningIdAndStatusActive(userId, screeningId, true);
    }

    public void saveNewReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}

