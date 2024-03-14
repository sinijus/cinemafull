package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.exception.DataNotFoundException;
import com.jaanussinivali.cinemaback.model.Hall;
import com.jaanussinivali.cinemaback.repository.HallRepository;
import com.jaanussinivali.cinemaback.util.ErrorMessage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HallService {
    @Resource
    private HallRepository hallRepository;

    public Hall findHall(Integer hallId) {
        Optional<Hall> hallOptional = hallRepository.findById(hallId);
        if (hallOptional.isEmpty()) {
            throw new DataNotFoundException(ErrorMessage.HALL_NOT_FOUND.getMessage(), ErrorMessage.HALL_NOT_FOUND.getErrorCode());
        }
        return hallOptional.get();
    }
}
