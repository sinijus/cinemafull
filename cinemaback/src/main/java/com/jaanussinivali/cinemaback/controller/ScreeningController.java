package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.service.ScreeningService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScreeningController {

    @Resource
    private ScreeningService screeningService;

    @GetMapping("/screenings")
    @Operation(summary = "Otsib kõik seanssid koos filmide infoga")
    public void findAllMovieScreenings() {
        screeningService.findAllMovieScreenings();
    }

}
