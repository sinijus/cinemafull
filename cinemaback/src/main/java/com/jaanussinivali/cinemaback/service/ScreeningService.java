package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.FilteredScreeningRequest;
import com.jaanussinivali.cinemaback.exception.DataNotFoundException;
import com.jaanussinivali.cinemaback.model.Screening;
import com.jaanussinivali.cinemaback.repository.ScreeningRepository;
import com.jaanussinivali.cinemaback.exception.Error;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScreeningService {

    @Resource
    private ScreeningRepository screeningRepository;

    public List<Screening> findFilteredScreeningsMovieIds(FilteredScreeningRequest request) {
        return screeningRepository.findDateAndTimeFilteredScreenings(request.getStartDate(), request.getEndDate(), request.getStartTime(), request.getEndTime());
    }

    public Screening findScreening(Integer screeningId) {
        Optional<Screening> screeningOptional = screeningRepository.findById(screeningId);
        if (screeningOptional.isEmpty())
            throw new DataNotFoundException(Error.SCREENING_NOT_FOUND.getMessage(), Error.SCREENING_NOT_FOUND.getErrorCode());
        else return screeningOptional.get();
    }

    public List<Screening> findFilteredScreeningsByMovieId(Integer movieId) {
        return screeningRepository.findScreeningsByMovieId(movieId);
    }

    public List<Screening> findScreeningsByMovieIdAndStartDate(Integer movieIdByGenres, LocalDate startDate) {
        return screeningRepository.findScreeningsByMovieIdAndStartDateOrdered(movieIdByGenres, startDate);
    }
}
