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
}
