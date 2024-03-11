package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.Screening;
import com.jaanussinivali.cinemaback.repository.ScreeningRepository;
import jakarta.annotation.Resource;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    @Resource
    private ScreeningRepository screeningRepository;

    public List<Screening> findAllScreenings() {
        return screeningRepository.findAll();
    }
}
