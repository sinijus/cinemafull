package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.dto.FilteredScreeningRequest;
import com.jaanussinivali.cinemaback.dto.ScreeningResponse;
import com.jaanussinivali.cinemaback.service.ScreeningsService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class ScreeningController {

    @Resource
    private ScreeningsService screeningsService;

    @GetMapping("/screenings")
    @Operation(summary = "Otsib kõik seanssid koos filmide infoga")
    public List<ScreeningResponse> findAllMovieScreenings() {
        return screeningsService.findAllMovieScreenings();
    }

    @GetMapping("/filtered-screenings")
    @Operation(summary = """
            Otsib seansse koos filmide infoga, 
            mis vastavad sisestatud rešissööri, žanri, keele, kellaaja ja/või vanusepiirangu väärtustele.
            """)
    public void findFilteredScreenings(@RequestParam(defaultValue = "0:00") LocalTime startTime,
                                       @RequestParam(defaultValue = "24:00") LocalTime endTime,
                                       @RequestParam(defaultValue = "2024-05-06") LocalDate startDate,
                                       @RequestParam(defaultValue = "2024-05-12") LocalDate endDate,
                                       @RequestParam(defaultValue = "0") Integer directorId,
                                       @RequestParam(defaultValue = "0") Integer genreId,
                                       @RequestParam(defaultValue = "0") Integer languageId,
                                       @RequestParam(defaultValue = "0") Integer restrictionId
    ) {
        FilteredScreeningRequest request = FilteredScreeningRequest.builder()
                .startTime(startTime)
                .endTime(endTime)
                .startDate(startDate)
                .endDate(endDate)
                .directorId(directorId)
                .genreId(genreId)
                .languageId(languageId)
                .restrictionId(restrictionId)
                .build();

        screeningsService.findFilteredScreenings(request);
    }
}
