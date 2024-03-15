package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.exception.DataNotFoundException;
import com.jaanussinivali.cinemaback.exception.Error;
import com.jaanussinivali.cinemaback.model.Reservation;
import com.jaanussinivali.cinemaback.repository.ReservationRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Reservation findReservation(Integer reservationId) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        if (reservationOptional.isEmpty()) {
            throw new DataNotFoundException(Error.RESERVATION_NOT_FOUND.getMessage(), Error.RESERVATION_NOT_FOUND.getErrorCode());
        }
        return reservationOptional.get();
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> findCompletedReservationsByUserId(Integer userId) {
        return reservationRepository.findCompletedReservationsByUserIdAndStatusNotActive(userId);
    }
}

