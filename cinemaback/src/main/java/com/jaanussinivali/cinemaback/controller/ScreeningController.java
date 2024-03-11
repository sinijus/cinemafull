package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.dto.ScreeningResponse;
import com.jaanussinivali.cinemaback.service.ScreeningsService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
