package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.dto.FilteredScreeningRequest;
import com.jaanussinivali.cinemaback.dto.ScreeningInfoResponse;
import com.jaanussinivali.cinemaback.dto.ScreeningListResponse;
import com.jaanussinivali.cinemaback.service.ScreeningsService;
import com.jaanussinivali.cinemaback.util.StringToDateTime;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScreeningController {

    @Resource
    private ScreeningsService screeningsService;

    @GetMapping("/filtered-screenings")
    @Operation(summary = """
            Otsib seansse koos filmide infoga,
            mis vastavad sisestatud rešissööri, žanri, keele, kellaaja ja/või vanusepiirangu väärtustele.
            Järjestab tulemused kuupäeva ning kellaaja järgi.
            """)
    public List<ScreeningListResponse> findFilteredMovieScreenings(@RequestParam(defaultValue = "00")
                                                              String startTime,
                                                                   @RequestParam(defaultValue = "24")
                                                              String endTime,
                                                                   @RequestParam(defaultValue = "2024-05-06")
                                                              String startDate,
                                                                   @RequestParam(defaultValue = "2024-05-12")
                                                              String endDate,
                                                                   @RequestParam(defaultValue = "0") @Min(0) Integer directorId,
                                                                   @RequestParam(defaultValue = "0") @Min(0) Integer genreId,
                                                                   @RequestParam(defaultValue = "0") @Min(0) Integer languageId,
                                                                   @RequestParam(defaultValue = "0") @Min(0) Integer restrictionId
    ) {
        FilteredScreeningRequest request = FilteredScreeningRequest.builder()
                .startTime(StringToDateTime.stringToLocalTime(startTime))
                .endTime(StringToDateTime.stringToLocalTime(endTime))
                .startDate(StringToDateTime.stringToLocalDate(startDate))
                .endDate(StringToDateTime.stringToLocalDate(endDate))
                .directorId(directorId)
                .genreId(genreId)
                .languageId(languageId)
                .restrictionId(restrictionId)
                .build();

        return screeningsService.findFilteredMovieScreenings(request);
    }

    @GetMapping("/screening")
    @Operation(summary = "Leiab kogu seanssi puudutava info seanssi id alusel")
    public ScreeningInfoResponse findMovieScreening(@RequestParam @Min(1) Integer screeningId) {
        return screeningsService.findMovieScreening(screeningId);
    }

    @GetMapping("/recommendations")
    @Operation(summary = "Soovitab kolme filmi vaadatud filmide žanri kaalude põhjal")
    public List<ScreeningListResponse> recommendMovies(@RequestParam(defaultValue = "")
                                                       List<Integer> watchedMovieIds,
                                                       @RequestParam(defaultValue = "3")
                                                       Integer nrOfMovieRecommendations,
                                                       @RequestParam(defaultValue = "2024-05-06")
                                                       String startDate
    ) {
        return screeningsService.recommendMovies(nrOfMovieRecommendations);
    }
}
