package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.FilteredScreeningRequest;
import com.jaanussinivali.cinemaback.model.Screening;
import com.jaanussinivali.cinemaback.repository.ScreeningRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    @Resource
    private ScreeningRepository screeningRepository;

    public List<Screening> findAllScreenings() {
        return screeningRepository.findAll();
    }

    public List<Screening> findFilteredScreeningsMovieIds(FilteredScreeningRequest request) {
        return screeningRepository.findDateAndTimeFilteredScreenings(request.getStartDate(), request.getEndDate(), request.getStartTime(), request.getEndTime());
    }
}
