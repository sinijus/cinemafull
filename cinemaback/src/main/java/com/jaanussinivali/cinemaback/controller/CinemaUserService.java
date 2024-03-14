package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.exception.DataNotFoundException;
import com.jaanussinivali.cinemaback.model.CinemaUser;
import com.jaanussinivali.cinemaback.model.CinemaUserRepository;
import com.jaanussinivali.cinemaback.util.ErrorMessage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CinemaUserService {
    @Resource
    private CinemaUserRepository cinemaUserRepository;

    public CinemaUser findUser(Integer userId) {
        Optional<CinemaUser> cinemaUserOptional = cinemaUserRepository.findById(userId);
        if (cinemaUserOptional.isEmpty()) {
            throw new DataNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage(), ErrorMessage.USER_NOT_FOUND.getErrorCode());
        }
        return cinemaUserOptional.get();
    }
}
