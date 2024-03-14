package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.exception.DataNotFoundException;
import com.jaanussinivali.cinemaback.model.CinemaUser;
import com.jaanussinivali.cinemaback.repository.CinemaUserRepository;
import com.jaanussinivali.cinemaback.exception.Error;
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
            throw new DataNotFoundException(Error.USER_NOT_FOUND.getMessage(), Error.USER_NOT_FOUND.getErrorCode());
        }
        return cinemaUserOptional.get();
    }
}
