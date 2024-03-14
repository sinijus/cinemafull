package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.model.Seat;
import com.jaanussinivali.cinemaback.repository.SeatRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Resource
    private SeatRepository seatRepository;

    public List<Seat> findSeatsByHallId(Integer hallId) {
        return seatRepository.findAllSeatsByHallId(hallId);
    }
}
