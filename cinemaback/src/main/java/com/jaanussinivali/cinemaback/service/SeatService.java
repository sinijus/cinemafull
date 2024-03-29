package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.ReservedSeat;
import com.jaanussinivali.cinemaback.model.Seat;
import com.jaanussinivali.cinemaback.repository.ReservedSeatRepository;
import com.jaanussinivali.cinemaback.repository.SeatRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Resource
    private SeatRepository seatRepository;

    @Resource
    private ReservedSeatRepository reservedSeatRepository;

    public List<Seat> findSeatsByHallId(Integer hallId) {
        return seatRepository.findAllSeatsByHallId(hallId);
    }


    public List<ReservedSeat> findReservedSeatsByScreeningId(Integer screeningId) {
        return reservedSeatRepository.findAllReservedSeatsByScreeningId(screeningId);
    }


    public void saveReservedSeat(ReservedSeat reservedSeat) {
        reservedSeatRepository.save(reservedSeat);
    }

    public void deletePreviouslyReservedSeatsByScreeningIdAndReservationIdFromActiveReservation(Integer screeningId, Integer reservationId) {
        List<ReservedSeat> reservedSeatList = reservedSeatRepository.findActiveReservedSeatsByScreeningIdAndReservationId(screeningId, reservationId, true);
        if (!reservedSeatList.isEmpty()) {
            for (ReservedSeat reservedSeat : reservedSeatList) {
                reservedSeatRepository.deleteById(reservedSeat.getId());
            }
        }
    }

    public List<ReservedSeat> findReservedSeatsByScreeningIdExcludingActiveReservedSeatsByReservationId(Integer screeningId, Integer reservationId) {
        return reservedSeatRepository.findReservedSeatsByScreeningIdExcludingActiveReservedSeatsByReservationId(screeningId, reservationId);
    }

    public List<Seat> findReservedSeatsByReservationId(Integer reservationId) {
        return reservedSeatRepository.findReservedSeatsByReservationId(reservationId);
    }

    public List<ReservedSeat> findReservedSeatsByScreeningIdAndReservationId(Integer screeningId, Integer reservationId) {
        return reservedSeatRepository.findReservedSeatsByScreeningIdAndReservationId(screeningId, reservationId);
    }
}
