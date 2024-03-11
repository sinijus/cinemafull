package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {

    @Query("select s from Screening s where s.date >= ?1 and s.date <=?2 " +
            "and s.time >= ?3 and s.time <= ?4"+
            "order by s.date, s.time")
    List<Screening> findDateAndTimeFilteredScreenings(LocalDate startDate,
                                                    LocalDate endDate,
                                                    LocalTime startTime,
                                                    LocalTime endTime
    );
}